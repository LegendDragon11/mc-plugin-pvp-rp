package org.legenddragon.craftattack.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.legenddragon.craftattack.craftattack;

public class onPlayerMovement implements Listener {

    public craftattack plugin;

    public onPlayerMovement(craftattack plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMovement(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location pos = e.getPlayer().getLocation();


        if ( pos.getBlockX() == Bukkit.getWorld("world").getSpawnLocation().getBlockX() && pos.getBlockZ() == Bukkit.getWorld("world").getSpawnLocation().getBlockZ() && pos.getBlockY() < 130) {

            p.addPotionEffect( new PotionEffect( PotionEffectType.LEVITATION, 5, 30));

        } else if ( pos.getBlockX() == Bukkit.getWorld("world").getSpawnLocation().getBlockX() && pos.getBlockZ() == Bukkit.getWorld("world").getSpawnLocation().getBlockZ() && pos.getBlockY() >= 130 ) {

            p.removePotionEffect( PotionEffectType.LEVITATION );
            GiveElytra(p);
        }
    }

    public void GiveElytra(Player p) {

        ItemStack ToGive = new ItemStack(Material.ELYTRA);
        ItemMeta ToGiveMeta = ToGive.getItemMeta();
        ToGiveMeta.setDisplayName(p.getUniqueId().toString());
        ToGive.setAmount(1);
        ToGive.setItemMeta(ToGiveMeta);

        if ( p.getInventory().getChestplate() != null ) { if (p.getInventory().getChestplate().getItemMeta().getDisplayName().equals(ToGive.getItemMeta().getDisplayName())) { return; } }
        if (p.getInventory().getChestplate() != null && p.getInventory().firstEmpty() == -1) { return; }

        if ( p.getInventory().getChestplate() == null ) {

            p.getInventory().setChestplate(ToGive);

        } else if ( p.getInventory().getChestplate() != null ){

            p.getInventory().addItem(p.getInventory().getChestplate());
            p.getInventory().setChestplate(ToGive);

        }

    }
}
