package bingmclobby.Timmety.Utils;

import bingmclobby.Timmety.BungeecordAPI.pluginMessage;
import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerManagerUtil {

    public static ArrayList<Integer> getServers() {
        ArrayList<Integer> servers = new ArrayList();
        try {
            PreparedStatement stmt = MysqlUtil.i().prepareStatement("SELECT id,restricted FROM `servers` WHERE state=? AND restricted=?");
            stmt.setString(1, "STARTING");
            stmt.setString(2, "FALSE");
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                int id = results.getInt("id");
                servers.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servers;
    }

    public static int getPlayers(int id) {
        int players = 0;

        try {
            PreparedStatement stmt = MysqlUtil.i().prepareStatement("SELECT players FROM `servers` WHERE id=?");
            stmt.setInt(1, id);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                players = results.getInt("players");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }

    public boolean getPrivate(int id) {
        int players = 0;

        try {
            PreparedStatement stmt = MysqlUtil.i().prepareStatement("SELECT restricted FROM `servers` WHERE id=?");
            stmt.setInt(1, id);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                if(results.getString("restricted").equalsIgnoreCase("false")) {
                    return false;
                } else {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void setAllPlayers() {
        int players = 0;

        try {
            PreparedStatement stmt = MysqlUtil.i().prepareStatement("SELECT players FROM `servers`");
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                players= players+results.getInt("players");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Data.setTotalPlayer(players);
    }

}
