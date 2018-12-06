package edu.calpoly.jvfessle;

public class Switch3Edit {
	// COGNITIVE COMPLEXITY: 4
	// CYCLOMATIC COMPLEXITY: 9
	public static int countBits(int y, int z) {
		switch(y) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 3:
		case 7:
			return 2;
		case 15:
			return 3;
		case 31:
			return 4;
		case 63:
			if (z >= 0)
				return 8 + (z % 8);
			else
				return 16;
		default:
			return -1;
		}
	}
}
