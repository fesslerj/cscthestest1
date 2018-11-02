package edu.calpoly.jvfessle;

public final class SipClass {
	// COG=1
	// CYC=2
	@SuppressWarnings("unused")
	private static void sipRound(int iterations) {
		for (int i = 0; i < iterations; i++) {
			DoubleMathHelper.v0 += DoubleMathHelper.v1;
			DoubleMathHelper.v2 += DoubleMathHelper.v3;
			DoubleMathHelper.v1 = Long.rotateLeft(DoubleMathHelper.v1, 13);
			DoubleMathHelper.v3 = Long.rotateLeft(DoubleMathHelper.v3, 16);
			DoubleMathHelper.v1 ^= DoubleMathHelper.v0;
			DoubleMathHelper.v3 ^= DoubleMathHelper.v2;
			DoubleMathHelper.v0 = Long.rotateLeft(DoubleMathHelper.v0, 32);
			DoubleMathHelper.v2 += DoubleMathHelper.v1;
			DoubleMathHelper.v0 += DoubleMathHelper.v3;
			DoubleMathHelper.v1 = Long.rotateLeft(DoubleMathHelper.v1, 17);
			DoubleMathHelper.v3 = Long.rotateLeft(DoubleMathHelper.v3, 21);
			DoubleMathHelper.v1 ^= DoubleMathHelper.v2;
			DoubleMathHelper.v3 ^= DoubleMathHelper.v0;
			DoubleMathHelper.v2 = Long.rotateLeft(DoubleMathHelper.v2, 32);
		}
	}
}
