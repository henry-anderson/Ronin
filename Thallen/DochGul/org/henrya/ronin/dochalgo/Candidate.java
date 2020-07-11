package org.henrya.ronin.dochalgo;

import java.util.List;

public class Candidate {
	private String main;
	List<String> alts;
	private int combinedLifetime;
	private int combined90Days;
	private boolean gloves;
	private boolean chest;
	private boolean legs;
	private boolean boots;
	private boolean helm;

	
	public Candidate(String main, List<String> alts, boolean gloves, boolean chest, boolean legs, boolean boots, boolean helm) {
		this.main = main;
		this.alts = alts;
		this.gloves = gloves;
		this.chest = chest;
		this.legs = legs;
		this.boots = boots;
		this.helm = helm;
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
	
	public int getCombinedLifetime() {
		return this.combinedLifetime;
	}
	
	public void addCombinedLifetime(int points) {
		this.combinedLifetime += points;
	}
	
	public boolean hasGloves() {
		return this.gloves;
	}
	
	public boolean hasChest() {
		return this.chest;
	}
	
	public boolean hasLegs() {
		return this.legs;
	}
	
	public boolean hasBoots() {
		return this.boots;
	}
	
	public boolean hasHelm() {
		return this.helm;
	}
}
