package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thrisboss.luckpvp.CommandInterface;
import me.thrisboss.luckpvp.Main;

public class Reload implements CommandInterface{

		public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {	 
			Player p = (Player) sender;
			 
			if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
			if (sender.hasPermission("luckpvp.reload"))
				 Main.getPlugin().saveConfig();
			     Main.getPlugin().reloadConfig();
			     p.sendMessage(ChatColor.GREEN + "[LuckPvP] Config reloaded!");
			     System.out.println("[LuckPvP] Config reloaded!");
			     
			{

               }
			}
		
		return false;
  }
}