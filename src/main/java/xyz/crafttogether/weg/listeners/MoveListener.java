package xyz.crafttogether.weg.listeners;

import xyz.crafttogether.weg.EventListener;
import xyz.crafttogether.weg.Weg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Weg.updateLastInteraction(player.getUniqueId());
        if (Weg.isAfk(player.getUniqueId())) {
            for (EventListener listener : Weg.getEventListeners()) {
                listener.onReturnEvent(player);
            }
        }
    }
}
