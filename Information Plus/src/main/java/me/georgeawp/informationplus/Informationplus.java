package me.georgeawp.informationplus;

import me.georgeawp.informationplus.commands.*;
import me.georgeawp.informationplus.eventlisteners.JoinListener;
import me.georgeawp.informationplus.metrics.Metrics;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Informationplus extends JavaPlugin {

    public static Informationplus instance = null;
    public FileConfiguration config;

    public static Informationplus getInstance() {
        return instance;
    }

    public String getVersion() {
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
        getCommand("report").setExecutor(new ReportCommand());
        new Metrics(this, 12169);
    }

    @Override
    public void onDisable() {
    }
}
