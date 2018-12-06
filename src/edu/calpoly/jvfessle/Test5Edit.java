package edu.calpoly.jvfessle;

public class Test5Edit {
	// COGNITIVE COMPLEXITY: 6
	// CYCLOMATIC COMPLEXITY: 5
	public static double getFraction(int x, int y, int z) {
		int a = 0;
		int b = 0;
		
		if (x > y)
			a = 4;
		else
			a = 5;
		
		if (x == y)
			b = a;
		
		if (x == y && x == z)
			b += 6;
		else
			b += 10;

		
		return 1.0 / (a + b);
	}
}
