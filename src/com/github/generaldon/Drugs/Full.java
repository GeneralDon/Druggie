package com.github.generaldon.Drugs;

import java.util.logging.Logger;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.generaldon.Druggie;

public class Full {
	
	int l = 0;
	public static final Logger logger=Logger.getLogger("Minecraft");
	
	public void useDrug(PlayerInteractEvent event) { this.l += 1;
    Player p = event.getPlayer();
    if (!Druggie.Addict.containsKey(p.getName())) {
      Druggie.Addict.put(p.getName(), Integer.valueOf(0));
    }
	if ((event.getMaterial() == Material.INK_SACK) && (p.getItemInHand().getData().getData() == 2))
        if (p.hasPotionEffect(PotionEffectType.CONFUSION)) {
          p.sendMessage("You are feeling a bit too wasted to smoke any murk.");
        } else {
          p.getActivePotionEffects().clear();
          p.playEffect(p.getLocation(), Effect.SMOKE, 7000);
          int MULTIPLIER = p.getInventory().getItemInHand().getAmount();
          p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (int)(750.0D * Math.floor(Math.sqrt(MULTIPLIER))), 1 * (MULTIPLIER / 5)));
          p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, (int)(750.0D * Math.floor(Math.sqrt(MULTIPLIER))), 2 * MULTIPLIER));
          p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 2 * MULTIPLIER));
          p.sendMessage("You feel incredibly relaxed, as you smoke " + MULTIPLIER + " spliff(s) of murk.");
          Druggie.logger.info(p.getName() + " has smoked " + MULTIPLIER + " spliff(s) of murk.");
          p.setItemInHand(null);
        }

}
}
