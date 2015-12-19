package Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thrisboss.luckpvp.CommandInterface;
import me.thrisboss.luckpvp.Main;

public class Help implements CommandInterface {
	
	@Override
	    public boolean onCommand(CommandSender sender, Command cmd,
	            String commandLabel, String[] args) {
		Player p = (Player) sender;
		 
		  if(args.length > 1) return false;
		  
		if(args.length == 1 && args[0].equalsIgnoreCase("help")){
		if (sender.hasPermission("luckpvp.help"))
		{
		
		p.sendMessage(ChatColor.GREEN + "-------" + ChatColor.RED + "HELP" + ChatColor.GREEN + "-------");
		p.sendMessage(ChatColor.GOLD + "------" + ChatColor.RED + "COMMANDS:" + ChatColor.GOLD + "------");
		p.sendMessage(ChatColor.GREEN + "/lpvp sethubloc");
		p.sendMessage(ChatColor.GREEN + "/lpvp hub");
		p.sendMessage(ChatColor.GREEN + "/lpvp reload");
		p.sendMessage(ChatColor.GREEN + "/lpvp credits");
		p.sendMessage(ChatColor.GREEN + "/lpvp help");
		p.sendMessage(ChatColor.GREEN + "-------" + ChatColor.RED + "====" + ChatColor.GREEN + "-------");
		return true;
		}
		p.sendMessage(ChatColor.RED + "You do not have the permission");
		}
        p.sendMessage(ChatColor.RED + "Wrong Argument(s)");
		
	return false;
		
		
   }
}