package com.josemarcellio.pinatapartyaddon.handler;

import com.josemarcellio.pinatapartyaddon.PinataPartyAddon;
import com.josemarcellio.pinatapartyaddon.handler.type.MobIDisguiseType;
import com.josemarcellio.pinatapartyaddon.handler.type.PlayerIDisguiseType;
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
            return new PlayerIDisguiseType(value);
        } else if (type.equalsIgnoreCase("MOB")) {
            try {
                DisguiseType disguiseType = DisguiseType.valueOf(value.toUpperCase());
                return new MobIDisguiseType(disguiseType);
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid DisguiseType: " + value);
            }
        }
        return null;
    }
}
