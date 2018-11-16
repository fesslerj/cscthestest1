package edu.calpoly.jvfessle;

public final class For1 {
	// COGNITIVE COMPLEXITY: 6
	// CYCLOMATIC COMPLEXITY: 7
	public static int offsetDiff(int[] x, int[] y, int z) {
		int q = 0,
			c = 0;
		
		int lx = x.length,
			ly = y.length;
		int l = Math.min(lx,  ly);
		
		for (int i=0;i<l;i++) {
			q += 2; 
			c += x[i] - y[i];
		}
		
		for (int i=0;i<lx;i++) {
			x[i] += z;
		}
		
		for (int i=0;i<l;i++) {
			q += 2; 
			c += x[i] - y[i];
		}
		
		for (int i=0;i<lx;i++) {
			x[i] += 2*z;
		}
		
		for (int i=0;i<l;i++) {
			q += 2; 
			c += x[i] - y[i];
		}
		
		for (int i=0;i<lx;i++) {
			c += x[i];
		}
		
		return c - q;
	}
}
