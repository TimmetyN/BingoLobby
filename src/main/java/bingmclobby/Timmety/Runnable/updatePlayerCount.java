package bingmclobby.Timmety.Runnable;

import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.Utils.ServerManagerUtil;
import bingmclobby.Timmety.services.hologramManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class updatePlayerCount extends BukkitRunnable {

    @Override
    public void run() {
        hologramManager.player_count.forEach((key, value) -> {
            ServerManagerUtil.setAllPlayers();
            key.setCustomName(ChatColor.GRAY+""+Data.getTotalPlayer()+" players");
        });
    }
}
