package com.github.crafttogether.afkplugin;

import com.github.crafttogether.afkplugin.listeners.MessageListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashSet;
import java.util.UUID;

public final class AfkPlugin extends JavaPlugin {

    private static final HashSet<UUID> afkPlayers = new HashSet<>();


    @Override
    public void onEnable() {

        // Plugin startup logic

        getCommand("afk").setExecutor(new Command());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MessageListener(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "AFK Plugin is active");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "AFK plugin disabled");
    }

    public static boolean isAfk(UUID player) {
        return afkPlayers.contains(player);
    }

    public static void addAfkPlayer(UUID player) {
        afkPlayers.add(player);
    }

    public static void removeAfkPlayer(UUID player) {
        afkPlayers.remove(player);
    }
}
