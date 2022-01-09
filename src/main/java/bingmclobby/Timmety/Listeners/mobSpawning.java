package bingmclobby.Timmety.Listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class mobSpawning implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if(e.getEntity().getType() != EntityType.ARMOR_STAND) {
            e.setCancelled(true);
        }

    }
}
