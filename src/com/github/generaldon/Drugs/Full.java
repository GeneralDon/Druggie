package com.github.generaldon.Drugs;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.generaldon.Druggie;
import com.github.generaldon.SLAPI;
import com.github.generaldon.General.ConfigManager;

public class Full {
	
	int l = 0;
	
	  public String getDAT(int col, int MULTIPLIER)
	  {
	    String RESULT = this.LANGUAGE_DATA[this.LANGUAGE][col];
	    RESULT = RESULT.replaceAll("%murk%", ChatColor.DARK_GREEN + ConfigManager.getMurky() + ChatColor.WHITE);
	    if (MULTIPLIER > 0)
	      RESULT = RESULT.replaceAll("%mult%", MULTIPLIER);
	    return RESULT;
	  }
	
	@EventHandler
	  public void useDrug(PlayerInteractEvent event) {
	    Druggie.l += 1;
	    Player p = event.getPlayer();
	    if (!Druggie.Addict.containsKey(p.getName())) {
	      Druggie.Addict.put(p.getName(), Integer.valueOf(0));
	    }
	    int i = ((Integer)Druggie.Addict.get(p.getName())).intValue();
	    if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
	      if (p.getGameMode() == GameMode.SURVIVAL) {
	        if (Druggie.l == 5) {
	          Druggie.l = 0;
	          try {
	            Druggie.logger.info("Saving Stimulatory data...");
	            SLAPI.save(Druggie.Addict, "Stimulatory.DAT");
	            Druggie.logger.info("Save succesful!");
	          } catch (Exception e) {
	            e.printStackTrace();
	          }
	        }
	        if ((event.getMaterial() == Material.INK_SACK) && (p.getItemInHand().getData().getData() == 2) && (p.hasPermission("Stimulatory.murk")))
	          if (p.hasPotionEffect(PotionEffectType.CONFUSION)) {
	            p.sendMessage(getDAT(13, 0));
	          } else {
	            p.getActivePotionEffects().clear();
	            p.playEffect(p.getLocation(), Effect.SMOKE, 7000);
	            int MULTIPLIER = p.getInventory().getItemInHand().getAmount();
	            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (int)(750.0D * Math.floor(Math.sqrt(MULTIPLIER))), 1 * (MULTIPLIER / 5)));
	            p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, (int)(750.0D * Math.floor(Math.sqrt(MULTIPLIER))), 2 * MULTIPLIER));
	            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 2 * MULTIPLIER));
	            p.sendMessage(getDAT(5, MULTIPLIER));
	            Druggie.logger.info(p.getName() + " has smoked " + MULTIPLIER + " spliff(s) of " + ConfigManager.getMurky() + ".");
	            p.setItemInHand(null);
	          }
}
	    }
	}
}
