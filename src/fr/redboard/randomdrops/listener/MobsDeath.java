package fr.redboard.randomdrops.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import fr.redboard.randomdrops.utils.DropManager;

public class MobsDeath implements Listener {

	private DropManager drop;

	public MobsDeath(DropManager dropmanager) {
		this.drop = dropmanager;
	}

	@EventHandler
	public void entityDeath(EntityDeathEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			drop.dropItemForDeath(e);
		}
	}
}