package me.georgeawp.informationplus.commands;

import me.georgeawp.informationplus.Informationplus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InformationCommands implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

            if (label.equalsIgnoreCase("informationplus")) {
                if (!sender.hasPermission("InformationPlus.main")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("main.error")));
                    return true;
                }
                if (args.length == 0) {
                    // /server
                    if (sender.hasPermission("InformationPlus.main")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("commands.border")));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("commands.header")));
                        for (String commands : Informationplus.getInstance().config.getStringList("commands.lines")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', commands));
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("commands.border")));
                        return true;
                    }
                    return true;
                }
                // /server reload
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("InformationPlus.reload")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("reload.message")));
                        Informationplus.getInstance().reloadConfiguration();
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("reload.error")));
                        return true;
                    }
                }

                if (args[0].equalsIgnoreCase("links")) {
                    if (sender.hasPermission("InformationPlus.main")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("links.border")));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("links.header")));
                        for (String links : Informationplus.getInstance().config.getStringList("links.lines")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', links));
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("links.border")));
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("main.error")));
                    }
                }
                if (args[0].equalsIgnoreCase("help")) {
                    if (sender.hasPermission("InformationPlus.main")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("help.border")));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("help.header")));
                        for (String help : Informationplus.getInstance().config.getStringList("help.lines")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("help.border")));
                        return true;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Informationplus.getInstance().config.getString("main.unknown")));
                    return true;
                }
                return false;
            }
            return false;
        }
    }