package me.stewez.NoJoinMessage.Commands;

import java.io.File;

import me.stewez.NoJoinMessage.NoJoinMessage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class Commands implements CommandExecutor{

	private NoJoinMessage _plugin;
	
	public Commands(NoJoinMessage plugin){
		_plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if (commandLabel.equalsIgnoreCase("nojoinmessage")
				|| commandLabel.equalsIgnoreCase("njm")){
			if (args.length < 1){
				sender.sendMessage("§cPlease use /nojoinmessage <reload/fake>");
				return false;
			}
			
			if (args[0].equalsIgnoreCase("reload")){
				if (!(sender.hasPermission("nojoinmessage.reload"))){
					sender.sendMessage("§cYou don't have permission to execute this command.");
					return false;
				}
				
				YamlConfiguration.loadConfiguration(new File(_plugin.getDataFolder(), "config.yml"));
				
				sender.sendMessage("§aSuccesfully reloaded the config file!");
			}else if (args[0].equalsIgnoreCase("fake")){
				if (!(sender.hasPermission("nojoinmessage.fake"))){
					sender.sendMessage("§cYou don't have permission to execute this command.");
					return false;
				}
				
				if (args.length < 3){
					sender.sendMessage("§cPlease use /nojoinmessage fake <join/leave> <username>");
					return false;
				}
				
				if (args[1].equalsIgnoreCase("join")){
					Bukkit.broadcastMessage(_plugin.getConfig().getString("join.message").replace("&", "§").replace("{player}", args[2]));
				}else if (args[1].equalsIgnoreCase("leave")){
					Bukkit.broadcastMessage(_plugin.getConfig().getString("leave.message").replace("&", "§").replace("{player}", args[2]));
				}
			}
		}
		
		return false;
	}
}
