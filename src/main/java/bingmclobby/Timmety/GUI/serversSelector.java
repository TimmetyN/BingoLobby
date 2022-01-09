package bingmclobby.Timmety.GUI;

import bingmclobby.Timmety.BungeecordAPI.pluginMessage;
import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.Main;
import bingmclobby.Timmety.Utils.Messages;
import bingmclobby.Timmety.Utils.ServerManagerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class serversSelector {

    public static Inventory inv;

    public static void openServersGUI(Player player) {

        ArrayList<Integer> allServers;
        allServers = Data.getServer();

        int rows = (((allServers.size() / 9)+1)*9)+9;

        if(rows > 45) {
            rows = 45;
        }

        inv = Bukkit.createInventory(null,rows, Messages.GUI_SERVERS_SELECTOR.getMessage());

        int slot = 0;


        for(int i = 0; i < allServers.size(); i++) {

            ItemStack item = new ItemStack(Material.MAP);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ChatColor.GREEN+"Server "+ChatColor.GRAY+"(#"+allServers.get(i).toString()+")");

            ArrayList<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.YELLOW+"Klik om te verbinden");

            meta.setLore(lore);
            item.setItemMeta(meta);

            inv.setItem(slot,item);

            slot++;

        }

        ItemStack back = new ItemStack(Material.BOOK);
        ItemMeta meta = back.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW+"Back");

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY+"Ga terug naar de hoofdpagina");

        meta.setLore(lore);
        back.setItemMeta(meta);

        inv.setItem(rows-5,back);

        player.openInventory(inv);



    }
}
