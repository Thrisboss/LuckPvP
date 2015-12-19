package Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.thrisboss.luckpvp.ArenaManager;
import me.thrisboss.luckpvp.CommandInterface;


public class Join implements CommandInterface {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		
		if(args.length == 2 && args[0].equalsIgnoreCase("join")){
			if (sender.hasPermission("luckpvp.join")){
				if(ArenaManager.isInGame(p)){
					p.sendMessage(ChatColor.RED + "You already are in a game!");
					return true;
				}
				 int num = 0;
				 if(ArenaManager.arenas.contains(num) || ArenaManager.arenas.contains(Integer.parseInt(args[1]))){
		            ArenaManager.addPlayer(p, num);
		            p.sendMessage(ChatColor.GREEN + "You have joined the game");
		            return true;
				 }

				 p.sendMessage(ChatColor.RED + "Invalid ID!");
		            return true;
			
			}
			p.sendMessage(ChatColor.RED + "You do not have the permission!");
			return true;
			}
		return true;
}
	public String name() {
		return "join";
	}
	
	public String info() {
		return "Join a game.";
	}
	
	public String[] aliases() {
		return new String[] { "j" };
	}
	
	
}
	


