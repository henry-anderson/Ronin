package org.henrya.ronin.combineddkp;

import java.util.List;

public class Player {
	private String main;
	List<String> alts;
	private int combinedLifetime;
	private int combined90Days;
	private int combined45Days;
	
	public Player(String main, List<String> alts) {
		this.main = main;
		this.alts = alts;
	}
	
	public String getMain() {
		return main;
	}
	
	public List<String> getAlts() {
		return this.alts;
	}
	
	public boolean isToon(String name) {
		if(this.main.equalsIgnoreCase(name) || this.alts.contains(name.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public int getCombined90Days() {
		return this.combined90Days;
	}
	
	public void addCombined90Days(int points) {
		this.combined90Days += points;
	}
	
	public int getCombined45Days() {
		return this.combined45Days;
	}
	
	public void addCombined45Days(int points) {
		this.combined45Days += points;
	}
	
	public int getCombinedLifetime() {
		return this.combinedLifetime;
	}
	
	public void addCombinedLifetime(int points) {
		this.combinedLifetime += points;
	}
}
