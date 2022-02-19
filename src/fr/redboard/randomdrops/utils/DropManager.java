package fr.redboard.randomdrops.utils;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import fr.redboard.randomdrops.random.Randomltem;

public class DropManager {

	private ManagerConfig config;
	private Probability proba;

	public DropManager(ManagerConfig managerconfig, Probability proba) {
		this.config = managerconfig;
		this.proba = proba;
	}

	public void dropItemForBreak(BlockDropItemEvent e) {
		World world = e.getBlock().getWorld();
		if (!config.getBlackListWorld().contains(world.getName())) {
			if (e.getPlayer().getGameMode() != GameMode.CREATIVE) {

				boolean probaDrop = proba.probabilityRandom();
				if (probaDrop) { // if probability is true
					e.setCancelled(true);
					boolean stop = false;

					while (stop == false) { // while the item isn't good
						ItemStack randomItem = Randomltem.getRandomItem();
						try {
							Location locItem = e.getBlock().getLocation();
							Material randomItemType = randomItem.getType();
							String[] randomItemList = (randomItemType.toString()).split("LEGACY_");

							if (!randomItemType.isAir() && !randomItemType.equals(Material.AIR) && randomItem.getType() != Material.AIR && randomItem != null) {
								if (!config.getitemBlackList().contains(randomItemList[0])) {
									world.dropItemNaturally(locItem, randomItem);
								}
							}
							stop = true;
						} catch (Exception e2) {
							stop = false;
						}
					}
				}
			} else
				e.setCancelled(false);
		} else
			e.setCancelled(false);
	}

	public void dropItemForDeath(EntityDeathEvent e) {
		World world = e.getEntity().getWorld();
		if (!config.getBlackListWorld().contains(world.getName())) {
			boolean probaDrop = proba.probabilityRandom();
			if (probaDrop) { // if probability is true
				e.getDrops().clear();
				boolean stop = false;
				while (stop == false) { // while the item isn't good
					ItemStack randomItem = Randomltem.getRandomItem();
					try {
						Location locItem = e.getEntity().getLocation();
						Material randomItemType = randomItem.getType();
						String[] randomItemList = (randomItemType.toString()).split("LEGACY_");

						if (!randomItemType.isAir() || !randomItemType.equals(Material.AIR)) {
							if (!config.getitemBlackList().contains(randomItemList[0])) {
								world.dropItemNaturally(locItem, randomItem);
							}
						}
						stop = true;
					} catch (Exception e2) {
						stop = false;
					}
				}
			}
		}
	}

}
