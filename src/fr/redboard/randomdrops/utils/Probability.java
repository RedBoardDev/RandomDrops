package fr.redboard.randomdrops.utils;

public class Probability {

	private ManagerConfig config;

	public Probability(ManagerConfig managerconfig) {
		this.config = managerconfig;
	}

	public boolean probabilityRandom() {
		final double test = config.getProbability() / 100;
		if (Math.random() <= test) {
			return true;
		}
		return false;
	}
}
