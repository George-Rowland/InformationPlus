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
        if (!p.hasPermission("InformationPlus.main")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , Informationplus.getInstance().config.getString("main.error")));
            return true;
        }
        if (label.equalsIgnoreCase("informationplus")) {

            if(args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThis server is currently running &f[&cInformationPlus Version-1.0&f]"));
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("InformationPlus.admin")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("reload.message")));
                        Informationplus.getInstance().reloadConfiguration();
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("reload.error")));
                        return true;
                    }
                }


                }
                return false;
            }
        }
