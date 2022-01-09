package bingmclobby.Timmety.services;

import bingmclobby.Timmety.configManager;
import bingmclobby.Timmety.services.NPCManager.NPC;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class setLocations {
    public static void setNPC(Location loc, NPC type) {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        //Location
        int x= (int)loc.getX();
        int y =(int) loc.getY();
        int z=(int) loc.getZ();
        int yaw = (int)loc.getYaw();

        config.set("Locations."+type.formated()+".World",loc.getWorld().getName());
        config.set("Locations."+type.formated()+".x",x);
        config.set("Locations."+type.formated()+".y",y);
        config.set("Locations."+type.formated()+".z",z);
        config.set("Locations."+type.formated()+".yaw",yaw);

        try {
            config.save(file);
        } catch (Exception e) {

        }
    }

    public static void setSpawn(Location loc) {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        //Location
        int x= (int)loc.getX();
        double y = loc.getY();
        int z=(int) loc.getZ();
        int yaw = (int)loc.getYaw();

        config.set("Locations.Spawn.World",loc.getWorld().getName());
        config.set("Locations.Spawn.x",x);
        config.set("Locations.Spawn.y",y);
        config.set("Locations.Spawn.z",z);
        config.set("Locations.Spawn.yaw",yaw);

        try {
            config.save(file);
        } catch (Exception e) {

        }
    }

    public static void setLeaderboardFirst(Location loc) {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        //Location
        int x= (int)loc.getX();
        double y =loc.getY();
        int z=(int) loc.getZ();
        int yaw = (int)loc.getYaw();

        config.set("Locations.Leaderboard.first.World",loc.getWorld().getName());
        config.set("Locations.Leaderboard.first.x",x);
        config.set("Locations.Leaderboard.first.y",y);
        config.set("Locations.Leaderboard.first.z",z);
        config.set("Locations.Leaderboard.first.yaw",yaw);

        try {
            config.save(file);
        } catch (Exception e) {

        }
    }

    public static void setLeaderboardSecond(Location loc) {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        //Location
        int x= (int)loc.getX();
        double y =loc.getY();
        int z=(int) loc.getZ();
        int yaw = (int)loc.getYaw();

        config.set("Locations.Leaderboard.second.World",loc.getWorld().getName());
        config.set("Locations.Leaderboard.second.x",x);
        config.set("Locations.Leaderboard.second.y",y);
        config.set("Locations.Leaderboard.second.z",z);
        config.set("Locations.Leaderboard.second.yaw",yaw);

        try {
            config.save(file);
        } catch (Exception e) {

        }
    }
    public static void setLeaderboardThird(Location loc) {
        File file = configManager.getConfig();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        //Location
        int x= (int)loc.getX();
        int y =(int) loc.getY();
        int z=(int) loc.getZ();
        int yaw = (int)loc.getYaw();

        config.set("Locations.Leaderboard.third.World",loc.getWorld().getName());
        config.set("Locations.Leaderboard.third.x",x);
        config.set("Locations.Leaderboard.third.y",y);
        config.set("Locations.Leaderboard.third.z",z);
        config.set("Locations.Leaderboard.third.yaw",yaw);

        try {
            config.save(file);
        } catch (Exception e) {

        }
    }
}
