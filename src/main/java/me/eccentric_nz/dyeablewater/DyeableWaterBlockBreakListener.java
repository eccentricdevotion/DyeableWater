package me.eccentric_nz.dyeablewater;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DyeableWaterBlockBreakListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onInteract(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType().equals(Material.MUSHROOM_STEM)) {
            String data = block.getBlockData().getAsString();
            // must have correct block data
            Integer model = DyeableWaterBlockData.DATA_TO_MODEL.get(data);
            if (model != null) {
                // drop a cauldron
                block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.CAULDRON, 1));
            }
        }
    }
}
