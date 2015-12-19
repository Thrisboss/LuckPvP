package Commands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thrisboss.luckpvp.ArenaManager;
import me.thrisboss.luckpvp.CommandInterface;

public class Create implements CommandInterface{

	 public boolean onCommand(CommandSender sender, Command cmd,
	            String commandLabel, String[] args) {
		 
	 
		 Player p = (Player) sender;
		 
		  if(args.length < 1) return false;
		  
		if(args.length == 1 && args[0].equalsIgnoreCase("create")){
		if (sender.hasPermission("luckpvp.create"))
		{
			ArenaManager.createArena(p.getLocation());
		    p.sendMessage("Created Arena " + "!");
		    return false;
	}
		p.sendMessage(ChatColor.RED + "You do not have the permission!");
		}
		return false;
		}
	
}