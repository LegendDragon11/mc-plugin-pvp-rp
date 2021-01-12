package org.legenddragon.craftattack.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.legenddragon.craftattack.craftattack;

public class onInventoryInteract implements Listener {

    public craftattack plugin;

    public onInventoryInteract(craftattack plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(InventoryClickEvent e) {

        try {
            Player p = (Player) e.getWhoClicked();

            Inventory inv = e.getClickedInventory();

            Material t = e.getCurrentItem().getType();

            // Elytra ItemStack
            ItemStack Elytra = new ItemStack(Material.ELYTRA);
            ItemMeta ElytraMeta = Elytra.getItemMeta();
            ElytraMeta.setDisplayName(p.getUniqueId().toString());
            Elytra.setAmount(1);
            Elytra.setItemMeta(ElytraMeta);

            if ( e.getWhoClicked() != Bukkit.getPlayer(p.getName())) { return; }
            if ( e.getCurrentItem().getItemMeta().getDisplayName().equals(Elytra.getItemMeta().getDisplayName())) {
                e.setCancelled(true);
            }

        } catch (Exception e1) {
            return;
        }
        return;
    }
}
