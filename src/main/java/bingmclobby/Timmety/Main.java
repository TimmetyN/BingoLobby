package bingmclobby.Timmety;

import bingmclobby.Timmety.BungeecordAPI.pluginMessage;
import bingmclobby.Timmety.Commands.NPCCommand;
import bingmclobby.Timmety.Commands.setLobby;
import bingmclobby.Timmety.Listeners.*;
import bingmclobby.Timmety.Runnable.serversUpdate;
import bingmclobby.Timmety.Runnable.updatePlayerCount;
import bingmclobby.Timmety.Utils.MysqlUtil;
import bingmclobby.Timmety.Utils.ServerManagerUtil;
import bingmclobby.Timmety.services.NPCManager.NPC;
import bingmclobby.Timmety.services.NPCManager.PacketReader;
import bingmclobby.Timmety.services.hologramManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new pluginMessage());

        //Commands
        getCommand("npc").setExecutor(new NPCCommand());
        getCommand("setlobby").setExecutor(new setLobby());

        //Class
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new npcListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClicksListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new DamageListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new hungerListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(new mobSpawning(),this);

        //spawn npc
        if(!Bukkit.getOnlinePlayers().isEmpty())
            for(Player player : Bukkit.getOnlinePlayers()) {

                //Packet reader
                PacketReader reader = new PacketReader();
                reader.inject(player);

                //NPC SPAWNER
                for(NPC type : NPC.values()) {
                    type.spawn(player,Locations.getNPC(type));
                }
            }

        //Database
        initConfig();

            NPC.BINGO_GAME.spawnStands();

        ConfigurationSection mysqlConfig = this.getConfig().getConfigurationSection("mysql");
        MysqlUtil.init(
                mysqlConfig.getString("host"),
                mysqlConfig.getInt("port"),
                mysqlConfig.getString("database"),
                mysqlConfig.getString("user"),
                mysqlConfig.getString("password")
        );
        MysqlUtil.i();


        //Set all players
        ServerManagerUtil.setAllPlayers();


        //Runnable
        new updatePlayerCount().runTaskTimer(this, 0, 20*20);
        new serversUpdate().runTaskTimer(this, 0, 20*5);

    }

    private void initConfig() {
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveDefaultConfig();
        }
    }

    @Override
    public void onDisable() {
        if(!Bukkit.getOnlinePlayers().isEmpty())
            for(Player player : Bukkit.getOnlinePlayers()) {

                //Packet reader
                PacketReader reader = new PacketReader();
                reader.uninjext(player);

                //Remove NPC
                for(int i = 0; i < NPC.NPC.size(); i ++) {
                    NPC.removeNPC(player,NPC.NPC.get(i));
                }
            }

        ArrayList<ArmorStand> stand = hologramManager.stands;
        for(int i = 0; i < stand.size(); i++) {
            stand.get(i).remove();
        }
    }
}
