package xyz.crafttogether.weg.listeners;

import xyz.crafttogether.weg.Weg;
import xyz.crafttogether.weg.events.ReturnEvent;
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
            for (ReturnEvent returnEvent : Weg.getReturnListeners()) {
                returnEvent.invoke(player);
            }
        }
    }
}
