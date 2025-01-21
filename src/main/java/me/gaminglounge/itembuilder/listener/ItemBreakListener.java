package me.gaminglounge.itembuilder.listener;

import java.util.function.Consumer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.gaminglounge.itembuilder.ItemBuilderManager;

public class ItemBreakListener implements Listener {

    @EventHandler
    public void onBreak(PlayerItemBreakEvent e) {
        PersistentDataContainer container = e.getBrokenItem().getItemMeta().getPersistentDataContainer();
        if (!container.has(ItemBuilderManager.itemBreakEvent)) return;

        String pdv = container.get(ItemBuilderManager.itemBreakEvent, PersistentDataType.STRING);
        Consumer<PlayerItemBreakEvent> ev = ItemBuilderManager.getItemBreakEvent(pdv);

        if (ev != null) {
            ev.accept(e);
        }

    }
    
}
