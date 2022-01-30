package com.github.crafttogether.afkplugin.listeners;

import com.github.crafttogether.afkplugin.AfkPlugin;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        Player player = event.getPlayer();
        if (AfkPlugin.isAfk(player.getUniqueId())) {
            AfkPlugin.removePlayer(player.getUniqueId());
            player.sendMessage(ChatColor.GRAY + "You are no longer AFK");
        }
    }
}
