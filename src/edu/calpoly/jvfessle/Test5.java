package edu.calpoly.jvfessle;

public final class Test5 {
	// COGNITIVE COMPLEXITY: 6
	// CYCLOMATIC COMPLEXITY: 6
	public static double getFraction(int x, int y, int z) {
		int a = 0;
		
		if (x > y)
			a = 4;
		else if (x == y && x > z)
			a = 5;
		else if (x == y && x == z)
			a = 6;
		else
			a = 10;

		
		return 1.0 / a;
	}
}
