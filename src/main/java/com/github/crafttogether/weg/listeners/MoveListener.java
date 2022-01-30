package com.github.crafttogether.weg.listeners;

import com.github.crafttogether.weg.Weg;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (Weg.isAfk(player.getUniqueId())) {
            Weg.removeAfkPlayer(player.getUniqueId());
            player.sendMessage(ChatColor.GRAY + "You are no longer AFK");
        }
    }
}
