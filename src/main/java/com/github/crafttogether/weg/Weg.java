package com.github.crafttogether.weg;

import com.github.crafttogether.weg.events.AfkEvent;
import com.github.crafttogether.weg.events.ReturnEvent;
import com.github.crafttogether.weg.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class Weg extends JavaPlugin {

    private static JavaPlugin plugin;
    private static final HashSet<UUID> afkPlayers = new HashSet<>();
    private static final HashMap<UUID, Long> lastMoved = new HashMap<>();

    private static final List<AfkEvent> afkListeners = new ArrayList<>();
    private static final List<ReturnEvent> returnListeners = new ArrayList<>();

    private static long afkDelay;
    private static final Timer timer = new Timer();
    private static TimerTask afkCheck;

    @Override
    public void onEnable() {
        plugin = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        try {
            getConfig().load(Files.newBufferedReader(Path.of(plugin.getDataFolder() + "/config.yml")));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        afkDelay = getConfig().getLong("afkdelay") * 1000;

        getCommand("afk").setExecutor(new Command());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MessageListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new LeaveListener(), this);

        afkCheck = new TimerTask() {
            @Override
            public void run() {
                for (Map.Entry<UUID, Long> entry : lastMoved.entrySet()) {
                    if (entry.getValue() + afkDelay <= System.currentTimeMillis()) {
                        Player player = Bukkit.getPlayer(entry.getKey());
                        assert player != null;
                        for (AfkEvent event : afkListeners) {
                            event.invoke(player);
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(afkCheck, 0, 60000);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Weg enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Weg disabled");
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

    public static void addAfkListener(AfkEvent event) {
        afkListeners.add(event);
    }

    public static List<AfkEvent> getAfkListeners() {
        return afkListeners;
    }

    public static void addReturnListener(ReturnEvent event) {
        returnListeners.add(event);
    }

    public static List<ReturnEvent> getReturnListeners() {
        return returnListeners;
    }
}
