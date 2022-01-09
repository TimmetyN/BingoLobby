package bingmclobby.Timmety.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(!e.getPlayer().hasPermission("servermanager.break")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if(!e.getPlayer().hasPermission("servermanager.place")) {
            e.setCancelled(true);
        }
    }
}
