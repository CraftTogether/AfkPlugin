package xyz.crafttogether.weg.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.crafttogether.weg.EventListener;
import xyz.crafttogether.weg.Weg;

public class WegListener extends EventListener {
    @Override
    public void onAfkEvent(Player player) {
        Weg.addAfkPlayer(player.getUniqueId());
        for (Player serverPlayer : Bukkit.getOnlinePlayers()) {
            if (serverPlayer == player) {
                serverPlayer.sendMessage(ChatColor.GRAY + "You are now AFK");
            } else {
                serverPlayer.sendMessage(String.format("%s%s has went AFK", ChatColor.GRAY, player.getName()));
            }
            TextComponent name = Component.text("[AFK] " + player.getName())
                    .color(TextColor.color(128, 128, 128));
            player.playerListName(name);
        }
    }

    @Override
    public void onReturnEvent(Player player) {
        Weg.removeAfkPlayer(player.getUniqueId());
        for (Player serverPlayer : Bukkit.getOnlinePlayers()) {
            if (serverPlayer == player) {
                serverPlayer.sendMessage(ChatColor.GRAY + "You are no longer AFK");
            } else {
                serverPlayer.sendMessage(String.format("%s%s is no longer AFK", ChatColor.GRAY, player.getName()));
            }
            player.playerListName(Component.text(player.getName()));
        }
    }
}
