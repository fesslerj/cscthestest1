package edu.calpoly.jvfessle;

import java.math.RoundingMode;

public class Switch3 {
	// COGNITIVE COMPLEXITY: 4
	// CYCLOMATIC COMPLEXITY: 8
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
			if (z >= 0)
				return 4 + (z % 4);
			else
				return 8;
		default:
			return -1;
		}
	}
}
