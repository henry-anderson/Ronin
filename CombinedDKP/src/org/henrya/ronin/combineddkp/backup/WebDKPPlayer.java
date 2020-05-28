package org.henrya.ronin.combineddkp.backup;

import java.util.ArrayList;
import java.util.List;

public class WebDKPPlayer {
	private static final long MONTH = 30 * 24 * 60 * 60 * 1000L;
	private String name;
	private int points;
	private int lifetimePoints;
	private String guild;
	private String playerClass;
	private long lastActive;
	private List<WebDKPAward> awards;
	private List<WebDKPAward> loot;
	private String activity;
	private int userId;

	
	public WebDKPPlayer(String name, int userId, int points, int lifetimePoints, String guild, String playerClass) {
		this.awards = new ArrayList<WebDKPAward>();
		this.loot = new ArrayList<WebDKPAward>();
		this.name = name;
		this.points = points;
		this.lifetimePoints = lifetimePoints;
		this.guild = guild;
		this.playerClass = playerClass;
		this.userId = userId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoints() {
		return this.points;
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
	
	public List<WebDKPAward> getAwards() {
		return this.awards;
	}
	
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public String getActivity() {
		return this.activity;
	}
	
	public int getUserID() {
		return this.userId;
	}
	
	public List<WebDKPAward> getLoot() {
		return this.loot;
	}
	
	public int getPoints45Days() {
		int count = 0;
		for(WebDKPAward award : this.awards) {
			if((award.getDate() + (MONTH * 1.5)) > System.currentTimeMillis() && award.getText().toLowerCase().contains("count")) {
				if(award.getPoints() > 0) {
					count += award.getPoints();
				}
			}
		}
		return count;
	}
	public int getPoints90Days() {
		int count = 0;
		for(WebDKPAward award : this.awards) {
			if((award.getDate() + (MONTH * 3)) > System.currentTimeMillis() && award.getText().toLowerCase().contains("count")) {
				if(award.getPoints() > 0) {
					count += award.getPoints();
				}
			}
		}
		return count;
	}
}
