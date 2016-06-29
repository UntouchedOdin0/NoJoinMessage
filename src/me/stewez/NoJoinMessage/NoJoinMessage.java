package me.stewez.NoJoinMessage;

import me.stewez.NoJoinMessage.Commands.Commands;
import me.stewez.NoJoinMessage.Listeners.JoinListener;
import me.stewez.NoJoinMessage.Listeners.LeaveListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoJoinMessage extends JavaPlugin {

	//Lets enable the plugin and load files!
	public void onEnable(){
		registerListeners();
		registerCommands();
		
		//Lets save the config.
		
		saveDefaultConfig();
	}
	
	//We need to register the Listeners
	
	private void registerListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new LeaveListener(this), this);
	}
	
	//Lets register the commands.
	
	private void registerCommands(){
		getCommand("nojoinmessage").setExecutor(new Commands(this));
		getCommand("njm").setExecutor(new Commands(this));
	}
}
