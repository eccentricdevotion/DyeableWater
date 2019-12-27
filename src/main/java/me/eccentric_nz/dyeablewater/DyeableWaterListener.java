package me.eccentric_nz.dyeablewater;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
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
                        int key = DyeableWaterUtilities.getKey(is.getType(), cauldron.getLevel());
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
                            Sound sound = Sound.ITEM_BUCKET_EMPTY;
                            if (is.getType().equals(Material.WATER_BUCKET)) {
                                // fill to level 3
                                stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model + 3));
                                // change the water bucket to an empty bucket
                                ItemStack bucket = new ItemStack(Material.BUCKET);
                                player.getInventory().setItemInMainHand(bucket);
                                player.updateInventory();
                            } else if (is.getType().equals(Material.POTION) && cauldron.getLevel() == 0) {
                                // fill to level 1
                                stem = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(model + 1));
                                sound = Sound.ITEM_BOTTLE_EMPTY;
                            }
                            if (stem != null) {
                                player.playSound(player.getLocation(), sound, 1.0F, 1.0F);
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
                        if (model != null && model != 999) {
                            BlockData stem;
                            Color color = DyeableWaterUtilities.getColor(base);
                            if (color != null) {
                                player.playSound(player.getLocation(), "cauldron.dye", 1.0F, 1.0F);
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
                    } else if (is.getType().equals(Material.GLASS_BOTTLE) && model != 999) {
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
                        player.playSound(player.getLocation(), Sound.ITEM_BOTTLE_FILL, 1.0F, 1.0F);
                        ItemStack potion = new ItemStack(Material.POTION);
                        ItemMeta potionMeta = potion.getItemMeta();
                        potionMeta.setDisplayName(DyeableWaterUtilities.getColorName(base) + " Dyed Water");
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
                    } else if (is.getType().equals(Material.BUCKET) && (currentLevel == 3 || model == 999)) {
                        // revert to an empty cauldron
                        BlockData cauldronBlockData = Material.CAULDRON.createBlockData();
                        block.setBlockData(cauldronBlockData);
                        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            player.playSound(player.getLocation(), Sound.ITEM_BUCKET_FILL, 1.0F, 1.0F);
                            // change the bucket to a dyed water bucket / lava bucket
                            ItemStack filledBucket;
                            if (model == 999) {
                                filledBucket = new ItemStack(Material.LAVA_BUCKET);
                            } else {
                                filledBucket = new ItemStack(Material.WATER_BUCKET);
                                ItemMeta bucketMeta = filledBucket.getItemMeta();
                                bucketMeta.setDisplayName(DyeableWaterUtilities.getColorName(base) + " Dyed Water Bucket");
                                bucketMeta.setCustomModelData(10000000 + base);
                                filledBucket.setItemMeta(bucketMeta);
                            }
                            player.getInventory().setItemInMainHand(filledBucket);
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
                            player.playSound(player.getLocation(), Sound.ITEM_BOTTLE_EMPTY, 1.0F, 1.0F);
                            player.getInventory().setItemInMainHand(glassBottle);
                            player.updateInventory();
                        }
                    }
                }
            }
        }
    }
}
