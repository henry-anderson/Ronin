package org.henrya.ronin.dochalgo;

public class Award {
	private long date;
	private int points;
	private String text;
	
	public Award(long date, int points, String text) {
		this.date = date;
		this.points = points;
		this.text = text;
	}
	
	public long getDate() {
		return this.date;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public String getText() {
		return this.text;
	}
}
