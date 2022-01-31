package xyz.crafttogether.weg.listeners;

import xyz.crafttogether.weg.EventListener;
import xyz.crafttogether.weg.Weg;
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
            for (EventListener listener : Weg.getEventListeners()) {
                listener.onReturnEvent(player);
            }
        }
    }
}
