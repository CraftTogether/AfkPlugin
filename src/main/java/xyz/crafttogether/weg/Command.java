package xyz.crafttogether.weg;

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
        assert sender instanceof Player;
        Player player = (Player) sender;

        if (Weg.isAfk(player.getUniqueId())) {
            Weg.removeAfkPlayer(player.getUniqueId());
            for (EventListener listener : Weg.getEventListeners()) {
                listener.onReturnEvent(player);
            }
        } else {
            Weg.addAfkPlayer(player.getUniqueId());
            for (EventListener listener : Weg.getEventListeners()) {
                listener.onAfkEvent(player);
            }
        }

        return true;
    }
}