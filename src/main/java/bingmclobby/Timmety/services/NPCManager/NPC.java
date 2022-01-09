package bingmclobby.Timmety.services.NPCManager;

import bingmclobby.Timmety.Enums.Hologram;
import bingmclobby.Timmety.Locations;
import bingmclobby.Timmety.Main;
import bingmclobby.Timmety.services.hologramManager;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R3.scoreboard.CraftScoreboard;
import org.bukkit.entity.Player;

import java.util.*;

public enum NPC {

    BINGO_GAME("U+moQtdqXk01hdnX0Qy6IuZUP3KPF9TGQzwfAXKMZelKGKh66lbSNaRNmzXIPUoAJTbo2upDHmGdNEqsp6PgUgrQlUVcQ3jvtX+rxyzdCB3vwkcwD1z7fRg211FUf0+amxZv0ocL2il0OSBp4PunGldrZa19rio8RgIpIHnFoLR4hPolQJr1/G7GSFXcwdvSYbVH2XVCe8t1D8QEnMR+jKSwluzFRdpeNccvPcdP6Ohs1EE96vvDas6thjMHSu/8fdNNK87KNhGHGgyqvANXX2KRrGAyGntxTv5mPuSKGbKrPdqi05mur4/uOIRpdwdnit5mrIy0/XU5KdrtjJNjr/x7jrgt8L4c+a310i2P1/11njnAAYo1MjuJOXPdYnNTQa8ClSkQmj2c/uud3ypGQGXgAVDY7/+4M8pGMITKduXpeLgpNS4sGg5XccQFokRno+/EvMho5dJSjzyRKv4D7WOQG6avF6I2m/s8Q6hXKz9sPrYJSlB/iwp8Ba9tOjg9gMv5/SDPX1uqI2+snIG8pJtfbQ5vXiRioUJcXJu2asDL4t04ry3TOAQERCcKfc9JfL6luv1qCsy8tmI42lydLit1DW6jXGNk974iy35TVjg5QRcglH0PF8ufnk0syWS+YPOJMfOSo/fmBOWpAk6LmWQoa+wwAO2n/GQycQ5WbLY=","ewogICJ0aW1lc3RhbXAiIDogMTY0MDgxMDQ1OTY3MywKICAicHJvZmlsZUlkIiA6ICI3Y2EwNDFhNGQ1MmI0Yjg3YmNhMWMyNWQwODNmNTRiNCIsCiAgInByb2ZpbGVOYW1lIiA6ICJCdWRkaWVESiIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS80OGY3MWU5MjA3ZTVhODdiN2FkNTllY2E0ZDE5MjA1ZmNkMjUxMzk3MzBlNWVkN2E4NDZmMDVkNmRlODYxMGU2IgogICAgfQogIH0KfQ==")
    ,PLAYER("","");


    private String signature;
    private String value;
    private NPC type;

    public static Map<Integer, EntityPlayer> npcEnitities =  new HashMap<>();
    public static Map<Integer, NPC> npcTypes = new HashMap();
    public static List<EntityPlayer> NPC = new ArrayList<EntityPlayer>();

    NPC(String signature, String value) {
        this.signature = signature;
        this.value = value;
        this.type = this;
    }

    public String formated() {
        return this.toString().toLowerCase();
    }

    public void spawn(Player player, Location location) {
        EntityPlayer craftPlayer = ((CraftPlayer)player).getHandle();

        Property textures = (Property) craftPlayer.getProfile().getProperties().get("textures").toArray()[0];
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatColor.DARK_GRAY+"NPP_Player");

        if(type != type.PLAYER) {
            gameProfile.getProperties().put("textures",new Property("textures",value,signature));
        } else {
            gameProfile = new GameProfile(UUID.randomUUID(),ChatColor.DARK_GRAY+player.getName());
            Property texturesPlayer = (Property) playerSkindata.getPlayerSignare(player);
            gameProfile.getProperties().put("textures",new Property("textures",texturesPlayer.getValue(),texturesPlayer.getSignature()));
        }

        if(Locations.getNPC(type) == null) {
            return;
        }

        Location loc = Locations.getNPC(type);

        WorldServer world = ((CraftWorld) player.getWorld()).getHandle();
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();

        EntityPlayer npc = new EntityPlayer(server,world,gameProfile,new PlayerInteractManager(world));

        npc.setLocation(loc.getX(),loc.getY(),loc.getZ(),loc.getYaw(),loc.getPitch());

        //connection
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;

        //Hide nametag
        //Creating the team
        ScoreboardTeam team = new ScoreboardTeam(((CraftScoreboard) Bukkit.getScoreboardManager().getMainScoreboard()).getHandle(), npc.getName());

        //Setting name visibility
        team.setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility.NEVER);

        //Remove the Team (i assume so if it exists)
        connection.sendPacket(new PacketPlayOutScoreboardTeam(team, 1));
        //Creating the Team
        connection.sendPacket(new PacketPlayOutScoreboardTeam(team, 0));
        //Adding players to the team (You have to use the NPC's name, and add it to a list)
        connection.sendPacket(new PacketPlayOutScoreboardTeam(team, new ArrayList<String>(){{add(npc.getName());}}, 3));

        //Skin Layers

        DataWatcher watcher = npc.getDataWatcher();

        byte b = 0x01 | 0x02 | 0x04 | 0x08 | 0x10 | 0x20 | 0x40;
        watcher.set(DataWatcherRegistry.a.a(16),b);

        //Packets

        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER,npc));
        connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
        connection.sendPacket(new PacketPlayOutEntityMetadata(npc.getId(),watcher,true));
        connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc,(byte) (loc.getYaw() * 256 / 360)));

        Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), new Runnable() {
            @Override
            public void run() {
                connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
            }
        }, 100L);

        npcEnitities.put(npc.getId(),npc);
        npcTypes.put(npc.getId(),type);
        NPC.add(npc);
    }

    public static void removeNPC(Player player,EntityPlayer npc){
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;

        connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        connection.sendPacket(new PacketPlayOutEntityDestroy(npc.getId()));
    }

    public void spawnStands() {
        Location loc = Locations.getNPC(this);

        if (loc == null) {
            return;
        }
        if(this == BINGO_GAME) {
            //Title
            loc.setY(loc.getY() + 1.5);
            hologramManager.spawnStands(Hologram.HOLOGRAM,loc,"&a&lBingo Solo");

            //Players
            loc.setY(loc.getY() - 0.3);
            hologramManager.spawnStands(Hologram.PLAYER_COUNT,loc,"0 Spelers");

            //Click
            loc.setY(loc.getY() - 0.3);
            hologramManager.spawnStands(Hologram.HOLOGRAM,loc,"&aKLIK OM TE SPELEN");
        }

    }

}
