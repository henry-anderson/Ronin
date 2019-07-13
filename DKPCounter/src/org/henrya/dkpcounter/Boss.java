package org.henrya.dkpcounter;

/**
 * A class representative of each boss that points are awarded for
 * @author henryanderson
 *
 */
public enum Boss {
	/* DL bosses */
	DL_155(new String[] {"155", "spider", "spidey", "ulrob"}, 0, new int[]{2, 5, 10}),
	DL_160(new String[] {"160", "priest"}, 0, new int[] {2, 5, 10}),
	DL_165(new String[] {"165", "king"}, 0, new int[] {2, 5, 10}),
	DL_170(new String[] {"170", "sreng", "bolg"}, 5, new int[] {2, 5, 10}),
	DL_180(new String[] {"180", "snorri", "snor", "snorr", "troll"}, 5, new int[] {2, 5, 10}),

	/* EDL bosses */
	EDL_185(new String[] {"185", "dog", "doggy", "dogg", "ifryn"}, 0, new int[] {5, 10, 15}),
	EDL_190(new String[] {"190", "skath", "magister"}, 0, new int[] {5, 10, 15}),
	EDL_195(new String[] {"195", "gron", "general"}, 0, new int[] {5, 10, 15}),
	EDL_200(new String[] {"200", "krother", "imp"}, 0, new int[] {5, 10, 15}),
	EDL_205(new String[] {"205", "cragskor", "dragon"}, 5, new int[] {5, 10, 15}),
	EDL_210(new String[] {"210", "revenant", "anguish"}, 5, new int[] {5, 10, 15}),
	EDL_215(new String[] {"215", "unox", "eye"}, 5, new int[] {5, 10, 15});

	private String[] aliases;
	private int campPoints;
	private int[] killPoints;

	/** 
	 * Constructs a new Boss instance
	 * @param aliases The names it can be referred to as
	 * @param campPoints The amount of camp points to award
	 * @param killPoints The amount of kill points to award
	 */
	Boss(String[] aliases, int campPoints, int[] killPoints) {
		this.aliases = aliases;
		this.campPoints = campPoints;
		this.killPoints = killPoints;
	}
	
	/**
	 * Returns the aliases of the boss
	 * @return An array of aliases
	 */
	public String[] getAliases() {
		return this.aliases;
	}
	
	/**
	 * Returns the camp points to award
	 * @return The camp points
	 */
	public int getCampPoints() {
		return this.campPoints;
	}
	
	/**
	 * Returns the kill points to award in an array
	 * @return The kill points
	 */
	public int[] getKillPoints() {
		return this.getKillPoints();
	}
	
	/**
	 * Returns the kill points to award based on the amount of stars
	 * @param stars The stars
	 * @return The kill points
	 */
	public int getKillPoints(int stars) {
		if(stars == 4) {
			return this.killPoints[0];
		}
		else if(stars == 5) {
			return this.killPoints[1];
		}
		else if(stars == 6) { 
			return this.killPoints[2];
		}
		return 0;
	}
	
	/**
	 * Returns a Boss instance based on its name
	 * @param name The name of the boss
	 * @return The boss
	 */
	public static Boss getBoss(String name) {
		for(Boss boss : Boss.values()) {
			for(String alias : boss.getAliases()) {
				if(name.equalsIgnoreCase(alias)) {
					return boss;
				}
			}
		}
		return null;
	}
}
