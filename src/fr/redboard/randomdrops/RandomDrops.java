package fr.redboard.randomdrops;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.redboard.randomdrops.commands.ManagerCmd;
import fr.redboard.randomdrops.listener.EventBreakBlock;
import fr.redboard.randomdrops.listener.MobsDeath;
import fr.redboard.randomdrops.utils.DropManager;
import fr.redboard.randomdrops.utils.ManagerConfig;
import fr.redboard.randomdrops.utils.Probability;

public class RandomDrops extends JavaPlugin {

	private ManagerConfig managerconfig;
	private Probability probability;
	public FileConfiguration config = this.getConfig();
	private DropManager dropmanager;

	@Override
	public void onEnable() {
		saveDefaultConfig();

		managerconfig = new ManagerConfig(this);
		probability = new Probability(managerconfig);
		dropmanager = new DropManager(managerconfig, probability);
		startClass(this, this);
		getCommand("drops").setExecutor(new ManagerCmd(managerconfig, this));
	}
	
	public void startClass(Plugin MobsDeath, Plugin EventBreakBlock) {
		if (managerconfig.getBoolEntity()) {
			Bukkit.getPluginManager().registerEvents(new MobsDeath(dropmanager), this);
		} else HandlerList.unregisterAll(MobsDeath);
		if (managerconfig.getBoolBlocks()) {
			Bukkit.getPluginManager().registerEvents(new EventBreakBlock(dropmanager), this);
		} else HandlerList.unregisterAll(EventBreakBlock);
	}
	
}