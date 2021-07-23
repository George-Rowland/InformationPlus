package me.georgeawp.informationplus;

import me.georgeawp.informationplus.commands.HelpCommand;
import me.georgeawp.informationplus.commands.InformationCommands;
import me.georgeawp.informationplus.commands.LinksCommand;
import me.georgeawp.informationplus.commands.RulesCommand;
import me.georgeawp.informationplus.eventlisteners.JoinListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Informationplus extends JavaPlugin {

    public static Informationplus instance = null;
    public FileConfiguration config;

    public static Informationplus getInstance() {
        return instance;
    }

    public String getVersion() { // Get version for /informationplus command.
        return this.getDescription().getVersion();
    }

    public void reloadConfiguration() {
        this.reloadConfig();
        config = this.getConfig();
    }


    @Override
    public void onEnable() {
        Informationplus.instance = this;
        config = this.getConfig();
        config.options().copyDefaults(true);
        this.saveConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getCommand("informationplus").setExecutor(new InformationCommands());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("links").setExecutor(new LinksCommand());
        getCommand("help").setExecutor(new HelpCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
