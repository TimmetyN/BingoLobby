package bingmclobby.Timmety;

import bingmclobby.Timmety.services.NPCManager.NPC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Locations {

    public static Location getSpawn() {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        int x= config.getInt("Locations.Spawn.x");
        int y = config.getInt("Locations.Spawn.y");
        int z= config.getInt("Locations.Spawn.z");
        int yaw = config.getInt("Locations.Spawn.yaw");

        World world = Bukkit.getWorld(config.getString("Locations.Spawn.World"));

        Location loc = new Location(world,x,y,z);
        loc.setYaw(yaw);

        return loc;
    }

    public static Location getNPC(NPC type) {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(config.getString("Locations."+type.formated()) == null) {
            return null;
        }

        int x = config.getInt("Locations."+type.formated()+".x");
        int y = config.getInt("Locations."+type.formated()+".y");
        int z= config.getInt("Locations."+type.formated()+".z");
        int yaw = config.getInt("Locations."+type.formated()+".yaw");

        World world = Bukkit.getWorld(config.getString("Locations."+type.formated()+".World"));

        Location loc = new Location(world,x,y,z);
        loc.setYaw(yaw);

        Location newLoc = getCenter(loc);

        newLoc.setYaw(loc.getYaw());

        return newLoc;
    }


    public static Location getFirst() {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        int x= config.getInt("Locations.Leaderboard.first.x");
        double y = config.getDouble("Locations.Leaderboard.first.y");
        int z= config.getInt("Locations.Leaderboard.first.z");
        int yaw = config.getInt("Locations.Leaderboard.first.yaw");

        World world = Bukkit.getWorld(config.getString("Locations.Leaderboard.first.World"));

        Location loc = new Location(world,x,y,z);


        loc =getCenter(loc);

        loc.setY(y);
        loc.setYaw(yaw);

        return loc;
    }

    public static Location getSecond() {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        int x= config.getInt("Locations.Leaderboard.second.x");
        double y = config.getDouble("Locations.Leaderboard.second.y");
        int z= config.getInt("Locations.Leaderboard.second.z");
        int yaw = config.getInt("Locations.Leaderboard.second.yaw");

        World world = Bukkit.getWorld(config.getString("Locations.Leaderboard.second.World"));

        Location loc = new Location(world,x,y,z);

        loc =getCenter(loc);

        loc.setY(y);
        loc.setYaw(yaw);

        return loc;
    }

    public static Location getThird() {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        int x= config.getInt("Locations.Leaderboard.third.x");
        double y = config.getDouble("Locations.Leaderboard.third.y");
        int z= config.getInt("Locations.Leaderboard.third.z");
        int yaw = config.getInt("Locations.Leaderboard.third.yaw");

        World world = Bukkit.getWorld(config.getString("Locations.Leaderboard.third.World"));

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+""+y+"");

        Location loc = new Location(world,x,y,z);
        loc =getCenter(loc);

        loc.setY(y);

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+""+y+"");

        loc.setYaw(yaw);

        return loc;
    }

    public static Location getCenter(Location loc) {
        return new Location(loc.getWorld(),
                getRelativeCoord(loc.getBlockX()),
                loc.getBlockY(),
                getRelativeCoord(loc.getBlockZ()));
    }
    private static double getRelativeCoord(int i) {
        double d = i;
        if(d < 0) {
            d -=0.5;
        } else {
            d+=0.5;
        }
        return d;
    }
}
