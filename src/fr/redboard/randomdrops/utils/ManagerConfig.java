package fr.redboard.randomdrops.utils;

import java.util.List;
import java.util.function.Function;

import org.bukkit.configuration.MemoryConfiguration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ManagerConfig {

	private final Plugin plugin;
	private FileConfiguration config;

	public ManagerConfig(Plugin plugin) {
		this.plugin = plugin;
		reload();
	}

	public void reload() {
		plugin.reloadConfig();
		config = plugin.getConfig();
	}

	public void save() {
		plugin.saveConfig();
	}

	public <T> T get(Function<MemoryConfiguration, T> call) {
		return call.apply(config);
	}

	public MemoryConfiguration get() {
		return config;
	}
	
	public final List<String> getitemBlackList() {
		return get().getStringList("BlackListItem");
	}
	
	public final Double getProbability() {
		return get().getDouble("Probability");
	}
	
	public final boolean getBoolEntity() {
		return get().getBoolean("Entity");
	}
	
	public final boolean getBoolBlocks() {
		return get().getBoolean("Blocks");
	}
	
	public final List<String> getBlackListWorld() {
		return get().getStringList("BlacklistWorld");
	}
}
