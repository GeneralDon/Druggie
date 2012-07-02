package com.github.generaldon.General;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.potion.PotionEffectType;

public class ChatVariables {
	protected final ChatColor RED=ChatColor.RED;
	protected final ChatColor GREEN=ChatColor.GREEN;
	protected final ChatColor BLUE=ChatColor.BLUE;
	protected final ChatColor YELLOW=ChatColor.YELLOW;
	protected final ChatColor WHITE=ChatColor.WHITE;
	
	@EventHandler
	  public void onChat(PlayerChatEvent e) {
	    Player p = e.getPlayer();
	    String s = "";
	    if (p.hasPotionEffect(PotionEffectType.CONFUSION)) {
	      String[] wordList = e.getMessage().split(" ");
	      Calendar currentDate = Calendar.getInstance();
	      SimpleDateFormat formatter = 
	        new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
	      String dateNow = formatter.format(currentDate.getTime());
	      Random r = new Random(dateNow.hashCode());
	      for (int i = 0; i < wordList.length; i++) {
	        int rn = r.nextInt(30);
	        if (rn < 12) {
	          int rn2 = r.nextInt(3);
	          int rn3 = r.nextInt(3);
	          if (rn2 == 0) {
	            String s2 = wordList[i];
	            s2 = s2.replace(".", "..!");
	            s2 = s2.replace("?", "?!?");
	            s = s + s2.substring(0, 1) + "-" + s2;
	          }
	          if (rn3 == 0) {
	            String s2 = wordList[i];
	            s2 = s2.replace("a", "ah");
	            s2 = s2.replace("y", "a");
	            s2 = s2.replace("u", "y");
	            s2 = s2.replace("e", "i");
	            s2 = s2.replace("d", "t");
	            s2 = s2.replace("b", "d");
	            s2 = s2.replace("e", "ei");
	            s2 = s2.replace("g", "v");
	            s2 = s2.replace("o", "oo");
	            s2 = s2.replace("w", "v");
	            s2 = s2.replace("s", "ts");
	            s2 = s2.replace("u", "i");
	            s2 = s2.replace("m", "mn");
	            s = s + s2;
	          }
	        } else {
	          s = s + wordList[i];
	        }
	        if (i < wordList.length)
	          s = s + " ";
	      }
	      e.setMessage(s);
	    }
	  }

}
