package xyz.crafttogether.weg.listeners;

import xyz.crafttogether.weg.Weg;
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
        if (!Weg.addPlayer(event.getPlayer().getUniqueId())) {
            logger.error("Could not add player to hashmap, player already exists");
        }
    }
}
