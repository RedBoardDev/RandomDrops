package fr.redboard.randomdrops.random;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Randomltem {
	public static ItemStack getRandomItem() {
		Material[] items = Material.values();
		Random rand = new Random();
		int randomInt = rand.nextInt(items.length);
		ItemStack item = new ItemStack(items[randomInt]);
		return item;
	}
}
