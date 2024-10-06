package com.josemarcellio.pinatapartyaddon.disguise.type;

import com.josemarcellio.pinatapartyaddon.disguise.IDisguiseType;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.entity.Entity;

public class PlayerDisguiseType implements IDisguiseType {

    private final String playerName;

    public PlayerDisguiseType(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void disguise(Entity entity) {
        PlayerDisguise playerDisguise = new PlayerDisguise(playerName);
        playerDisguise.setEntity(entity);
        playerDisguise.startDisguise();
    }
}
