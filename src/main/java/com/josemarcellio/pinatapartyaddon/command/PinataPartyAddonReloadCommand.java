package com.josemarcellio.pinatapartyaddon.command;

import com.josemarcellio.pinatapartyaddon.PinataPartyAddon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PinataPartyAddonReloadCommand implements CommandExecutor {

    private final PinataPartyAddon plugin;

    public PinataPartyAddonReloadCommand(PinataPartyAddon plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("pinatapartyaddon.reload")) {
                player.sendMessage("§cYou do not have permission to use this command!");
                return false;
            }
        }

        plugin.reloadConfig();
        sender.sendMessage("§aPinataPartyAddon by JoseMarcellio, plugin reloaded!");
        return true;
    }
}
