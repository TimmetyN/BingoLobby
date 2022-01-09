package bingmclobby.Timmety.services;

import bingmclobby.Timmety.Data;
import bingmclobby.Timmety.Enums.Hologram;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftChatMessage;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class hologramManager {

    public static ArrayList<ArmorStand> stands =  new ArrayList<>();
    public static HashMap<ArmorStand, Hologram> player_count = new HashMap<>();

    public static void spawnStands(Hologram type, Location loc, String HologramTitle) {

        if(type == Hologram.HOLOGRAM) {
            HologramTitle = ChatColor.translateAlternateColorCodes('&',HologramTitle);

            ArmorStand title = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            title.setCustomName(HologramTitle);
            title.setCustomNameVisible(true);
            title.setSmall(true);
            title.setGravity(false);
            title.setVisible(false);
            stands.add(title);
        } else if(type == Hologram.PLAYER_COUNT) {
            HologramTitle = ChatColor.translateAlternateColorCodes('&',"&70 Spelers");

            ArmorStand title = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            title.setCustomName(HologramTitle);
            title.setCustomNameVisible(true);
            title.setSmall(true);
            title.setGravity(false);
            title.setVisible(false);
            stands.add(title);
            player_count.put(title,Hologram.PLAYER_COUNT);
        }
    }

    public static void createPrivate(Player player, Location loc, String title) {

        WorldServer world = ((CraftWorld) player.getWorld()).getHandle();

        final EntityArmorStand armorStand = new EntityArmorStand(EntityTypes.ARMOR_STAND, world);
        armorStand.setPosition(loc.getX(), loc.getY(), loc.getZ());
        armorStand.setCustomName(CraftChatMessage.fromStringOrNull(title));
        armorStand.setCustomNameVisible(true);
        armorStand.setSmall(true);
        armorStand.setPosition(loc.getX(), loc.getY(), loc.getZ());
        armorStand.setInvisible(true);
        PacketPlayOutSpawnEntity packetPlayOutSpawnEntity = new PacketPlayOutSpawnEntity(armorStand);
        PacketPlayOutEntityMetadata metadata = new PacketPlayOutEntityMetadata(armorStand.getId(), armorStand.getDataWatcher(), true);

        final PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(packetPlayOutSpawnEntity);
        connection.sendPacket(metadata);
    }


    public static void showStats(Player player, Location loc) {
        WorldServer world = ((CraftWorld) player.getWorld()).getHandle();

        loc.setY(loc.getY()+3.2);

        createPrivate(player,loc,ChatColor.YELLOW+""+ChatColor.BOLD+"Statistieken van "+player.getName());
        loc.setY(loc.getY()-0.5);
        createPrivate(player,loc,ChatColor.AQUA+"Gewonnen"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+ Data.getTotaalGewonnen().get(player.getUniqueId()));
        loc.setY(loc.getY()-0.3);
        createPrivate(player,loc,ChatColor.AQUA+"Gespeeld"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+Data.getTotaalGespeeld().get(player.getUniqueId()));
        loc.setY(loc.getY()-0.3);
        createPrivate(player,loc,ChatColor.AQUA+"Items Gevonden"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+Data.getTotaalItems().get(player.getUniqueId()));
        loc.setY(loc.getY()-0.3);
        createPrivate(player,loc,ChatColor.AQUA+"Gemiddelde Items"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+Data.getGemiddeldItems().get(player.getUniqueId()));
        loc.setY(loc.getY()-0.3);
        createPrivate(player,loc,ChatColor.AQUA+"Totaal Playtime"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+Data.getTotaalPlaytime().get(player.getUniqueId()));
        loc.setY(loc.getY()-0.3);
        createPrivate(player,loc,ChatColor.AQUA+"Gemiddelde Playtime"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+Data.getGemiddeldePlaytime().get(player.getUniqueId()));
        loc.setY(loc.getY()-0.3);
        createPrivate(player,loc,ChatColor.AQUA+"Eerste game"+ChatColor.YELLOW+" » "+ChatColor.DARK_AQUA+"Soon..");





    }

}
