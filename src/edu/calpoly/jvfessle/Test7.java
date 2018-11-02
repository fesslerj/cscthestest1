package edu.calpoly.jvfessle;

public final class Test7 {
	public static String blah7(int y, int z) {//4,11
		switch(y | z) {
		case 0:
			return "None";
		case 1:
		case 2:
		case 4:
		case 8:
			return "One bit: " + String.valueOf(DoubleMathHelper.leastSetBit(y | z));
		case 3:
		case 5:
		case 6:
			if ((y | z) > 4)
				return "Two bits HIGH: " + String.valueOf(DoubleMathHelper.leastSetBit(y | z));
			else
				return "Two bits LOW: " + String.valueOf(DoubleMathHelper.leastSetBit(y | z));
		case 7:
			return "Three bits: " + String.valueOf(DoubleMathHelper.leastSetBit(y | z));
		default:
			return "Out of range";
		}
	}
}
