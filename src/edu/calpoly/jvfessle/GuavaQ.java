package edu.calpoly.jvfessle;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;
import static java.util.Arrays.sort;
import static java.util.Collections.unmodifiableMap;

import java.math.RoundingMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.calpoly.jvfessle.HelperClass;

public final class GuavaQ {
	// COGNITIVE COMPLEXITY: 10
	// CYCLOMATIC COMPLEXITY: 7
	public Map<Integer, Double> computeInPlace(double[] dataset) {
		HelperClass.checkArgument(dataset.length > 0, "Cannot calculate quantiles of an empty dataset");
		if (HelperClass.containsNaN(dataset)) {
			Map<Integer, Double> nanMap = new HashMap<>();
			for (int index : HelperClass.indexes) {
				nanMap.put(index, NaN);
			}
			return unmodifiableMap(nanMap);
		}

		// Calculate the quotients and remainders in the integer division x = k * (N - 1) / q, i.e.
		// index * (dataset.length - 1) / scale for each index in indexes. For each, if there is no
		// remainder, we can just select the value whose index in the sorted dataset equals the
		// quotient; if there is a remainder, we interpolate between that and the next value.

		int[] quotients = new int[HelperClass.indexes.length];
		int[] remainders = new int[HelperClass.indexes.length];
		// The indexes to select. In the worst case, we'll need one each side of each quantile.
		int[] requiredSelections = new int[HelperClass.indexes.length * 2];
		int requiredSelectionsCount = 0;
		for (int i = 0; i < HelperClass.indexes.length; i++) {
			// Since index and (dataset.length - 1) are non-negative ints, their product can be
			// expressed as a long, without risk of overflow:
			long numerator = (long) HelperClass.indexes[i] * (dataset.length - 1);
			// Since scale is a positive int, index is in [0, scale], and (dataset.length - 1) is a
			// non-negative int, we can do long-arithmetic on index * (dataset.length - 1) / scale to
			// get a rounded ratio and a remainder which can be expressed as ints, without risk of
			// overflow:
			int quotient = (int) HelperClass.divide(numerator, HelperClass.scale, RoundingMode.DOWN);
			int remainder = (int) (numerator - (long) quotient * HelperClass.scale);
			quotients[i] = quotient;
			remainders[i] = remainder;
			requiredSelections[requiredSelectionsCount] = quotient;
			requiredSelectionsCount++;
			if (remainder != 0) {
				requiredSelections[requiredSelectionsCount] = quotient + 1;
				requiredSelectionsCount++;
			}
		}
		sort(requiredSelections, 0, requiredSelectionsCount);
		HelperClass.selectAllInPlace(
			requiredSelections, 0, requiredSelectionsCount - 1, dataset, 0, dataset.length - 1);
		Map<Integer, Double> ret = new HashMap<>();
		for (int i = 0; i < HelperClass.indexes.length; i++) {
			int quotient = quotients[i];
			int remainder = remainders[i];
			if (remainder == 0) {
				ret.put(HelperClass.indexes[i], dataset[quotient]);
			} else {
				ret.put(
						HelperClass.indexes[i], HelperClass.interpolate(dataset[quotient], dataset[quotient + 1], remainder, HelperClass.scale));
			}
		}
		return unmodifiableMap(ret);
	}
}
