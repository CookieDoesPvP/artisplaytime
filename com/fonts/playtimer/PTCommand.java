package com.fonts.playtimer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.libs.joptsimple.ArgumentAcceptingOptionSpec;
import org.bukkit.entity.Player;

public class PTCommand implements CommandExecutor {
	static FileConfiguration config = Main.getInstance().getConfig();
	
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if (!(sender instanceof Player))
	    {
	      sender.sendMessage("You are not allowed to use this command!");
	      return true;
	    }
	    
	    if (args.length == 0) {
	    
	    Player p = (Player)sender;
	    double ticksPlayed = p.getStatistic(Statistic.PLAY_ONE_TICK);
	    double secondsPlayed = ticksPlayed / 20.0D;
	    double minutesPlayed = secondsPlayed / 60.0D;
	    double hoursPlayed = minutesPlayed / 60.0D;
	    double daysPlayed = hoursPlayed / 24.0D;
	    int days = (int)daysPlayed;
	    int hours = (int)((daysPlayed - days) * 24.0D);
	    int minutes = (int)((hoursPlayed - (hours + days * 24)) * 60.0D);
	    int seconds = (int)((minutesPlayed - (minutes + hours * 60 + days * 60 * 24)) * 60.0D);
	    String str = config.getString("message");
	    str = str.replace("{DAYS}", String.valueOf(days));
	    str = str.replace("{HOURS}", String.valueOf(hours));
	    str = str.replace("{MINUTES}", String.valueOf(minutes));
	    str = str.replace("{SECONDS}", String.valueOf(seconds));
	    
	    p.sendMessage(ChatColor.translateAlternateColorCodes('&', str));
	    return false;
	  
	  } else if (args.length == 1) {
		  if (args[0].equalsIgnoreCase("top")) {
			  
			  if (Bukkit.getOnlinePlayers().size() < 5) {
				  sender.sendMessage(ChatColor.RED + "Cannot create Top5 players without at least 5 players online.");
			  } else {
					HashMap<String, Double> playtime = new HashMap<>();
				  for (Player p : Bukkit.getOnlinePlayers()) {
					  double ticksPlayed = p.getStatistic(Statistic.PLAY_ONE_TICK);
					  
					  playtime.put(p.getName(), (Double)ticksPlayed);
					  
					  
					  
					  
				  }
				  
				  Map sortedMap = sortByValue(playtime);
				  sender.sendMessage(ChatColor.YELLOW + "Top 5 Playtime");
				  for (int i = 1; i < 5; i++) { 
					  sender.sendMessage((ChatColor.GRAY + "" + i + sortedMap.get(i)));

				  }
				  
				  
			  }
			  
			  
			  
			  //print top 5
		
			  
	} else {
		try {
			Player p = Bukkit.getPlayer(args[0]);
			double ticksPlayed = p.getStatistic(Statistic.PLAY_ONE_TICK);
			double secondsPlayed = ticksPlayed / 20.0D;
			double minutesPlayed = secondsPlayed / 60.0D;
			double hoursPlayed = minutesPlayed / 60.0D;
			double daysPlayed = hoursPlayed / 24.0D;
			int days = (int)daysPlayed;
			int hours = (int)((daysPlayed - days) * 24.0D);
			int minutes = (int)((hoursPlayed - (hours + days * 24)) * 60.0D);
			int seconds = (int)((minutesPlayed - (minutes + hours * 60 + days * 60 * 24)) * 60.0D);
			String str = config.getString("message");
			str = str.replace("{DAYS}", String.valueOf(days));
			str = str.replace("{HOURS}", String.valueOf(hours));
		    str = str.replace("{MINUTES}", String.valueOf(minutes));
			str = str.replace("{SECONDS}", String.valueOf(seconds));
				    
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', str)); 
		} catch (Exception e) {
			sender.sendMessage(ChatColor.RED + "This player is not online.");
		}
			  return true;
			  
	}
		  } else {
			  sender.sendMessage(ChatColor.RED + "Wrong command usage. /playtime [name] / top");
			  return false;
		  }
	    return false;
		  
		  
	  
		  
	  }
	  
		public static Map sortByValue(Map unsortedMap) {
			Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
			sortedMap.putAll(unsortedMap);
			return sortedMap;
		}
	 
	}


	class ValueComparator implements Comparator {
		Map map;
	 
		public ValueComparator(Map map) {
			this.map = map;
		}
	 
		public int compare(Object keyA, Object keyB) {
			Comparable valueA = (Comparable) map.get(keyA);
			Comparable valueB = (Comparable) map.get(keyB);
			return valueB.compareTo(valueA);
		}

	
}
