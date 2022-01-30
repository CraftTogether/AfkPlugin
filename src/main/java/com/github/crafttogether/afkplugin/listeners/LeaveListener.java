package com.github.crafttogether.afkplugin.listeners;

import com.github.crafttogether.afkplugin.AfkPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        AfkPlugin.removePlayer(event.getPlayer().getUniqueId());
    }
}
