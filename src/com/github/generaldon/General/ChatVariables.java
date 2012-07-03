package com.github.generaldon.General;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
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
	
	
//	Old Block
//	String[][] LANGUAGE_DATA = new String[4][30];
//	String ROVIE_NAME = "rovie";
//	int ROVIE_POWER = 10;
//	int LANGUAGE = 0;
//	String MURK_NAME = "murk";
//	String SHROOMS_NAME = "shrooms";
//	String BATHOL_NAME = "bathol";
//	String ANTITRIP_NAME = "anti-trip";
//	String ANTIADDICTION_NAME = "anti-addiction";
//	int ANTIADDICTION_POWER = 5;
//	FileConfiguration config;


//	  public String getDAT(int col, int MULTIPLIER)
//	  {
//	  String RESULT = this.LANGUAGE_DATA[this.LANGUAGE][col];
//	  RESULT = RESULT.replaceAll("%murk%", ChatColor.DARK_GREEN + ConfigManager.Murk() + ChatColor.WHITE);
//	  if (MULTIPLIER > 0)
//	    RESULT = RESULT.replace("%mult%", String.valueOf(MULTIPLIER));
//	  return RESULT;
//	 }
//	public void FILL_ARRAYS() {
//		  this.LANGUAGE_DATA[0][0] = "";
	
	public static String[] LANGUAGE_DATA = new String[30];
	  String ROVIE_NAME = "rovie";
	  int ROVIE_POWER = 10;
	  int LANGUAGE = 0;
	  String MURK_NAME = "murk";
	  String SHROOMS_NAME = "shrooms";
	  String BATHOL_NAME = "bathol";
	  String ANTITRIP_NAME = "anti-trip";
	  String ANTIADDICTION_NAME = "anti-addiction";
	  int ANTIADDICTION_POWER = 5;
	  FileConfiguration config;
	  
	
	  public String getDAT(int col, int MULTIPLIER)
	  {
	    String RESULT = ChatVariables.LANGUAGE_DATA[col];
	    RESULT = RESULT.replaceAll("%murk%", ChatColor.DARK_GREEN + ConfigManager.Murk() + ChatColor.WHITE);
	    if (MULTIPLIER > 0)
	      RESULT = RESULT.replace("%mult%", String.valueOf(MULTIPLIER));
	    return RESULT;
	  }
	  public void FILL_ARRAYS() {
		    ChatVariables.LANGUAGE_DATA[0] = "You are no longer addicted to %rovie%";
		    ChatVariables.LANGUAGE_DATA[1] = "You are feeling a bit too wasted to do any drugs right now.";
		    ChatVariables.LANGUAGE_DATA[2] = "You feel a rush of energy surging through your body as you snort a %mult%g rock of %rovie%.";
		    ChatVariables.LANGUAGE_DATA[3] = "You feel a tad dizzy as you gulp down a litre of %bathol%.";
		    ChatVariables.LANGUAGE_DATA[4] = "Oh no, the liquid has somehow made you temporarily blind!";
		    ChatVariables.LANGUAGE_DATA[5] = "You feel incredibly relaxed, as you smoke %mult% spliff(s) of %murk%.";
		    ChatVariables.LANGUAGE_DATA[6] = "You found a good batch of %shrooms%.";
		    ChatVariables.LANGUAGE_DATA[7] = "You found a neutral batch of %shrooms%.";
		    ChatVariables.LANGUAGE_DATA[8] = "You found a poisonous batch of %shrooms%.";
		    ChatVariables.LANGUAGE_DATA[9] = "You don't smoke %murk% by right-clicking on a block - click somewhere else to smoke it.";
		    ChatVariables.LANGUAGE_DATA[10] = "You don't swallow pills by right-clicking on a block - click somewhere else to swallow them.";
		    ChatVariables.LANGUAGE_DATA[11] = "You don't snort %rovie% by right-clicking on a block - click somewhere else to snort it.";
		    ChatVariables.LANGUAGE_DATA[12] = "You don't drink %bathol% by right-clicking on a block - click somewhere else to gulp it down.";
		    ChatVariables.LANGUAGE_DATA[13] = "You are feeling a bit too wasted to smoke any %murk%.";
		    ChatVariables.LANGUAGE_DATA[14] = "There's really no point in taking %anti-trip% pills when you're not high.";
		    ChatVariables.LANGUAGE_DATA[15] = "You feel relieved as all the effects of the drugs are removed.";
		    ChatVariables.LANGUAGE_DATA[16] = "There's really no point in taking %anti-addiction% pills when you're not addicted.";
		    ChatVariables.LANGUAGE_DATA[17] = "You are feeling a bit too wasted to swallow any %anti-addiction% pills.";
		    ChatVariables.LANGUAGE_DATA[18] = "You're left with an awful taste in your mouth as you swallow the purple-looking pill, but hurray! -you are no longer addicted to %rovie%.";
		    ChatVariables.LANGUAGE_DATA[19] = "You're left with an awful taste in your mouth as you swallow the purple-looking pill. You still need to take %mult% additional pills to cure your dependence.";
		    ChatVariables.LANGUAGE_DATA[20] = "You are feeling a bit too wasted to snort any %rovie%.";
		    ChatVariables.LANGUAGE_DATA[21] = "You are now a complete junkie. Congratulations!";
		    ChatVariables.LANGUAGE_DATA[22] = "You are now severely addicted to %rovie%.";
		    ChatVariables.LANGUAGE_DATA[23] = "You are now moderately addicted to %rovie%.";
		    ChatVariables.LANGUAGE_DATA[24] = "You are now slightly addicted to %rovie%.";
		    ChatVariables.LANGUAGE_DATA[25] = "You are feeling a bit too wasted to ingest any %shrooms%.";
		    ChatVariables.LANGUAGE_DATA[26] = "You are feeling a bit too drunk to gulp down any %bathol%.";
		    ChatVariables.LANGUAGE_DATA[27] = "You cannot take drugs while in Creative Mode.";
		    ChatVariables.LANGUAGE_DATA[28] = "You are suffering withdrawals from a lack of %rovie%.";
		    ChatVariables.LANGUAGE_DATA[29] = "You can't drug people if they're already high.";
	  }

}
