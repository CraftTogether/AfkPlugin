package xyz.crafttogether.weg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.crafttogether.weg.listeners.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class Weg extends JavaPlugin {

    private static JavaPlugin plugin;
    private static final HashSet<UUID> afkPlayers = new HashSet<>();
    private static final HashMap<UUID, Long> lastInteraction = new HashMap<>();

    private static final Set<EventListener> listeners = new HashSet<>();

    private static long afkDelay;
    private static final Timer timer = new Timer();

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
        afkDelay = getConfig().getLong("afkdelay") * 60000;

        getCommand("afk").setExecutor(new Command());
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new MessageListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new LeaveListener(), this);

        addListener(new WegListener());

        TimerTask afkCheck = new TimerTask() {
            @Override
            public void run() {
                for (Map.Entry<UUID, Long> entry : lastInteraction.entrySet()) {
                    if (isAfk(entry.getKey())) {
                        continue;
                    }
                    if (entry.getValue() + afkDelay < System.currentTimeMillis()) {
                        Player player = Bukkit.getPlayer(entry.getKey());
                        assert player != null;
                        for (EventListener event : listeners) {
                            event.onAfkEvent(player);
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(afkCheck, 0, 600);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Weg enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Weg disabled");
        listeners.clear();
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
    public static Long getLastInteraction(UUID player) {
        return lastInteraction.getOrDefault(player, null);
    }

    public static void updateLastInteraction(UUID player) {
        lastInteraction.remove(player);
        lastInteraction.put(player, System.currentTimeMillis());
    }

    public static void removePlayer(UUID player) {
        lastInteraction.remove(player);
        afkPlayers.remove(player);
    }

    public static boolean addPlayer(UUID player) {
        if (!lastInteraction.containsKey(player)) {
            lastInteraction.put(player, System.currentTimeMillis());
            return true;
        }
        return false;
    }

    public static int getAfkPlayers() {
        return afkPlayers.size();
    }

    public static void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public static void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public static Set<EventListener> getEventListeners() {
        return listeners;
    }
}
