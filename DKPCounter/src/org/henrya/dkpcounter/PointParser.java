package org.henrya.dkpcounter;

/**
 * A class for parsing a raw line of text using the following syntax
 * [boss] [stars] [camp/kill] on [player1, player2, player3...]
 * Use "campkill" or "ckill" if everyone camped and killed
 * Example: Sreng 5 kill on Thallen, Unpleased, Kilzalot, Kiara Evangelin
 * 
 * @author Henry Anderson
 */
public class PointParser {
	private String line;
	private String[] players;
	private Boss boss;
	private int stars;
	private PointType type;
	
	/**
	 * Constructs the instance and parses the line
	 * @param line The raw string
	 */
	public PointParser(String line) {
		this.line = line.toLowerCase();
		String[] splitOn = this.line.split(" on ");
		String first = splitOn[0];
		this.players = splitOn[1].split(", ");
		String[] keywords = first.split(" ");
		this.boss = Boss.getBoss(keywords[0]);
		this.stars = Integer.valueOf(keywords[1]);
		this.type = PointType.getType(keywords[2]);
	}
	
	/**
	 * Returns the names of each player
	 * @return A String array
	 */
	public String[] getPlayers() {
		return this.players;
	}
	
	/**
	 * Returns a Boss instance
	 * @return a Boss
	 */
	public Boss getBoss() {
		return this.boss;
	}
	
	/**
	 * Returns the number of stars
	 * @return An integer
	 */
	public int getStars() {
		return this.stars;
	}
	
	/**
	 * Returns the type of points to award (camp/kill/campkill)
	 * @return A PointType instance
	 */
	public PointType getType() {
		return this.type;
	}
}
