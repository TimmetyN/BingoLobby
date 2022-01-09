package bingmclobby.Timmety.BungeecordAPI;

import bingmclobby.Timmety.Main;
import bingmclobby.Timmety.Utils.ServerManagerUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class serverSender {

    public static void sendPlayerToServer(Player player, String server,int id) {

        if(ServerManagerUtil.getPlayers(id) >= 8 ){
            player.sendMessage(ChatColor.RED+"Deze server zit al vol!");
            return;
        }

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (Exception e) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&6Celmic Network&8] &fThere was an problem connecting to " + server + "!"));
            return;
        }

        player.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", b.toByteArray());
    }


}
