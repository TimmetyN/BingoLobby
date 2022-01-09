package bingmclobby.Timmety.GUI;

import bingmclobby.Timmety.Utils.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class gameSelector {

    public static void openInv(Player player) {

        Inventory inv = Bukkit.createInventory(null,27, Messages.GUI_SERVER_SELECTOR.getMessage());

        ItemStack selector = new ItemStack(Material.CHEST);
        ItemMeta meta = selector.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Bingo");

        ArrayList<String> lore= new ArrayList<>();
        lore.add(ChatColor.GRAY+"Speel bingo solo (8 spelers)");
        lore.add("");
        lore.add(ChatColor.YELLOW+"Klik om te spelen");

        meta.setLore(lore);
        selector.setItemMeta(meta);

        inv.setItem(12,selector);

        ItemStack Gameselector = new ItemStack(Material.MAP);
        ItemMeta Gamemeta = Gameselector.getItemMeta();
        Gamemeta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Server Selecteren");

        ArrayList<String> Gamelore= new ArrayList<>();
        Gamelore.add(ChatColor.GRAY+"Selecteer een bingo server.");
        Gamelore.add("");
        Gamelore.add(ChatColor.YELLOW+"Klik om een server te selecteren");

        Gamemeta.setLore(Gamelore);
        Gameselector.setItemMeta(Gamemeta);

        inv.setItem(14,Gameselector);

        player.openInventory(inv);
    }
}
