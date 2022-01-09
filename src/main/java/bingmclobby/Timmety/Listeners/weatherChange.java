package bingmclobby.Timmety.Listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class weatherChange implements Listener {

    public void onChange(WeatherChangeEvent e) {
        e.setCancelled(true);
        e.getWorld().setThundering(false);
    }
}
