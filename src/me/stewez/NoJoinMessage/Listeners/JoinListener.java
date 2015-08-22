package me.stewez.NoJoinMessage.Listeners;

import me.stewez.NoJoinMessage.NoJoinMessage;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

	private NoJoinMessage _plugin;
	
	public JoinListener(NoJoinMessage plugin){
		_plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		if (_plugin.getConfig().getBoolean("join.enable-message") == true){
			e.setJoinMessage(_plugin.getConfig().getString("join.message").replace("&", "§").replace("{player}", e.getPlayer().getName()));
		}
	}
}
