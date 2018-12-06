package edu.calpoly.jvfessle;

public class Branch2Edit {
	// COGNITIVE COMPLEXITY: 8
	// CYCLOMATIC COMPLEXITY: 9
	public static int compute(int x, int y) {
		int z = 2;
		
		if ((x & 1) > 0)
			z += y;
		else if ((x & 1024) > 0)
			z -= y;
		
		if ((x & 2) > 0)
			z -= y;
		
		if ((x & 4) > 0)
			z += z;
		else if ((x & 8) > 0)
			z = 0 - z;
		else if ((x & 16) > 0)
			z = 0 - (z << 1);
		else if ((x & 32) > 0)
			z = 0 - (z + z + z);
		else if ((x & 64) > 0)
			z = 0 - (z << 2);
		
		return z - 1;
	}
}
