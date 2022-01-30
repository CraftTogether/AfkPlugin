package com.github.crafttogether.afkplugin;

import com.github.crafttogether.afkplugin.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

public final class AfkPlugin extends JavaPlugin {

    private static final HashSet<UUID> afkPlayers = new HashSet<>();
    private static final HashMap<UUID, Long> lastMoved = new HashMap<>();

    @Override
    public void onEnable() {

        // Plugin startup logic

        getCommand("afk").setExecutor(new Command());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MessageListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new LeaveListener(), this);
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

    @Nullable
    public static Long getLastMoved(UUID player) {
        return lastMoved.getOrDefault(player, null);
    }

    public static void setMoved(UUID player) {
        lastMoved.remove(player);
        lastMoved.put(player, System.currentTimeMillis());
    }

    public static void removePlayer(UUID player) {
        lastMoved.remove(player);
        afkPlayers.remove(player);
    }

    public static boolean addPlayer(UUID player) {
        if (!lastMoved.containsKey(player)) {
            lastMoved.put(player, System.currentTimeMillis());
            return true;
        }
        return false;
    }
}
