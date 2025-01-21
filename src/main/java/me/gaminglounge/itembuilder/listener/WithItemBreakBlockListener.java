package me.gaminglounge.itembuilder.listener;

import java.util.function.Consumer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataType;

import io.papermc.paper.persistence.PersistentDataContainerView;
import me.gaminglounge.itembuilder.ItemBuilderManager;

public class WithItemBreakBlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        PersistentDataContainerView container = player.getInventory().getItem(player.getActiveItemHand()).getPersistentDataContainer();

        if (container.has(ItemBuilderManager.withItemBreakBlockEvent)) {
            String pdv = container.get(ItemBuilderManager.withItemBreakBlockEvent, PersistentDataType.STRING);
            Consumer<BlockBreakEvent> ev = ItemBuilderManager.getItemBreakBlockEvent(pdv);

            if (ev != null) {
                ev.accept(e);
            }
        }
    }
}
