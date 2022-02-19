package fr.redboard.randomdrops.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;

import fr.redboard.randomdrops.utils.DropManager;

public class EventBreakBlock implements Listener {

	private DropManager drop;

	public EventBreakBlock(DropManager dropmanager) {
		this.drop = dropmanager;
	}

	@EventHandler
	public void onDrop(BlockDropItemEvent e) {
		drop.dropItemForBreak(e);
	}
}