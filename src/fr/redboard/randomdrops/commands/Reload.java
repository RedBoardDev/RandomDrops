package fr.redboard.randomdrops.commands;

import org.bukkit.command.CommandSender;

import fr.redboard.randomdrops.RandomDrops;
import fr.redboard.randomdrops.utils.ManagerConfig;

public class Reload {
	
	private ManagerConfig config;
	private RandomDrops stc;

	public Reload(ManagerConfig managerconfig, RandomDrops stc) {
		this.config = managerconfig;
		this.stc = stc;
	}

	public void reloadconfig(CommandSender sender) {
		config.reload();
		sender.sendMessage(" §freloading successfully completed !");
		stc.startClass(stc, stc);
	}
	
	

}
