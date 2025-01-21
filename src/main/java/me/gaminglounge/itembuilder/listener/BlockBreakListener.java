package me.gaminglounge.itembuilder.listener;

import java.util.function.Consumer;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Marker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.gaminglounge.itembuilder.ItemBuilderManager;

public class BlockBreakListener implements Listener {

    public static final NamespacedKey blockEventID = new NamespacedKey("itembuilder", "block_event_identifier");

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        PersistentDataContainer container = e.getItemInHand().getItemMeta().getPersistentDataContainer();
        if (!container.has(ItemBuilderManager.blockBreakEvent)) return;

        String pdv = container.get(ItemBuilderManager.blockBreakEvent, PersistentDataType.STRING);
        Entity et = e.getBlock().getWorld().spawnEntity(e.getBlock().getLocation(), EntityType.MARKER);
        et.getPersistentDataContainer().set(blockEventID, PersistentDataType.STRING, pdv);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        for (Entity et : e.getBlock().getLocation().getNearbyEntities(0.1, 0.1, 0.1)) {
            if (et instanceof Marker) {
                PersistentDataContainer container = et.getPersistentDataContainer();
                if (!container.has(blockEventID)) continue;

                String pdv = container.get(blockEventID, PersistentDataType.STRING);
                Consumer<BlockBreakEvent> ev = ItemBuilderManager.getBlockBreakEvent(pdv);
                if (ev != null) {
                    ev.accept(e);
                }
            }
        }
    }
    
}
