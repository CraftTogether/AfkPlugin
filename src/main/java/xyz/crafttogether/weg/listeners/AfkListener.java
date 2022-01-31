package xyz.crafttogether.weg.listeners;

import xyz.crafttogether.weg.Weg;
import xyz.crafttogether.weg.events.AfkEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class AfkListener implements AfkEvent {
    @Override
    public void invoke(Player player) {
        Weg.addAfkPlayer(player.getUniqueId());
        player.sendMessage(ChatColor.GRAY + "You are now AFK");
        TextComponent name = Component.text("[AFK] " + player.getName()).color(TextColor.color(128, 128, 128));
        player.playerListName(name);
    }
}
