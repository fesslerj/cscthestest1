package edu.calpoly.jvfessle;

import java.math.RoundingMode;

public class Switch3 {
	public static int blah2(int y, int z) {//4,8
		switch(y) {
		case 0:
			return -7;
		case 1:
			return 42;
		case 3:
		case 6:
			return -y*y;
		case 7:
			return (int)DoubleMathHelper.divide(y, 1, RoundingMode.HALF_DOWN);
		case 15:
			if (z >= 0)
				return (int)(1000*Math.cos(Math.toRadians(z / 1000.0)));
			else
				return 0;
		default:
			return y;
		}
	}
}
