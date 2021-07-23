package me.georgeawp.informationplus.commands;

import me.georgeawp.informationplus.Informationplus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InformationCommands implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player p = (Player) sender;

        if (label.equalsIgnoreCase("informationplus")) {

            if (args.length == 0) {
                if (!p.hasPermission("InformationPlus.main")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("main.error")));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThis server is currently running &f[&cInformationPlus Version " + Informationplus.getInstance().getVersion() + "&f]"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l Player"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/help (InformationPlus.main)"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/links (InformationPlus.main)"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/rules (InformationPlus.main"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Join Message (InformationPlus.join)"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " "));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l Admin"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7/informationplus reload (InformationPlus.admin)"));
                }
                return true;
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("InformationPlus.admin")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("reload.message")));
                    Informationplus.getInstance().reloadConfiguration();
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("reload.error")));
                }
                return true;
            }


        }
        return false;
    }
}
