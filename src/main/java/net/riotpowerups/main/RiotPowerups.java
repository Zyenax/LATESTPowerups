package net.riotpowerups.main;

import net.riotcore.main.RiotCore;
import net.riotcore.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RiotPowerups extends JavaPlugin implements Listener {
	
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	static Location loc = new Location(Bukkit.getWorld("world"), 0.5, 4.0, 0.5);
	
	public void onEnable(){
		registerListeners();
		RiotCore.useCoreChat = false;
		RiotCore.useCoreTabAndTag = false;
		console.sendMessage(Utils.color(RiotCore.name + " &aPowerups enabled!"));
		for(Entity e : Bukkit.getWorld("world").getEntities()){
			if(!(e instanceof Player)){
				e.remove();
			}
		}
		ArmorStand powerup = (ArmorStand)Bukkit.getWorld("world").spawnEntity(loc, EntityType.ARMOR_STAND);
		powerup.setCustomName(PowerupType.HEAL.getName());
		powerup.setSmall(true);
		powerup.setInvulnerable(true);
		powerup.setBasePlate(false);
		powerup.setCollidable(false);
		powerup.setCustomNameVisible(true);
		powerup.getEquipment().setHelmet(PowerupType.HEAL.getItemType());
		powerup.setVisible(false);
		powerup.setGravity(false);
	}
	
	public void onDisable(){
		console.sendMessage(Utils.color(RiotCore.name + " &cPowerups disabled!"));
		for(Entity e : Bukkit.getWorld("world").getEntities()){
			if(!(e instanceof Player)){
				e.remove();
			}
		}
	}

	public void registerListeners(){
		PluginManager manager = Bukkit.getPluginManager();
		manager.registerEvents(new PowerUpHandler(this), this);
	}
}
