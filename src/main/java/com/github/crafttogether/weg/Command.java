package com.github.crafttogether.weg;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command must be ran by a player");
        }
        Player player = (Player) sender;

        if (Weg.isAfk(player.getUniqueId())) {
            Weg.removeAfkPlayer(player.getUniqueId());
            player.sendMessage(ChatColor.GRAY + "You are no longer AFK");
        } else {
            Weg.addAfkPlayer(player.getUniqueId());
            player.sendMessage(ChatColor.GRAY + "You are now AFK");
        }

        return true;
    }
}