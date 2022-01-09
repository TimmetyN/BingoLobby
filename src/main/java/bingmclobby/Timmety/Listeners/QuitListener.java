package bingmclobby.Timmety.Listeners;

import bingmclobby.Timmety.services.NPCManager.PacketReader;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        e.setQuitMessage("");

        PacketReader reader = new PacketReader();
        reader.uninjext(player);
    }
}
