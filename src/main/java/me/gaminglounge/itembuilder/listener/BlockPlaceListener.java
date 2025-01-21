package me.gaminglounge.itembuilder.listener;

import java.util.function.Consumer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.gaminglounge.itembuilder.ItemBuilderManager;

public class BlockPlaceListener implements Listener{

    @EventHandler
    public void onPlaceBlock(BlockPlaceEvent e) {
        PersistentDataContainer container = e.getItemInHand().getItemMeta().getPersistentDataContainer();
        if (!container.has(ItemBuilderManager.blockPlaceEvent)) return;

        String pdv = container.get(ItemBuilderManager.blockPlaceEvent, PersistentDataType.STRING);
        Consumer<BlockPlaceEvent> ev = ItemBuilderManager.getBlockPlaceEvent(pdv);

        if (ev != null) {
            ev.accept(e);
        }
    }
}
