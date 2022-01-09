package bingmclobby.Timmety.Commands;

import bingmclobby.Timmety.services.NPCManager.NPC;
import bingmclobby.Timmety.services.setLocations;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NPCCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission("servermanager.setstate")) {
                sender.sendMessage(ChatColor.of("#D72638") + "Ja nee dit gaan we dus even mooi niet doen! kusjessss <3");
                return true;
            }

            Player player = (Player) sender;

            if(args.length != 1) {
                sender.sendMessage(org.bukkit.ChatColor.RED+"/npc <npc>");
                return false;
            } else {
                for(NPC types: NPC.values()) {
                    if(args[0].equalsIgnoreCase(types.formated())) {
                        setLocations.setNPC(player.getLocation(),types);
                        types.spawn(player,player.getLocation());
                        return false;
                    }
                }
                if(args[0].equalsIgnoreCase("remove")) {

                    return false;
                }
                sender.sendMessage(org.bukkit.ChatColor.RED+"Geen geldige NPC");
                return false;
            }

        }

        return false;
    }
}
