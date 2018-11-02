package edu.calpoly.jvfessle;

public final class For1 {
	public static int blah4(int x, int y, int z) {//6,7
		int q = 0;
		
		for (int i=0;i<x-y;i++) {
			q += 2; 
			z = 1000;
		}
		
		for (int i=0;i<x-z;i++) {
			q += z/100;
		}
		
		for (int i=0;i<x-y;i++) {
			q += 2; 
			z = 1000;
		}
		
		for (int i=0;i<x-z;i++) {
			q += z/100;
		}
		
		for (int i=0;i<x-y;i++) {
			q += 2; 
			z = 1000;
		}
		
		for (int i=0;i<x-z;i++) {
			q += z/100;
		}
		
		return q;
	}
}
