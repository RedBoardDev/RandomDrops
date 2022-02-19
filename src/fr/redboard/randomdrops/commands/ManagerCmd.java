package fr.redboard.randomdrops.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.redboard.randomdrops.RandomDrops;
import fr.redboard.randomdrops.utils.ManagerConfig;

public class ManagerCmd extends Reload implements CommandExecutor {

	public ManagerCmd(ManagerConfig managerconfig, RandomDrops stc) {
		super(managerconfig, stc);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if (cmd.getName().equalsIgnoreCase("drops")) {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					reloadconfig(sender);
				}
			}
		}

		return false;
	}

}
