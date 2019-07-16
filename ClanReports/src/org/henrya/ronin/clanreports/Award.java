package org.henrya.ronin.clanreports;

public class Award {
	private long date;
	private int points;
	
	public Award(long date, int points) {
		this.date = date;
		this.points = points;
	}
	
	public long getDate() {
		return this.date;
	}
	
	public int getPoints() {
		return this.points;
	}
}
