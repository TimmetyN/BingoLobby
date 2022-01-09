package bingmclobby.Timmety.services.NPCManager;

import com.mojang.authlib.properties.Property;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class playerSkindata {

    public static Property getPlayerSignare(Player player) {
        EntityPlayer craftPlayer = ((CraftPlayer)player).getHandle();

        Property textures = (Property) craftPlayer.getProfile().getProperties().get("textures").toArray()[0];

        return textures;
    }
}
