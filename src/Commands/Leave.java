package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thrisboss.luckpvp.ArenaManager;
import me.thrisboss.luckpvp.CommandInterface;

public class Leave implements CommandInterface {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		
		if(args.length == 1 && args[0].equalsIgnoreCase("leave")){
			if (sender.hasPermission("luckpvp.leave")){
				if(ArenaManager.isInGame(p)){
				ArenaManager.removePlayer(p);
				p.sendMessage(ChatColor.GREEN + "You left the game!");
				return false;
				}
				p.sendMessage(ChatColor.RED + "You are not in a game!");
				return false;
			}
			p.sendMessage(ChatColor.RED + "You do not have permission! ");
			return false;
		}
		p.sendMessage(ChatColor.RED + "Wrong Argument(s)");	
		return false;
 }
}