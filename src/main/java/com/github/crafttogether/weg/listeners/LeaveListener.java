package com.github.crafttogether.weg.listeners;

import com.github.crafttogether.weg.Weg;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Weg.removePlayer(event.getPlayer().getUniqueId());
    }
}
