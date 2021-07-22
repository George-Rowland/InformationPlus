package me.georgeawp.informationplus.commands;

import me.georgeawp.informationplus.Informationplus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        final Player p = (Player) sender;
        if (!p.hasPermission("InformationPlus.main")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("main.error")));
            return true;
        }
        if (command.getName().equalsIgnoreCase("rules")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("rules.border")));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("rules.header")));
            for (String rules : Informationplus.getInstance().config.getStringList("rules.lines")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', rules));
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("rules.border")));
            return true;
        }
        return false;
    }
}