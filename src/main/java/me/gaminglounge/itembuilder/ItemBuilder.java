package me.gaminglounge.itembuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.destroystokyo.paper.profile.PlayerProfile;

import net.kyori.adventure.text.Component;

public class ItemBuilder {
    public ItemStack item;
    private ItemMeta meta;
    private PersistentDataContainer container;
    public List<Component> lore;

    public ItemBuilder(Material material) {
        if (material == null) {
            throw new IllegalArgumentException("Material may not be null");
        }

        lore = new ArrayList<>();

        item = new ItemStack(material);
        meta = item.getItemMeta();
        container = meta.getPersistentDataContainer();
    }

    public ItemBuilder(UUID playerUUID) {
        lore = new ArrayList<>();

        item = new ItemStack(Material.PLAYER_HEAD);
        meta = item.getItemMeta();
        container = meta.getPersistentDataContainer();

        if (playerUUID != null) {
            SkullMeta skullMeta = (SkullMeta) meta;
            OfflinePlayer p = Bukkit.getOfflinePlayer(playerUUID);
            PlayerProfile prof = p.getPlayerProfile();
            if (!prof.isComplete()) {
                prof.complete();
            }
            skullMeta.setPlayerProfile(prof);
            meta = skullMeta;
        }
    }

    public ItemBuilder setName(Component name) {
        if (name != null) meta.displayName(name);
        return this;
    }

    public ItemBuilder setGlint(boolean glint) {
        if (glint) {
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return this;
    }

    public ItemBuilder setLore(List<Component> itemLore) {
        lore = itemLore;
        return this;
    }

    public ItemBuilder addLoreLine(Component loreLine) {
        lore.add(loreLine);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment,int level) {
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder addBlockPlaceEvent(String pdv) {
        addID(ItemBuilderManager.blockPlaceEvent, pdv);
        return this;
    }

    public ItemBuilder addBlockBreakEvent(String pdv) {
        addID(ItemBuilderManager.blockBreakEvent, pdv);
        return this;
    }

    public ItemBuilder addBothClickEvent(String pdv) {
        addID(ItemBuilderManager.bothClickEvent, pdv);
        return this;
    }

    public ItemBuilder addleftClickEvent(String pdv) {
        addID(ItemBuilderManager.leftClickEvent, pdv);
        return this;
    }

    public ItemBuilder addRightClickEvent(String pdv) {
        addID(ItemBuilderManager.rightClickEvent, pdv);
        return this;
    }

    public ItemBuilder addDropEvent(String pdv) {
        addID(ItemBuilderManager.dropEvent, pdv);
        return this;
    }

    public ItemBuilder addWithItemBreakBlockEvent(String pdv) {
        addID(ItemBuilderManager.withItemBreakBlockEvent, pdv);
        return this;
    }

    public ItemBuilder addItemBreakEvent(String pdv) {
        addID(ItemBuilderManager.itemBreakEvent, pdv);
        return this;
    }

    public ItemStack build() {
        if (lore != null) meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    }

    private void addID(NamespacedKey key, String pdv) {
        if (!container.has(key)) {
            container.set(
                key,
                PersistentDataType.STRING,
                pdv
                );
        } else {
            throw new IllegalStateException("Tryed to double register an event.");
        }
    }

}
