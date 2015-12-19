package me.thrisboss.luckpvp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
 
public class ArenaManager{
	
    //list of arenas
   public static List<Arena> arenas = new ArrayList<Arena>();
   public static int arenaSize = 0;

    

    public static Arena getArena(int i){
        for(Arena a : arenas){
            if(a.getId() == i){
                return a;
            }
        }
        return null;
    }

    public static void addPlayer(Player p, int i){
        Arena a = getArena(i);
        if(a == null){
            p.sendMessage("Invalid arena!");
            return;
        }

        a.getPlayers().add(p.getName());//add them to the arena list of players
        p.getInventory().clear();
    }

    //remove players
    public static void removePlayer(Player p){
        Arena a = null;//make an arena
        for(Arena arena : arenas){
            if(arena.getPlayers().contains(p.getName())){
                a = arena;//if the arena has the player, the arena field would be the arena containing the player
            }
            //if none is found, the arena will be null
        }
        if(a == null || !a.getPlayers().contains(p.getName())){//make sure it is not null
            p.sendMessage("Invalid operation!");
            return;
        }

        a.getPlayers().remove(p.getName());//remove from arena

        p.getInventory().clear();

        p.setFireTicks(0);
    }

    //create arena
    public static Arena createArena(Location l){
        int num = arenaSize + 1;
        arenaSize++;

        Arena a = new Arena(l, num);
        arenas.add(a);

        Main.getPlugin().getConfig().set("Arenas." + num, serializeLoc(l));
        List<Integer> list = Main.getPlugin().getConfig().getIntegerList("Arenas.Arenas");
        list.add(num);
        Main.getPlugin().getConfig().set("Arenas.Arenas", list);
        Main.getPlugin().saveConfig();

        return a;
    }

    public static Arena reloadArena(Location l) {
        int num = arenaSize + 1;
        arenaSize++;
 
        Arena a = new Arena(l, num);
        arenas.add(a);
 
        return a;
    }
    
    public static void removeArena(int i) {
        Arena a = getArena(i);
        if(a == null) {
            return;
        }
        arenas.remove(a);

        Main.getPlugin().getConfig().set("Arenas." + i, null);
        List<Integer> list = Main.getPlugin().getConfig().getIntegerList("Arenas.Arenas");
        list.remove(i);
        Main.getPlugin().getConfig().set("Arenas.Arenas", list);
        Main.getPlugin().saveConfig();    
    }

    public static boolean isInGame(Player p){
        for(Arena a : arenas){
            if(a.getPlayers().contains(p.getName()))
                return true;
        }
        return false;
    }

    public void loadGames(){
        arenaSize = 0;      

        if(Main.getPlugin().getConfig().getIntegerList("Arenas.Arenas").isEmpty()){
            return;
        }
                
        for(int i : Main.getPlugin().getConfig().getIntegerList("Arenas.Arenas")){
            Arena a = reloadArena(deserializeLoc(Main.getPlugin().getConfig().getString("Arenas." + i)));
            a.id = i;
        }
    }

    public static String serializeLoc(Location l){
        return l.getWorld().getName()+","+l.getBlockX()+","+l.getBlockY()+","+l.getBlockZ();
    }
    public static Location deserializeLoc(String s){
        String[] st = s.split(",");
        return new Location(Bukkit.getWorld(st[0]), Integer.parseInt(st[1]), Integer.parseInt(st[2]), Integer.parseInt(st[3]));
    }
}

