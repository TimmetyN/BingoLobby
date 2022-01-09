package bingmclobby.Timmety.Listeners;

import bingmclobby.Timmety.BungeecordAPI.pluginMessage;
import bingmclobby.Timmety.GUI.gameSelector;
 import bingmclobby.Timmety.Main;
import bingmclobby.Timmety.Utils.ServerManagerUtil;
import bingmclobby.Timmety.services.NPCManager.NPC;
 import org.bukkit.Bukkit;
 import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class npcListener implements Listener {

    @EventHandler
    public void onClick(CustomRightClick e) {
        Player player = e.getPlayer();

        if(e.getType() == NPC.BINGO_GAME) {
            gameSelector.openInv(player);
        }
    }
}
