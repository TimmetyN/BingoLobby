package bingmclobby.Timmety.Commands;

import bingmclobby.Timmety.services.setLocations;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setLobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender instanceof Player) {
            if(!sender.hasPermission("servermanager.setlobby")) {
                sender.sendMessage(ChatColor.RED+"Ehmmm ja nee sorry dit mag je niet doen :)");
            } else {
                sender.sendMessage("Lobby location updated!");
                setLocations.setSpawn(((Player) sender).getLocation());
            }
        }
        return false;
    }
}
