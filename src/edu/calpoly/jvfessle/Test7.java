package edu.calpoly.jvfessle;

public final class Test7 {
	// COGNITIVE COMPLEXITY: 4
	// CYCLOMATIC COMPLEXITY: 11
	public static String printBits(int y, int z) {
		switch(y | z) {
		case 0:
			return "None";
		case 1:
		case 2:
		case 4:
		case 8:
			return "One bit: " + String.valueOf(HelperClass.leastSetBit(y | z));
		case 3:
		case 5:
		case 6:
			if ((y | z) > 4)
				return "Two bits A: " + String.valueOf(HelperClass.leastSetBit(y | z));
			else
				return "Two bits B: " + String.valueOf(HelperClass.leastSetBit(y | z));
		case 7:
			return "Three bits: " + String.valueOf(HelperClass.leastSetBit(y | z));
		default:
			return "Out of range";
		}
	}
}
