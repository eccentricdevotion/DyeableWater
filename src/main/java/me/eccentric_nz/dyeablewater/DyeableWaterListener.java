package me.eccentric_nz.dyeablewater;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class DyeableWaterListener implements Listener {

    private final DyeableWater plugin;
    private final List<Material> dyes = new ArrayList<>();
    private final List<Material> armour = new ArrayList<>();

    public DyeableWaterListener(DyeableWater plugin) {
        this.plugin = plugin;
        dyes.add(Material.WHITE_DYE);
        dyes.add(Material.ORANGE_DYE);
        dyes.add(Material.MAGENTA_DYE);
        dyes.add(Material.YELLOW_DYE);
        dyes.add(Material.LIGHT_BLUE_DYE);
        dyes.add(Material.LIME_DYE);
        dyes.add(Material.PINK_DYE);
        dyes.add(Material.GRAY_DYE);
        dyes.add(Material.LIGHT_GRAY_DYE);
        dyes.add(Material.CYAN_DYE);
        dyes.add(Material.PURPLE_DYE);
        dyes.add(Material.BLUE_DYE);
        dyes.add(Material.BROWN_DYE);
        dyes.add(Material.GREEN_DYE);
        dyes.add(Material.RED_DYE);
        dyes.add(Material.BLACK_DYE);
        armour.add(Material.LEATHER_BOOTS);
        armour.add(Material.LEATHER_CHESTPLATE);
        armour.add(Material.LEATHER_HELMET);
        armour.add(Material.LEATHER_LEGGINGS);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("dyeablewater.use") && event.getHand().equals(EquipmentSlot.HAND)) {
            Block block = event.getClickedBlock();
            if (block == null) {
                return;
            }
            // get item in main hand
            ItemStack is = player.getInventory().getItemInMainHand();
            if (is != null) {
                if (block.getType().equals(Material.CAULDRON)) {
                    // cauldron must have water in it
                    Levelled cauldron = (Levelled) block.getBlockData();
                    // DYE
                    if (dyes.contains(is.getType())) {
                        if (cauldron.getLevel() < 1) {
                            // no water
                            return;
                        }
                        // dye the water
                        int key = getKey(is.getType(), cauldron.getLevel());
                        if (key != 0) {
                            BlockData stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(key));
                            block.setBlockData(stem);
                            // remove one dye
                            return;
                        }
                    }
                    if (is.hasItemMeta()) {
                        ItemMeta im = is.getItemMeta();
                        if (im.hasCustomModelData()) {
                            // get the model - could be 0 -> 150 in multiples of 10
                            int model = im.getCustomModelData() - 10000000;
                            BlockData stem = null;
                            if (is.getType().equals(Material.WATER_BUCKET)) {
                                // fill to level 3
                                stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model + 3));
                            } else if (is.getType().equals(Material.POTION) && cauldron.getLevel() == 0) {
                                // fill to level 1
                                stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model + 1));
                            }
                            if (stem != null) {
                                BlockData finalStem = stem;
                                plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                    block.setBlockData(finalStem);
                                }, 2L);
                            }
                            return;
                        }
                    }
                }
                if (block.getType().equals(Material.MUSHROOM_STEM)) {
                    String data = block.getBlockData().getAsString();
                    // must have correct block data
                    Integer model = DyeableWaterBlockData.DATA_TO_MODEL.get(data);
                    int currentLevel = model % 10;
                    int base = model - currentLevel;
                    if (armour.contains(is.getType())) {
                        if (model != null) {
                            BlockData stem;
                            Color color = getColor(base);
                            if (color != null) {
                                // dye the armour
                                LeatherArmorMeta lam = (LeatherArmorMeta) is.getItemMeta();
                                lam.setColor(color);
                                is.setItemMeta(lam);
                                player.updateInventory();
                                if (currentLevel - 1 > 0) {
                                    // reduce the water level
                                    stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model - 1));
                                } else {
                                    // revert to an empty cauldron
                                    stem = Material.CAULDRON.createBlockData();
                                }
                                block.setBlockData(stem);
                            }
                        }
                    } else if (is.getType().equals(Material.GLASS_BOTTLE)) {
                        BlockData stem;
                        // reduce cauldron level by one
                        if (currentLevel - 1 > 0) {
                            // reduce the water level
                            stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model - 1));
                        } else {
                            // revert to an empty cauldron
                            stem = Material.CAULDRON.createBlockData();
                        }
                        block.setBlockData(stem);
                        // change the glass bottle to a dyed potion
                        ItemStack potion = new ItemStack(Material.POTION);
                        ItemMeta potionMeta = potion.getItemMeta();
                        potionMeta.setDisplayName(getColorName(base) + " Dyed Water");
                        potionMeta.setCustomModelData(10000000 + base);
                        potionMeta.addItemFlags(ItemFlag.values());
                        potion.setItemMeta(potionMeta);
                        // remove a glass bottle
                        if (is.getAmount() > 1) {
                            player.getInventory().addItem(potion);
                            is.setAmount(is.getAmount() - 1);
                        } else {
                            player.getInventory().setItemInMainHand(potion);
                        }
                        player.updateInventory();
                    } else if (is.getType().equals(Material.BUCKET) && currentLevel == 3) {
                        // revert to an empty cauldron
                        BlockData cauldronBlockData = Material.CAULDRON.createBlockData();
                        block.setBlockData(cauldronBlockData);
                        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            // change the bucket to a dyed water bucket
                            ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET);
                            ItemMeta bucketMeta = waterBucket.getItemMeta();
                            bucketMeta.setDisplayName(getColorName(base) + " Dyed Water Bucket");
                            bucketMeta.setCustomModelData(10000000 + base);
                            waterBucket.setItemMeta(bucketMeta);
                            player.getInventory().setItemInMainHand(waterBucket);
                            player.updateInventory();
                        }, 2L);
                    } else if (is.getType().equals(Material.POTION) && is.hasItemMeta() && currentLevel < 3) {
                        // must be same dye color
                        ItemMeta pim = is.getItemMeta();
                        if (pim.hasCustomModelData() && pim.getCustomModelData() == (10000000 + base)) {
                            // add another water level
                            BlockData stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model + 1));
                            block.setBlockData(stem);
                            // change the potion to a glass bottle
                            ItemStack glassBottle = new ItemStack(Material.GLASS_BOTTLE);
                            player.getInventory().setItemInMainHand(glassBottle);
                            player.updateInventory();
                        }
                    }
                }
            }
        }
    }

    private int getKey(Material material, int level) {
        switch (material) {
            case WHITE_DYE:
                return level;
            case ORANGE_DYE:
                return 10 + level;
            case MAGENTA_DYE:
                return 20 + level;
            case YELLOW_DYE:
                return 30 + level;
            case LIGHT_BLUE_DYE:
                return 40 + level;
            case LIME_DYE:
                return 50 + level;
            case PINK_DYE:
                return 60 + level;
            case GRAY_DYE:
                return 70 + level;
            case LIGHT_GRAY_DYE:
                return 80 + level;
            case CYAN_DYE:
                return 90 + level;
            case PURPLE_DYE:
                return 100 + level;
            case BLUE_DYE:
                return 110 + level;
            case BROWN_DYE:
                return 120 + level;
            case GREEN_DYE:
                return 130 + level;
            case RED_DYE:
                return 140 + level;
            case BLACK_DYE:
                return 150 + level;
            default:
                return 0;
        }
    }

    private Color getColor(int i) {
        switch (i) {
            case 0:
                return Color.WHITE;
            case 10:
                return Color.ORANGE;
            case 20:
                return Color.MAROON;
            case 30:
                return Color.YELLOW;
            case 40:
                return Color.AQUA;
            case 50:
                return Color.LIME;
            case 60:
                return Color.FUCHSIA;
            case 70:
                return Color.GRAY;
            case 80:
                return Color.SILVER;
            case 90:
                return Color.TEAL;
            case 100:
                return Color.PURPLE;
            case 110:
                return Color.BLUE;
            case 120:
                return Color.OLIVE;
            case 130:
                return Color.GREEN;
            case 140:
                return Color.RED;
            case 150:
                return Color.BLACK;
        }
        return null;
    }

    private String getColorName(int i) {
        switch (i) {
            case 0:
                return "White";
            case 10:
                return "Orange";
            case 20:
                return "Magenta";
            case 30:
                return "Yellow";
            case 40:
                return "Light Blue";
            case 50:
                return "Lime";
            case 60:
                return "Pink";
            case 70:
                return "Gray";
            case 80:
                return "Lihgt Gray";
            case 90:
                return "Cyan";
            case 100:
                return "Purple";
            case 110:
                return "Blue";
            case 120:
                return "Brown";
            case 130:
                return "Green";
            case 140:
                return "Red";
            case 150:
                return "Black";
        }
        return "";
    }
}
