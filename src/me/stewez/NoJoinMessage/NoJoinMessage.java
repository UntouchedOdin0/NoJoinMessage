package me.stewez.NoJoinMessage;

import me.stewez.NoJoinMessage.Commands.Commands;
import me.stewez.NoJoinMessage.Listeners.JoinListener;
import me.stewez.NoJoinMessage.Listeners.LeaveListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoJoinMessage extends JavaPlugin {

	public void onEnable(){
		registerListeners();
		registerCommands();
		
		saveDefaultConfig();
	}
	
	private void registerListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new LeaveListener(this), this);
	}
	
	private void registerCommands(){
		getCommand("nojoinmessage").setExecutor(new Commands(this));
		getCommand("njm").setExecutor(new Commands(this));
	}
}
