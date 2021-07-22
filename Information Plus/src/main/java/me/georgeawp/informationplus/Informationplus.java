package me.georgeawp.informationplus;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Informationplus extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // /serverinformation
        if (label.equalsIgnoreCase("server")) {
            if (!sender.hasPermission("InformationPlus.main")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("main.error")));
                return true;
            }
            if (args.length == 0) {
                // /server
                if (sender.hasPermission("InformationPlus.main")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("commands.border")));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("commands.header")));
                    for(String commands : this.getConfig().getStringList("commands.lines")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', commands));
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("commands.border")));
                    return true;
                }
                return true;
            }
            if (args.length > 0) {
                // /server reload
                if (args[0].equalsIgnoreCase("reload")) {
                    if (sender.hasPermission("InformationPlus.reload")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("reload.message")));
                        this.reloadConfig();
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("reload.error")));
                        return true;
                    }
                }

                if (args[0].equalsIgnoreCase("links")) {
                    if (sender.hasPermission("InformationPlus.main")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("links.border")));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("links.header")));
                        for(String links : this.getConfig().getStringList("links.lines")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', links));
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("links.border")));
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("main.error")));
                    }
                }

                if (args[0].equalsIgnoreCase("rules")) {
                    if (sender.hasPermission("InformationPlus.main")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("rules.border")));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("rules.header")));
                        for (String rules : this.getConfig().getStringList("rules.lines")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', rules));
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("rules.border")));
                        return true;
                    } else {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("main.error")));
                    }
                }
                if(args[0].equalsIgnoreCase("help")) {
                    if(sender.hasPermission("InformationPlus.main")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("help.border")));
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("help.header")));
                        for(String help : this.getConfig().getStringList("help.lines")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', help));
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("help.border")));
                        return true;
                    }
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&' , this.getConfig().getString("main.unknown")));
                    return true;
                }
            }

        }
        return false;

    }


}
