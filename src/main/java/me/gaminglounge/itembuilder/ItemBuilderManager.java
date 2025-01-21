package me.gaminglounge.itembuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.bukkit.NamespacedKey;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;

public class ItemBuilderManager {
    
    public static final NamespacedKey blockPlaceEvent = new NamespacedKey("itembuilder", "block_place_event");
    public static final NamespacedKey blockBreakEvent = new NamespacedKey("itembuilder", "block_break_event");
    public static final NamespacedKey bothClickEvent = new NamespacedKey("itembuilder", "both_click_event");
    public static final NamespacedKey leftClickEvent = new NamespacedKey("itembuilder", "left_click_event");
    public static final NamespacedKey rightClickEvent = new NamespacedKey("itembuilder", "right_click_event");
    public static final NamespacedKey dropEvent = new NamespacedKey("itembuilder", "drop_event");
    public static final NamespacedKey withItemBreakBlockEvent = new NamespacedKey("itembuilder", "with_item_break_block_event");
    public static final NamespacedKey itemBreakEvent = new NamespacedKey("itembuilder", "item_break_event");

    private final Map<String, Consumer<BlockPlaceEvent>> blockPlaceHandlerMap;
    private final Map<String, Consumer<BlockBreakEvent>> blockBreakHandlerMap;
    private final Map<String, Consumer<InventoryClickEvent>> bothClickEventMap;
    private final Map<String, Consumer<InventoryClickEvent>> leftClickEventMap;
    private final Map<String, Consumer<InventoryClickEvent>> rightClickEventMap;
    private final Map<String, Consumer<PlayerDropItemEvent>> dropEventMap;
    private final Map<String, Consumer<BlockBreakEvent>> withItemBreakBlockHandlerMap;
    private final Map<String, Consumer<PlayerItemBreakEvent>> itemBreakEventMap;

    public ItemBuilderManager() {
        blockPlaceHandlerMap = new HashMap<>();
        blockBreakHandlerMap = new HashMap<>();
        bothClickEventMap = new HashMap<>();
        leftClickEventMap = new HashMap<>();
        rightClickEventMap = new HashMap<>();
        dropEventMap = new HashMap<>();
        withItemBreakBlockHandlerMap = new HashMap<>();
        itemBreakEventMap = new HashMap<>();
    }

    public static void addBlockPlaceEvent(String pdv, Consumer<BlockPlaceEvent> event) {
        ItemBuilderMain.INSTANCE.manager.blockPlaceHandlerMap.put(pdv, event);
    }

    public static Consumer<BlockPlaceEvent> getBlockPlaceEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.blockPlaceHandlerMap.get(pdv);
    }

    public static void addBlockBreakEvent(String pdv, Consumer<BlockBreakEvent> event) {
        ItemBuilderMain.INSTANCE.manager.blockBreakHandlerMap.put(pdv, event);
    }

    public static Consumer<BlockBreakEvent> getBlockBreakEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.blockBreakHandlerMap.get(pdv);
    }

    public static void addBothClickEvent(String pdv, Consumer<InventoryClickEvent> event) {
        ItemBuilderMain.INSTANCE.manager.bothClickEventMap.put(pdv, event);
    }

    public static Consumer<InventoryClickEvent> getBothClickEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.bothClickEventMap.get(pdv);
    }

    public static void addLeftClickEvent(String pdv, Consumer<InventoryClickEvent> event) {
        ItemBuilderMain.INSTANCE.manager.leftClickEventMap.put(pdv, event);
    }

    public static Consumer<InventoryClickEvent> getLeftClickEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.leftClickEventMap.get(pdv);
    }

    public static void addRightClickEvent(String pdv, Consumer<InventoryClickEvent> event) {
        ItemBuilderMain.INSTANCE.manager.rightClickEventMap.put(pdv, event);
    }

    public static Consumer<InventoryClickEvent> getRightClickEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.rightClickEventMap.get(pdv);
    }

    public static void addDropEvent(String pdv, Consumer<PlayerDropItemEvent> event) {
        ItemBuilderMain.INSTANCE.manager.dropEventMap.put(pdv, event);
    }

    public static Consumer<PlayerDropItemEvent> getDropEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.dropEventMap.get(pdv);
    }

    public static void addItemBreakBlockEvent(String pdv, Consumer<BlockBreakEvent> event) {
        ItemBuilderMain.INSTANCE.manager.withItemBreakBlockHandlerMap.put(pdv, event);
    }

    public static Consumer<BlockBreakEvent> getItemBreakBlockEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.withItemBreakBlockHandlerMap.get(pdv);
    }

    public static void addItemBreakEvent(String pdv, Consumer<PlayerItemBreakEvent> event) {
        ItemBuilderMain.INSTANCE.manager.itemBreakEventMap.put(pdv, event);
    }

    public static Consumer<PlayerItemBreakEvent> getItemBreakEvent(String pdv) {
        return ItemBuilderMain.INSTANCE.manager.itemBreakEventMap.get(pdv);
    }
}
