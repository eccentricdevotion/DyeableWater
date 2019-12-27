package me.eccentric_nz.dyeablewater;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DyeableWater extends JavaPlugin {

    @Override
    public void onDisable() {
        // TODO: Place any custom disable code here.
    }

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new DyeableWaterListener(this), this);
        pm.registerEvents(new DyeableWaterBucketListener(this), this);
        pm.registerEvents(new DyeableWaterItemListener(this), this);
    }
}
