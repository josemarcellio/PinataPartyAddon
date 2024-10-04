package com.josemarcellio.pinatapartyaddon;

import com.josemarcellio.pinatapartyaddon.command.PinataPartyAddonReloadCommand;
import com.josemarcellio.pinatapartyaddon.handler.DisguiseHandler;
import com.josemarcellio.pinatapartyaddon.listener.PinataPartyListener;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class PinataPartyAddon extends JavaPlugin {

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onEnable() {
        getLogger().info("PinataPartyAddon by JoseMarcellio enabled!");

        int id = 23535;
        new Metrics(this, id);

        saveDefaultConfig();
        DisguiseHandler disguiseHandler = new DisguiseHandler(this);
        getServer().getPluginManager().registerEvents(new PinataPartyListener(disguiseHandler), this);

        getCommand("pinatapartyaddonreload").setExecutor(new PinataPartyAddonReloadCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("PinataPartyAddon by JoseMarcellio disabled!");
    }
}
