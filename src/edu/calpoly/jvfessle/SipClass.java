package edu.calpoly.jvfessle;

public final class SipClass {
	// COGNITIVE COMPLEXITY: 1
	// CYCLOMATIC COMPLEXITY: 2
	@SuppressWarnings("unused")
	private static void sipRound(int iterations) {
		for (int i = 0; i < iterations; i++) {
			HelperClass.v0 += HelperClass.v1;
			HelperClass.v2 += HelperClass.v3;
			HelperClass.v1 = Long.rotateLeft(HelperClass.v1, 13);
			HelperClass.v3 = Long.rotateLeft(HelperClass.v3, 16);
			HelperClass.v1 ^= HelperClass.v0;
			HelperClass.v3 ^= HelperClass.v2;
			HelperClass.v0 = Long.rotateLeft(HelperClass.v0, 32);
			HelperClass.v2 += HelperClass.v1;
			HelperClass.v0 += HelperClass.v3;
			HelperClass.v1 = Long.rotateLeft(HelperClass.v1, 17);
			HelperClass.v3 = Long.rotateLeft(HelperClass.v3, 21);
			HelperClass.v1 ^= HelperClass.v2;
			HelperClass.v3 ^= HelperClass.v0;
			HelperClass.v2 = Long.rotateLeft(HelperClass.v2, 32);
		}
	}
}
