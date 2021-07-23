package me.georgeawp.informationplus.commands;

import me.georgeawp.informationplus.Informationplus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReportCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player p = (Player) sender;
        if (!p.hasPermission("InformationPlus.main")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("main.error")));
            return true;
        }
        if (command.getName().equalsIgnoreCase("report")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("report.border")));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("report.header")));
            for (String report : Informationplus.getInstance().config.getStringList("report.lines")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', report));
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("report.border")));
            return true;
        }
        return false;
    }
}