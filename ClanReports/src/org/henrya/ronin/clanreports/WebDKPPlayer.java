package org.henrya.ronin.clanreports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebDKPPlayer {
	public static final long MONTH = 30 * 24 * 60 * 60 * 1000L;
	private String name;
	private int points;
	private int lifetimePoints;
	private String guild;
	private String playerClass;
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
	
	public long getLastActive() {
		List<Long> dates = new ArrayList<Long>();
		for(WebDKPAward award : this.awards) {
			if(award.getText().toLowerCase().contains("count")) {
				dates.add(award.getDate());
			}
		}
		long lastActive = (!dates.isEmpty()) ? Collections.max(dates) : 0;
		return lastActive;
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
	
	public int getPoints30Days() {
		int count = 0;
		for(WebDKPAward award : this.awards) {
			if((award.getDate() + MONTH) > System.currentTimeMillis() && award.getText().toLowerCase().contains("count")) {
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
