package com.github.crafttogether.weg.listeners;

import com.github.crafttogether.weg.Weg;
import com.github.crafttogether.weg.events.AfkEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AfkListener implements AfkEvent {
    @Override
    public void invoke(Player player) {
        Weg.addAfkPlayer(player.getUniqueId());
        player.sendMessage(ChatColor.GRAY + "You are now AFK");
    }
}
