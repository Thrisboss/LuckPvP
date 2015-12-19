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

public class Hub implements CommandInterface {
	
	@Override
	    public boolean onCommand(CommandSender sender, Command cmd,
	            String commandLabel, String[] args) {
		Player p = (Player) sender;
		 
		  if(args.length > 1) return false;
		  
		if(args.length == 1 && args[0].equalsIgnoreCase("hub")){
		if (sender.hasPermission("luckpvp.hub"))
		{
	        World world = Bukkit.getServer().getWorld(Main.getPlugin().getConfig().getString("hub.loc.world"));
			   
            int x = Main.getPlugin().getConfig().getInt("hub.loc.x");
            int y = Main.getPlugin().getConfig().getInt("hub.loc.y");
            int z = Main.getPlugin().getConfig().getInt("hub.loc.z");
            Location hub = new Location(world, x, y, z);
            p.teleport(hub);
		
		p.sendMessage(ChatColor.GREEN + "Teleported to hub!");
		return true;
		}
		p.sendMessage(ChatColor.RED + "You do not have the permission");
		}
        p.sendMessage(ChatColor.RED + "Wrong Argument(s)");
		
	return false;
		
		
   }
}
