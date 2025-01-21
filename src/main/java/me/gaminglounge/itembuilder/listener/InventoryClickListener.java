package me.gaminglounge.itembuilder.listener;

import java.util.function.Consumer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.gaminglounge.itembuilder.ItemBuilderManager;

public class InventoryClickListener implements Listener {
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getItemMeta() == null) return;
        PersistentDataContainer container = e.getCurrentItem().getItemMeta().getPersistentDataContainer();

        String pdv;
        if (container.has(ItemBuilderManager.bothClickEvent)) {
            pdv = container.get(ItemBuilderManager.bothClickEvent, PersistentDataType.STRING);
            Consumer<InventoryClickEvent> ev = ItemBuilderManager.getBothClickEvent(pdv);
            if (ev != null) {
                ev.accept(e);
            }
        } else {
            if (e.isRightClick()) {
                if (!container.has(ItemBuilderManager.rightClickEvent)) return;
                pdv = container.get(ItemBuilderManager.rightClickEvent, PersistentDataType.STRING);
                Consumer<InventoryClickEvent> ev2 = ItemBuilderManager.getRightClickEvent(pdv);
                if (ev2 != null) {
                    ev2.accept(e);
                } 
            }
            if (e.isLeftClick()) {
                if (!container.has(ItemBuilderManager.leftClickEvent)) return;
                pdv = container.get(ItemBuilderManager.leftClickEvent, PersistentDataType.STRING);
                Consumer<InventoryClickEvent> ev3 = ItemBuilderManager.getLeftClickEvent(pdv);
                if (ev3 != null) {
                    ev3.accept(e);
                } 
            }
        }
    }
}
