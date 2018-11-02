package edu.calpoly.jvfessle;

public final class Test5 { // 6,6
	public static double blah5(int x, int y, int z) {
		int a = 0;
		
		if (x > y)
			a = 100;
		else if (x == y && x > z)
			a = 75;
		else if (x == y && x == z)
			a = 67;
		else
			a = 50;

		
		return 1.0 / a;
	}
}
