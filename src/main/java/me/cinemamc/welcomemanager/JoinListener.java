package me.cinemamc.welcomemanager;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        String player = e.getPlayer().getName();
        if (!e.getPlayer().hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GOLD + "Everyone welcome " + player); // NEW PLAYER JOIN MESSAGE
        }

        e.getPlayer().sendMessage(ChatColor.GREEN + "Welcome to the server " + player); // SENDS JOIN MESSAGE
        e.setJoinMessage(ChatColor.YELLOW + player + " has joined Mine Lands!");

        // TITLE
        String title = ChatColor.GREEN + "Welcome to";
        String subtitle = ChatColor.YELLOW + "The Server";
        int fadeIn = 10;
        int stay = 40;
        int fadeOut = 10;

        e.getPlayer().sendTitle(title, subtitle, fadeIn, stay, fadeOut);

        // FIREWORK
        FireworkEffect effect = FireworkEffect.builder()
                .withColor(Color.GREEN)
                .withFade(Color.WHITE)
                .with(FireworkEffect.Type.BALL)
                .trail(true)
                .flicker(false)
                .build();

        Firework firework = e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
        firework.setVelocity(new Vector(0, 1, 0));

        FireworkMeta fireworkMeta = firework.getFireworkMeta();
        fireworkMeta.addEffect(effect);

        firework.setFireworkMeta(fireworkMeta);

        new BukkitRunnable() {
            @Override
            public void run() {
                firework.detonate();
            }
        }.runTaskLater((Plugin) this, 20);
    }
}
