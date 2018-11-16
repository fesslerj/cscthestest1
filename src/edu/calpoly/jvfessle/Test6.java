package edu.calpoly.jvfessle;

public final class Test6 {
	// COGNITIVE COMPLEXITY: 6
	// CYCLOMATIC COMPLEXITY: 9
	public static int getRegion(double x) {
		double z = Math.cos(x);
		double y = Math.sin(x);
		
		if (z >= 0 && y >= 0 && z+y <= 1)
			return 1;
		
		z = 2*Math.abs(z);
		y = 2*Math.abs(y);
		
		if (z >= 0 && y >= 0 && z+y <= 1)
			return 2;
		
		if (z*y <= 3)
			return 3;
		
		if (z*z*y < 7)
			return 4;
		
		return 0;
	}
}
