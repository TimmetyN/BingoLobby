package bingmclobby.Timmety.models;

import bingmclobby.Timmety.Data;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class SBManager {

    public static void setScoreboard(Player p) {

        ScoreboardManager sm = Bukkit.getScoreboardManager();

        Scoreboard board = sm.getNewScoreboard();
        Objective o = board.registerNewObjective("BingoMC-1", "dummdy",ChatColor.YELLOW+""+ChatColor.BOLD+"BingoMC");

        o.setDisplaySlot(DisplaySlot.SIDEBAR);

        //scoreboard
        o.getScore("§2").setScore(11);

        o.getScore(ChatColor.AQUA+""+ ChatColor.BOLD+"Jouw profiel"+ChatColor.AQUA+":").setScore(10);

        Team name = board.registerNewTeam("Name");
        name.addEntry(ChatColor.DARK_AQUA+"  Naam: ");
        name.setPrefix("");
        name.setSuffix(ChatColor.WHITE+p.getName());
        o.getScore(ChatColor.DARK_AQUA+"  Naam: ").setScore(9);

        Team rank = board.registerNewTeam("Rank");
        rank.addEntry(ChatColor.DARK_AQUA+"  Rank: ");
        rank.setPrefix("");
        rank.setSuffix(ChatColor.WHITE+ Data.getRANK().get(p.getUniqueId()));
        o.getScore(ChatColor.DARK_AQUA+"  Rank: ").setScore(8);


        o.getScore("§5").setScore(6);

        o.getScore(ChatColor.AQUA+""+ChatColor.BOLD+"Info"+ChatColor.AQUA+":").setScore(5);

        Team online = board.registerNewTeam("Online");
        online.addEntry(ChatColor.DARK_AQUA+"  Online: ");
        online.setPrefix("");
        online.setSuffix(ChatColor.WHITE+"Zoeken...");
        o.getScore(ChatColor.DARK_AQUA+"  Online: ").setScore(4);

        Team server = board.registerNewTeam("Server");
        server.addEntry(ChatColor.DARK_AQUA+"  Server: ");
        server.setPrefix("");
        server.setSuffix(ChatColor.WHITE+"Lobby");
        o.getScore(ChatColor.DARK_AQUA+"  Server: ").setScore(3);

        o.getScore("§1").setScore(2);


        o.getScore(ChatColor.GRAY+"play.bingomc.nl").setScore(1);


        p.setScoreboard(board);

    }
}
