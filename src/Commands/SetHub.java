package Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.thrisboss.luckpvp.CommandInterface;
import me.thrisboss.luckpvp.Main;

public class SetHub implements CommandInterface {
	
	@Override
	    public boolean onCommand(CommandSender sender, Command cmd,
	            String commandLabel, String[] args) {
		Player p = (Player) sender;
		 
		  if(args.length > 1) return false;
		  
		if(args.length == 1 && args[0].equalsIgnoreCase("sethubloc")){
		if (sender.hasPermission("luckpvp.sethubloc"))
		{
		
	    Main.getPlugin().getConfig().set("hub.loc.world", p.getLocation().getWorld().getName());
		Main.getPlugin().getConfig().set("hub.loc.x", p.getLocation().getX());
		Main.getPlugin().getConfig().set("hub.loc.y", p.getLocation().getY());
		Main.getPlugin().getConfig().set("hub.loc.z", p.getLocation().getZ());
		Main.getPlugin().saveConfig();
		p.sendMessage(ChatColor.GREEN + "Hub Location set!");
		return true;
		}
		p.sendMessage(ChatColor.RED + "You do not have the permission");
		}
        p.sendMessage(ChatColor.RED + "Wrong Argument(s)");
		
	return false;
		
		
   }
}