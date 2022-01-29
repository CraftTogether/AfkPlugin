package com.x3rition.afk_plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class AfkPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("afk").setExecutor(new Command());
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "AFK Plugin is active");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
