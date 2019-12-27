package me.eccentric_nz.dyeablewater;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;

public class DyeableWaterBucketListener implements Listener {

    private final DyeableWater plugin;

    public DyeableWaterBucketListener(DyeableWater plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onWaterPlace(PlayerBucketEmptyEvent event) {
        Block block = event.getBlockClicked();
        if (block.getType().equals(Material.MUSHROOM_STEM)) {
            String data = block.getBlockData().getAsString();
            // must have correct block data
            Integer model = DyeableWaterBlockData.DATA_TO_MODEL.get(data);
            if (model != null) {
                event.setCancelled(true);
            }
        }
        if (block.getType().equals(Material.CAULDRON) && event.getBucket().equals(Material.LAVA_BUCKET)) {
            Player player = event.getPlayer();
            event.setCancelled(true);
            player.playSound(player.getLocation(), Sound.ITEM_BUCKET_EMPTY_LAVA, 1.0F, 1.0F);
            // change the lava bucket to an empty bucket
            ItemStack bucket = new ItemStack(Material.BUCKET);
            player.getInventory().setItemInMainHand(bucket);
            player.updateInventory();
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                BlockData lava = plugin.getServer().createBlockData(DyeableWaterBlockData.MODEL_TO_DATA.get(999));
                block.setBlockData(lava);
            }, 2L);
        }
    }
}
