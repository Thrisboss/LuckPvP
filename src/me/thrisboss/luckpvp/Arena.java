package me.thrisboss.luckpvp;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Arena{

    //you want some info about the arena stored here
    public int id = 0;//the arena id
    List<String> players = new ArrayList<String>();//list of players

    //now let's make a few getters/setters, and a constructor
    public Arena(Location loc, int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public List<String> getPlayers(){
        return this.players;
    }
}