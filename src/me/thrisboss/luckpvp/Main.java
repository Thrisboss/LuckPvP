package me.thrisboss.luckpvp;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.Base;
import Commands.Create;
import Commands.Credits;
import Commands.Help;
import Commands.Hub;
import Commands.Join;
import Commands.Leave;
import Commands.Reload;
import Commands.SetHub;
import Listeners.JoinEvent;
import Listeners.SignHub;

public class Main extends JavaPlugin implements Listener{
	private static Main plugin;
	
	    public void onEnable() {
	    	final FileConfiguration config = this.getConfig();
	    	getLogger().info("Plugin Enabled");
	    	config.addDefault("[LuckPvP]", "Plugin.yml!");
	    	getConfig().options().copyDefaults(true);
	    	saveConfig();
			registerEvents();
			registerCommands();
			plugin = this;
		    instance = this;
		}
	    
	    public void registerCommands() {
	 
	        CommandHandler handler = new CommandHandler();
	 
	        handler.register("lpvp", new Base());
	 
	        handler.register("sethubloc", new SetHub());
	        
	        handler.register("reload", new Reload());
	        
	        handler.register("hub", new Hub());
	        
	        handler.register("help", new Help());
	        
	        handler.register("credits", new Credits());
	        
	        handler.register("join", new Join());
	        
	        handler.register("create", new Create());
	        
	        handler.register("leave", new Leave());
	        
	        getCommand("lpvp").setExecutor(handler);
	    }
	 
	 
	
		
		public void onDisable(){
			getLogger().info("Plugin Disabled");
		}
		public void registerEvents(){
	    org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinEvent(), this);
        pm.registerEvents(new SignHub(), this);

		
		
		}

		public static Main instance;
		
		public static Plugin getPlugin() {
			JavaPlugin plugin = Main.plugin;
			return plugin;
			}

	}
		


