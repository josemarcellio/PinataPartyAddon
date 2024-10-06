package com.josemarcellio.pinatapartyaddon.listener;

import com.josemarcellio.pinatapartyaddon.disguise.manager.DisguiseManager;
import me.hexedhero.pp.api.PinataSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Entity;

public class PinataPartyListener implements Listener {

    private final DisguiseManager disguiseManager;

    public PinataPartyListener(DisguiseManager disguiseManager) {
        this.disguiseManager = disguiseManager;
    }

    @SuppressWarnings("unused")
    @EventHandler
    public void onPinataSpawn(PinataSpawnEvent event) {
        Entity entity = event.getPinata().getEntity();
        disguiseManager.applyDisguise(entity);
    }
}
