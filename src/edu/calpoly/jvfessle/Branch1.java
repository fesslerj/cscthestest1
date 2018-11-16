package edu.calpoly.jvfessle;

import java.math.RoundingMode;

public final class Branch1 {
	// COGNITIVE COMPLEXITY: 12
	// CYCLOMATIC COMPLEXITY: 5
	public static int addMD(int x) {
		if ((x & 1) > 0) {
			if ((x & 2) > 0) {
				return x + 5;
			} else {
				return x + (x * x) + 13;
			}
		} else {
			if ((x & 2) > 0) {
				if ((x & 4) > 0) {
					return x + (int)HelperClass.divide(x,  1, RoundingMode.DOWN);
				} else {
					return x - (int)HelperClass.divide(x,  1, RoundingMode.DOWN);
				}
			} else {
				return x * x - (x - 1);
			}
		}
	}
}
