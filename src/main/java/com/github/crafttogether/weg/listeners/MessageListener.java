package com.github.crafttogether.weg.listeners;

import com.github.crafttogether.weg.Weg;
import com.github.crafttogether.weg.events.ReturnEvent;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MessageListener implements Listener {

    @EventHandler
    public void onMessage(AsyncChatEvent event) {
        Player player = event.getPlayer();
        Weg.updateLastInteraction(player.getUniqueId());
        if (Weg.isAfk(player.getUniqueId())) {
            Weg.removeAfkPlayer(player.getUniqueId());
            for (ReturnEvent returnEvent : Weg.getReturnListeners()) {
                returnEvent.invoke(player);
            }
        }
    }
}
