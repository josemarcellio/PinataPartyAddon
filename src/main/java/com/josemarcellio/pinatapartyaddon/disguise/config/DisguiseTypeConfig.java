package com.josemarcellio.pinatapartyaddon.disguise.config;

import com.josemarcellio.pinatapartyaddon.PinataPartyAddon;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.Random;

public class DisguiseTypeConfig {

    private final PinataPartyAddon plugin;
    private final Random random;

    public DisguiseTypeConfig(PinataPartyAddon plugin) {
        this.plugin = plugin;
        this.random = new Random();
    }

    public String getDisguiseType() {
        FileConfiguration config = plugin.getConfig();
        String type = config.getString("DISGUISE_TYPE");
        return (type != null && type.equalsIgnoreCase("RANDOM")) ? getRandomType() : type;
    }

    public String getDisguiseValue(String type) {
        FileConfiguration config = plugin.getConfig();
        String value = config.getString("DISGUISE_VALUE");
        return (value != null && value.equalsIgnoreCase("RANDOM")) ? getRandomValue(type) : value;
    }

    private String getRandomType() {
        return random.nextBoolean() ? "PLAYER" : "MOB";
    }

    private String getRandomValue(String type) {
        List<String> values = plugin.getConfig().getStringList("RANDOM.TYPE_" + type.toUpperCase());
        return values.isEmpty() ? null : values.get(random.nextInt(values.size()));
    }
}
