package com.github.crafttogether.afkplugin.listeners;

import com.github.crafttogether.afkplugin.AfkPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JoinListener implements Listener {
    private static final Logger logger = LoggerFactory.getLogger(LeaveListener.class);

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!AfkPlugin.addPlayer(event.getPlayer().getUniqueId())) {
            logger.error("Could not add player to hashmap, player already exists");
        }
    }
}
