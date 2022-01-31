package xyz.crafttogether.weg.listeners;

import xyz.crafttogether.weg.Weg;
import xyz.crafttogether.weg.events.ReturnEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ReturnListener implements ReturnEvent {
    @Override
    public void invoke(Player player) {
        Weg.removeAfkPlayer(player.getUniqueId());
        player.sendMessage(ChatColor.GRAY + "You are no longer afk");
        player.playerListName(Component.text(player.getName()));
    }
}
