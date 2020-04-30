package org.henrya.ronin.clanreports;

public class WebDKPAward {
	private long date;
	private int points;
	private String text;
	private boolean forItem;
	
	public WebDKPAward(long date, int points, String text, boolean forItem) {
		this.date = date;
		this.points = points;
		this.text = text;
		this.forItem = forItem;
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
	
	public boolean isItem() {
		return this.forItem;
	}
}

