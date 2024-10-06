package com.josemarcellio.pinatapartyaddon.disguise.factory;

import com.josemarcellio.pinatapartyaddon.PinataPartyAddon;
import com.josemarcellio.pinatapartyaddon.disguise.IDisguiseType;
import com.josemarcellio.pinatapartyaddon.disguise.type.MobDisguiseType;
import com.josemarcellio.pinatapartyaddon.disguise.type.PlayerDisguiseType;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;

public class DisguiseFactory {

    private final PinataPartyAddon plugin;

    public DisguiseFactory(PinataPartyAddon plugin) {
        this.plugin = plugin;
    }

    public IDisguiseType createDisguise(String type, String value) {
        if (type.equalsIgnoreCase("PLAYER")) {
            return new PlayerDisguiseType(value);
        } else if (type.equalsIgnoreCase("MOB")) {
            try {
                DisguiseType disguiseType = DisguiseType.valueOf(value.toUpperCase());
                return new MobDisguiseType(disguiseType);
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("Invalid DISGUISE_TYPE: " + value);
            }
        }
        return null;
    }
}
