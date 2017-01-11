package net.riotpowerups.main;

import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PowerUpHandler implements Listener{
	
	@SuppressWarnings("unused")
	private RiotPowerups plugin;
	public PowerUpHandler(RiotPowerups power){
		plugin = power;
	}
	
	@EventHandler
	public void onPowerupGet(PlayerMoveEvent e){
		List<Entity> nearbyPlayers;
	    nearbyPlayers = e.getPlayer().getNearbyEntities(0.3, 0.3, 0.3);
	      	for (Entity powerup : nearbyPlayers) {
	      		if(powerup instanceof ArmorStand){
	      			if(powerup.getCustomName().equals(PowerupType.HEAL.getName())){
	    				if(((ArmorStand) powerup).getHelmet().equals(PowerupType.HEAL.getItemType())){
	    				powerup.remove();
	    				powerup.getWorld().playEffect(powerup.getLocation().add(0, 0.9, 0), Effect.STEP_SOUND, 152);
	    				e.getPlayer().playSound(powerup.getLocation(), Sound.ENTITY_ENDERDRAGON_FLAP, Integer.MAX_VALUE, Integer.MAX_VALUE);
	    				if(e.getPlayer().getHealth() + 10.0 > 20.0){
	    					e.getPlayer().setHealth(20.0);
	    				}else{
	    					e.getPlayer().setHealth(e.getPlayer().getHealth() + 10.0);
	    				}
	    			}
	    		}
	      	}
	    }
	}
}
