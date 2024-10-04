package com.josemarcellio.pinatapartyaddon.handler;

import com.josemarcellio.pinatapartyaddon.PinataPartyAddon;
import com.josemarcellio.pinatapartyaddon.handler.type.MobDisguiseType;
import com.josemarcellio.pinatapartyaddon.handler.type.PlayerDisguiseType;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import org.bukkit.entity.Entity;

public class DisguiseHandler {

    private final PinataPartyAddon plugin;

    public DisguiseHandler(PinataPartyAddon plugin) {
        this.plugin = plugin;
    }

    public void applyDisguise(Entity entity) {
        String type = plugin.getConfig().getString("DISGUISE_TYPE");
        String value = plugin.getConfig().getString("DISGUISE_VALUE");

        if (type != null && value != null) {
            IDisguiseType IDisguiseType = createDisguise(type, value);
            if (IDisguiseType != null) {
                IDisguiseType.disguise(entity);
            }
        }
    }

    private IDisguiseType createDisguise(String type, String value) {
        if (type.equalsIgnoreCase("PLAYER")) {
            return new PlayerDisguiseType(value);
        } else if (type.equalsIgnoreCase("MOB")) {
            try {
                DisguiseType disguiseType = DisguiseType.valueOf(value.toUpperCase());
                return new MobDisguiseType(disguiseType);
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid DisguiseType: " + value);
            }
        }
        return null;
    }
}
