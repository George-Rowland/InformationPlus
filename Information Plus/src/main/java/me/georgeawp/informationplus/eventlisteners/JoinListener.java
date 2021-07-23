package me.georgeawp.informationplus.eventlisteners;

import me.georgeawp.informationplus.Informationplus;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public boolean onPlayerJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();
        if(!p.hasPermission("InformationPlus.join")) {
            return true;
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&' , Informationplus.getInstance().config.getString("join.border")));

        for(String onjoin : Informationplus.getInstance().config.getStringList("join.lines"))
        p.sendMessage(ChatColor.translateAlternateColorCodes('&' , onjoin));
        return false;
    }



}
