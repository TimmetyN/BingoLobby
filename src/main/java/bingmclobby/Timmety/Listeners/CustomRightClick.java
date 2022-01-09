package bingmclobby.Timmety.Listeners;

import bingmclobby.Timmety.services.NPCManager.NPC;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CustomRightClick extends Event implements Cancellable {

    private final Player player;
    private final EntityPlayer npc;
    private static NPC type;
    private boolean isCancelled;
    private static final HandlerList HANDLERS = new HandlerList();

    public CustomRightClick(Player player, EntityPlayer npc,NPC type) {
        this.player = player;
        this.npc = npc;
    }

    public Player getPlayer() {
        return player;
    }

    public EntityPlayer getNPC() {
        return npc;
    }

    public NPC getType() {
        return NPC.npcTypes.get(npc.getId());
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {
        isCancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
