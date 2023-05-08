package me.cinemamc.welcomemanager;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class WelcomeManager extends JavaPlugin {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getLogger().info("Welcome Manager has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
