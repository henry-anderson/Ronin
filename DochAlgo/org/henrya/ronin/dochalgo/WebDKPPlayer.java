package org.henrya.ronin.dochalgo;

import java.util.ArrayList;
import java.util.List;

public class WebDKPPlayer {
	private String name;
	private int id;
	private int points;
	private int lifetimePoints;
	private String guild;
	private String playerClass;
	private long lastActive;
	private List<Award> awards = new ArrayList<Award>();
	private String activity;

	
	public WebDKPPlayer(String name, int id, int points, int lifetimePoints, String guild, String playerClass) {
		this.name = name;
		this.points = points;
		this.id = id;
		this.lifetimePoints = lifetimePoints;
		this.guild = guild;
		this.playerClass = playerClass;
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
	
	public String getGuild() {
		return this.guild;
	}
	
	public String getPlayerClass() {
		return this.playerClass;
	}
	
	public void setLastActive(long lastActive) {
		this.lastActive = lastActive;
	}
	
	public long getLastActive() {
		return this.lastActive;
	}
	
	public List<Award> getAwards() {
		return this.awards;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String getActivity() {
		return this.activity;
	}
	
	public int getPoints30Days() {
		int count = 0;
		for(Award award : this.awards) {
			if((award.getDate() + Main.MONTH) > System.currentTimeMillis()) {
				if(award.getPoints() > 0) {
					count += award.getPoints();
				}
			}
		}
		return count;
	}
	public int getPoints90Days() {
		int count = 0;
		for(Award award : this.awards) {
			if((award.getDate() + (Main.MONTH * 3)) > System.currentTimeMillis()) {
				if(award.getPoints() > 0) {
					count += award.getPoints();
				}
			}
		}
		return count;
	}
}
