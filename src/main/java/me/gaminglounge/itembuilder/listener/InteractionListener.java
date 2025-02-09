package me.gaminglounge.itembuilder.listener;

import java.util.function.Consumer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.gaminglounge.itembuilder.ItemBuilderManager;

public class InteractionListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if (e.getItem() == null || e.getItem().getItemMeta() == null)
            return;
        PersistentDataContainer container = e.getItem().getItemMeta().getPersistentDataContainer();

        String pdv;
        if (container.has(ItemBuilderManager.bothInteractionEvent)) {
            pdv = container.get(ItemBuilderManager.bothInteractionEvent, PersistentDataType.STRING);
            Consumer<PlayerInteractEvent> ev = ItemBuilderManager.getBothInteractionEvent(pdv);
            if (ev != null) {
                ev.accept(e);
            }
        } else {
            if (e.getAction().isRightClick()) {
                if (!container.has(ItemBuilderManager.rightInteractionEvent))
                    return;
                pdv = container.get(ItemBuilderManager.rightInteractionEvent, PersistentDataType.STRING);
                Consumer<PlayerInteractEvent> ev2 = ItemBuilderManager.getRightInteractionEvent(pdv);
                if (ev2 != null) {
                    ev2.accept(e);
                }
            }
            if (e.getAction().isLeftClick()) {
                if (!container.has(ItemBuilderManager.leftInteractionEvent))
                    return;
                pdv = container.get(ItemBuilderManager.leftInteractionEvent, PersistentDataType.STRING);
                Consumer<PlayerInteractEvent> ev3 = ItemBuilderManager.getLeftInteractionEvent(pdv);
                if (ev3 != null) {
                    ev3.accept(e);
                }
            }
        }
    }

}
