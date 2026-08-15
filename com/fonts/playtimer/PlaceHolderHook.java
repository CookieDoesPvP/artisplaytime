package com.fonts.playtimer;

import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class PlaceHolderHook extends PlaceholderExpansion {

	static FileConfiguration config = Main.getInstance().getConfig();
	
    public String getIdentifier() {
        return "artisplaytime";
    }

    public String getPlugin() {
        return null;
    }

    public String getAuthor() {
        return "Gake";
    }

    public String getVersion() {
        return "1.0";
    }

    public String onPlaceholderRequest(Player p, String identifier) {
   
        /*
        Check if the player is online,
        You should do this before doing anything regarding players
         */
        if(p == null){
            return "";
        }
   
	    double ticksPlayed = p.getStatistic(Statistic.PLAY_ONE_TICK);
	    double secondsPlayed = ticksPlayed / 20.0D;
	    double minutesPlayed = secondsPlayed / 60.0D;
	    double hoursPlayed = minutesPlayed / 60.0D;
        
        /*
        %tutorial_name%
        Returns the player name
         */
        if(identifier.equalsIgnoreCase("artisplaytime")){
            return String.valueOf(hoursPlayed);
        }
   
   
        return null;
    }
}