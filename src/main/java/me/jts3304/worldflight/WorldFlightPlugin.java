package me.jts3304.worldflight;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldFlightPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerWorldChange(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("worldflight.bypass")){
            if(!getConfig().getBoolean("creative-worldflight")) player.setAllowFlight(false);
        }
    }
}
