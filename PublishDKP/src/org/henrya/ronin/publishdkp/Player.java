package org.henrya.ronin.publishdkp;

public class Player {
	private String name;
	private int id;
	private int points;
	private int lifetimePoints;
	
	public Player(String name, int id, int points, int lifetimePoints) {
		this.name = name;
		this.points = points;
		this.id = id;
		this.lifetimePoints = lifetimePoints;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getLifetimePoints() {
		return this.lifetimePoints;
	}
}
