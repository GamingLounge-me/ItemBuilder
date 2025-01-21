package me.gaminglounge.itembuilder; 
 
import org.bukkit.plugin.PluginManager; 
import org.bukkit.plugin.java.JavaPlugin;

import me.gaminglounge.itembuilder.listener.BlockBreakListener;
import me.gaminglounge.itembuilder.listener.BlockPlaceListener; 
import me.gaminglounge.itembuilder.listener.DropListener;
import me.gaminglounge.itembuilder.listener.InventoryClickListener;
import me.gaminglounge.itembuilder.listener.ItemBreakListener;
import me.gaminglounge.itembuilder.listener.WithItemBreakBlockListener;
 
public final class ItemBuilderMain extends JavaPlugin { 
 
    public static ItemBuilderMain INSTANCE;
    public ItemBuilderManager manager;
 
    @Override
    public void onLoad() {
        INSTANCE = this; 
        manager = new ItemBuilderManager();
        new Events();
    }

    @Override
    public void onEnable() {
        this.listener();
    }

    @Override
    public void onDisable() {
        
    }

    public void listener() {
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(new BlockPlaceListener(), this);
        pm.registerEvents(new BlockBreakListener(), this);
        pm.registerEvents(new DropListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new ItemBreakListener(), this);
        pm.registerEvents(new WithItemBreakBlockListener(), this);
    } 
} 
