package com.x3rition.afk_plugin;


import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Command implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        //join/leave team
        player.sendMessage(ChatColor.WHITE + "You are marked as AFK now");
        player.sendMessage(ChatColor.GRAY + "Move around or repeat command");
        player.sendMessage(ChatColor.GRAY + "that you'll be unmarked");
        return false;
    }
}