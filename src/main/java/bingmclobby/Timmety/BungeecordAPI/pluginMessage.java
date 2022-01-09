package bingmclobby.Timmety.BungeecordAPI;


import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.Main;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.ArrayList;
import java.util.HashMap;

public class pluginMessage implements PluginMessageListener {

    public static HashMap<String, Integer> server = new HashMap<>();
    public static String serverName;

    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("PlayerCount")) {
            in.readUTF();
            int playerCount = in.readInt();
            server.put(serverName,playerCount);
            System.out.println(playerCount); // prints out correctly
        }

    }

    public static void getPlayerCount(Player p) {

        String server = "server_"+serverName;

        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);
        p.sendPluginMessage(Main.getPlugin(Main.class), "BungeeCord", out.toByteArray());
    }

}
