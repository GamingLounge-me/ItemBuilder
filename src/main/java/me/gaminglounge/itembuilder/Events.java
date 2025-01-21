package me.gaminglounge.itembuilder;

public class Events {

    public Events() {

        ItemBuilderManager.addBothClickEvent("ItemBuilder:close", (e) -> {
            e.setCancelled(true);
            e.getWhoClicked().closeInventory();
        });

    }
    
}
