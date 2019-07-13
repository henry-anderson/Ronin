package org.henrya.dkpcounter;

import java.util.TreeMap;

/**
 * A simple class for temporarily storing points
 * A TreeMap is used so the player names are alphabetized
 * @author Henry Anderson
 */
public class PointStore {
	private TreeMap<String, Integer> points = new TreeMap<>();
	
	/**
	 * Adds points to a specific player
	 * @param player The player's name
	 * @param points The amount of points to add
	 */
	public void addPoint(String player, int points) {
		if(this.points.containsKey(player)) {
			int currentPoints = this.points.get(player);
			int total = currentPoints + points;
			this.points.put(player, total);
		}
		else {
			this.points.put(player, points);
		}
	}
	
	/**
	 * Returns the TreeMap that stores the player's point totals
	 * @return A TreeMap
	 */
	public TreeMap<String, Integer> getMap() {
		return this.points;
	}

}
