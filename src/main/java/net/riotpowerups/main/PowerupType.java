package net.riotpowerups.main;

import net.riotcore.main.utils.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum PowerupType {
	
	HEAL(Utils.color("&c&lHEAL"), Utils.createItem(Material.WOOL, 1, 14, null, null)),
	SPEED(Utils.color("&b&lSPEED BOOST"), Utils.createItem(Material.WOOL, 1, 9, null, null)),
	FLY(Utils.color("&a&lFLY"), Utils.createItem(Material.WOOL, 1, 5, null, null));
	
	private String powerupname;
	private ItemStack powerupblock;
	
	private PowerupType(String name, ItemStack block){
		this.powerupname = name;
		powerupblock = block;
	}
	
	public String getName(){
		return powerupname;
	}
	
	public ItemStack getItemType(){
		return powerupblock;
	}

}
