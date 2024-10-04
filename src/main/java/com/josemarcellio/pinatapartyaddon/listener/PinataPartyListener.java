package com.josemarcellio.pinatapartyaddon.listener;

import com.josemarcellio.pinatapartyaddon.handler.DisguiseHandler;
import me.hexedhero.pp.api.PinataSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Entity;

public class PinataPartyListener implements Listener {

    private final DisguiseHandler disguiseHandler;

    public PinataPartyListener(DisguiseHandler disguiseHandler) {
        this.disguiseHandler = disguiseHandler;
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void onPinataSpawn(PinataSpawnEvent event) {
        Entity entity = event.getPinata().getEntity();
        disguiseHandler.applyDisguise(entity);
    }
}
