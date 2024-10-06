package com.josemarcellio.pinatapartyaddon.disguise.manager;

import com.josemarcellio.pinatapartyaddon.PinataPartyAddon;
import com.josemarcellio.pinatapartyaddon.disguise.IDisguiseType;
import com.josemarcellio.pinatapartyaddon.disguise.config.DisguiseTypeConfig;
import com.josemarcellio.pinatapartyaddon.disguise.factory.DisguiseFactory;
import org.bukkit.entity.Entity;

public class DisguiseManager {

    private final DisguiseFactory disguiseFactory;
    private final DisguiseTypeConfig config;

    public DisguiseManager(PinataPartyAddon plugin) {
        this.config = new DisguiseTypeConfig(plugin);
        this.disguiseFactory = new DisguiseFactory(plugin);
    }

    public void applyDisguise(Entity entity) {
        String type = config.getDisguiseType();
        String value = config.getDisguiseValue(type);

        IDisguiseType disguise = disguiseFactory.createDisguise(type, value);
        if (disguise != null) {
            disguise.disguise(entity);
        }
    }
}
