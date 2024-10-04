package com.josemarcellio.pinatapartyaddon.handler.type;

import com.josemarcellio.pinatapartyaddon.handler.IDisguiseType;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.entity.Entity;

public class PlayerIDisguiseType implements IDisguiseType {

    private final String playerName;

    public PlayerIDisguiseType(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void disguise(Entity entity) {
        PlayerDisguise playerDisguise = new PlayerDisguise(playerName);
        playerDisguise.setEntity(entity);
        playerDisguise.startDisguise();
    }
}
