package me.gaminglounge;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.destroystokyo.paper.profile.PlayerProfile;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class ItemBuilder {

    MiniMessage mm;

    private Material material;
    private Component name;
    private List<Component> lore;
    private UUID skullPlayerUUID;
    private boolean glint;

    public ItemBuilder() {
        mm = MiniMessage.miniMessage();
        lore = new ArrayList<>();
    }

    public ItemBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }
    
    public ItemBuilder setSkull(UUID playerUUID) {
        this.skullPlayerUUID = playerUUID;
        return this;
    }

    public ItemBuilder setName(Component name) {
        this.name = name;
        return this;
    }

    public ItemBuilder setGlint(boolean glint) {
        this.glint = glint;
        return this;
    }

    public ItemBuilder setLore(List<Component> itemLore) {
        lore = itemLore;
        return this;
    }

    public ItemBuilder addLoreLine(String loreLine) {
        lore.add(mm.deserialize(loreLine).decoration(TextDecoration.ITALIC, false));
        return this;
    }

    public ItemBuilder addLoreLine(Component loreLine) {
        lore.add(loreLine);
        return this;
    }

    public ItemStack build() {
        if (skullPlayerUUID != null) {
            material = Material.PLAYER_HEAD;
        } else if (material == null) {
            throw new IllegalArgumentException("Material may not be null");
        }
        ItemStack item = new ItemStack(material);
            
        if (skullPlayerUUID != null) {
            SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
            OfflinePlayer p = Bukkit.getOfflinePlayer(skullPlayerUUID);
            PlayerProfile prof = p.getPlayerProfile();
            if (!prof.isComplete()) {
                prof.complete();
            }
            skullMeta.setPlayerProfile(prof);
            item.setItemMeta(skullMeta);
        }
        ItemMeta meta = item.getItemMeta();
        if (name != null) meta.displayName(name);
        if (glint) {
            meta.addEnchant(Enchantment.UNBREAKING, 10, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        if (lore != null) meta.lore(lore);
        item.setItemMeta(meta);
        return item;
    } 

}
