package me.georgeawp.informationplus;

import me.georgeawp.informationplus.commands.InformationCommands;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Informationplus extends JavaPlugin {

    public static Informationplus instance = null;
    public FileConfiguration config;

    public static Informationplus getInstance() {
        return instance;
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
        getCommand("server").setExecutor(new InformationCommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
