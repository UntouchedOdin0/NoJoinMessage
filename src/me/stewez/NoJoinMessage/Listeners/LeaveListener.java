package me.stewez.NoJoinMessage.Listeners;

import me.stewez.NoJoinMessage.NoJoinMessage;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

	private NoJoinMessage _plugin;
	
	public LeaveListener(NoJoinMessage plugin){
		_plugin = plugin;
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		if (_plugin.getConfig().getBoolean("leave.enable-message") == true){
			e.setQuitMessage(_plugin.getConfig().getString("leave.message").replace("&", "§").replace("{player}", e.getPlayer().getName()));
		}
	}
}
