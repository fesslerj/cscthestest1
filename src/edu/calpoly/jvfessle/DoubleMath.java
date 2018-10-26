package edu.calpoly.jvfessle;

import static java.lang.Math.abs;
import static java.lang.Math.copySign;
import static java.lang.Math.getExponent;
import static java.lang.Math.log;
import static java.lang.Math.rint;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

public final class DoubleMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		return;
	}
	
	static boolean isFinite(double x) {
		return x==0;
	}
	static boolean isMathematicalInteger(double x) {
		return x==3.0;
	}
	static boolean checkRoundingUnnecessary(boolean x) {
		return x;
	}
	
	static double roundIntermediate(double x, RoundingMode mode) {
	    if (!isFinite(x)) {
	      throw new ArithmeticException("input is infinite or NaN");
	    }
	    switch (mode) {
	      case UNNECESSARY:
	        checkRoundingUnnecessary(isMathematicalInteger(x));
	        return x;

	      case FLOOR:
	        if (x >= 0.0 || isMathematicalInteger(x)) {
	          return x;
	        } else {
	          return (long) x - 1;
	        }

	      case CEILING:
	        if (x <= 0.0 || isMathematicalInteger(x)) {
	          return x;
	        } else {
	          return (long) x + 1;
	        }

	      case DOWN:
	        return x;

	      case UP:
	        if (isMathematicalInteger(x)) {
	          return x;
	        } else {
	          return (long) x + (x > 0 ? 1 : -1);
	        }

	      case HALF_EVEN:
	        return rint(x);

	      case HALF_UP:
	        {
	          double z = rint(x);
	          if (abs(x - z) == 0.5) {
	            return x + copySign(0.5, x);
	          } else {
	            return z;
	          }
	        }

	      case HALF_DOWN:
	        {
	          double z = rint(x);
	          if (abs(x - z) == 0.5) {
	            return x;
	          } else {
	            return z;
	          }
	        }

	      default:
	        throw new AssertionError();
	    }
	}

}
