package bingmclobby.Timmety.Runnable;


import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.GUI.serversSelector;
import bingmclobby.Timmety.Utils.ServerManagerUtil;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class serversUpdate extends BukkitRunnable {


    @Override
    public void run() {
        Data.setSERVER(ServerManagerUtil.getServers());

        if(serversSelector.inv == null) return;
        List<HumanEntity> players = serversSelector.inv.getViewers();
        if(players == null) return;

        for(int i = 0; i < players.size(); i++) {
            Player player = (Player) players.get(i);
            serversSelector.openServersGUI(player);
        }
    }
}
