package bingmclobby.Timmety.Listeners;

import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.Locations;
import bingmclobby.Timmety.models.SBManager;
import bingmclobby.Timmety.services.NPCManager.NPC;
import bingmclobby.Timmety.services.NPCManager.PacketReader;
import bingmclobby.Timmety.services.hologramManager;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        e.setJoinMessage("");

        //NPC
        if(Locations.getNPC(NPC.BINGO_GAME) != null && Locations.getNPC(NPC.PLAYER) != null) {
            NPC.BINGO_GAME.spawn(player, Locations.getNPC(NPC.BINGO_GAME));
            NPC.PLAYER.spawn(player, Locations.getNPC(NPC.PLAYER));
        }

        //Packet reader
        PacketReader reader = new PacketReader();
        reader.inject(player);

        //Save data
        Data.saveData(player);

        //Stats
        if(Locations.getNPC(NPC.PLAYER) != null) {
            hologramManager.showStats(player, Locations.getNPC(NPC.PLAYER));
        }

        //scoreboard
        SBManager.setScoreboard(player);

        if(Locations.getSpawn() != null) {
            player.teleport(Locations.getSpawn());
        }

        player.setGameMode(GameMode.ADVENTURE);
        player.setHealth(20);
        player.setFoodLevel(20);
        player.getInventory().clear();
    }
}
