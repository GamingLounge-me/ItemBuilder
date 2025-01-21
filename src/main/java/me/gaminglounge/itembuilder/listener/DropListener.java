package me.gaminglounge.itembuilder.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.gaminglounge.itembuilder.ItemBuilderManager;

public class DropListener implements Listener{
    
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        PersistentDataContainer container = e.getItemDrop().getItemStack().getItemMeta().getPersistentDataContainer();
        if (!container.has(ItemBuilderManager.dropEvent)) return;

        String pdv = container.get(ItemBuilderManager.dropEvent, PersistentDataType.STRING);
        var ev = ItemBuilderManager.getDropEvent(pdv);

        if (ev != null) {
            ev.accept(e);
        }
    }

}
