package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thrisboss.luckpvp.CommandInterface;

public class Credits implements CommandInterface{

@Override
    public boolean onCommand(CommandSender sender, Command cmd,
            String commandLabel, String[] args) {
	Player p = (Player) sender;
	 
	  if(args.length > 1) return false;
	  
	if(args.length == 1 && args[0].equalsIgnoreCase("credits")){
	if (sender.hasPermission("luckpvp.credits"))
	{
	
	p.sendMessage(ChatColor.GREEN + "------" + ChatColor.RED + "CREDITS" + ChatColor.GREEN + "------");
	p.sendMessage(ChatColor.GOLD + "-------" + ChatColor.RED + "LUCKPVP:" + ChatColor.GOLD + "-------");
	p.sendMessage(ChatColor.GREEN + "Designed by Thrisboss");
	p.sendMessage(ChatColor.GREEN + "Coded by Thrisboss");
	p.sendMessage(ChatColor.GREEN + "Ideas by Thrisboss and Mantriton");
	p.sendMessage(ChatColor.GREEN + "Youtube: Thrisboss");
	p.sendMessage(ChatColor.GREEN + "Youtube: Mantriton");
	p.sendMessage(ChatColor.GREEN + "------" + ChatColor.RED + "====" + ChatColor.GREEN + "------");
	return true;
	}
	p.sendMessage(ChatColor.RED + "You do not have the permission");
	}
    p.sendMessage(ChatColor.RED + "Wrong Argument(s)");
	
return false;
	
	
}
}
