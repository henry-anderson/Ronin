package org.henrya.dkpcounter;

/**
 * An enum that represents whether the points should be for camping, killing, or both
 * There are a number of aliases that can be used to help with typos
 * @author Henry Anderson
 */
public enum PointType {
	KILL(new String[] {"kill", "killl", "kil", "kkil", "ki", "k", "kll", "kl"}),
	CAMP(new String[] {"camp", "campp", "cam", "ca", "c", "cmp", "cp"}),
	CAMP_KILL(new String[] {"campkill", "ckill", "campk", "campkill", "killcamp", "kcamp"});

	private String[] aliases;

	PointType(String[] aliases) {
		this.aliases = aliases;
	}
	
	/**
	 * Returns an array of aliases
	 * @return An array of strings
	 */
	public String[] getAliases() {
		return this.aliases;
	}
	
	/**
	 * Returns a PointType based on an alias
	 * @param typeString The alias
	 * @return A PointType
	 */
	public static PointType getType(String typeString) {
		for(PointType type : PointType.values()) {
			for(String alias : type.getAliases()) {
				if(typeString.equalsIgnoreCase(alias)) {
					return type;
				}
			}
		}
		return null;
	}
}
