package bingmclobby.Timmety.Listeners;

import bingmclobby.Timmety.BungeecordAPI.serverSender;
import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.GUI.gameSelector;
import bingmclobby.Timmety.GUI.serversSelector;
import bingmclobby.Timmety.Utils.Messages;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

public class InventoryClicksListener implements Listener {

    @EventHandler
    public void onGui1(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(Messages.GUI_SERVER_SELECTOR.getMessage())) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.MAP) {
                serversSelector.openServersGUI(player);
            }
        }
    }

    @EventHandler
    public void onGui2(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) return;

        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(Messages.GUI_SERVERS_SELECTOR.getMessage())) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.BOOK) {
                gameSelector.openInv(player);
            } else if(e.getCurrentItem().getType() == Material.MAP) {
                ArrayList<Integer> allServers;
                allServers = Data.getServer();

                int slot = e.getSlot();
                int serverID = allServers.get(slot);
                serverSender.sendPlayerToServer(player,"server_"+serverID,serverID);
            }
        }
    }
}
