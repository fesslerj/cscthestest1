package edu.calpoly.jvfessle;

public final class Switch2 {
	// COGNITIVE COMPLEXITY: 1
	// CYCLOMATIC COMPLEXITY: 7
	public static String keyToString(char key) {
	    switch (key) {
	        case HelperClass.SETTINGS_HEADER_TABLE_SIZE:
	            return "HEADER_TABLE_SIZE";
	        case HelperClass.SETTINGS_ENABLE_PUSH:
	            return "ENABLE_PUSH";
	        case HelperClass.SETTINGS_MAX_CONCURRENT_STREAMS:
	            return "MAX_CONCURRENT_STREAMS";
	        case HelperClass.SETTINGS_INITIAL_WINDOW_SIZE:
	            return "INITIAL_WINDOW_SIZE";
	        case HelperClass.SETTINGS_MAX_FRAME_SIZE:
	            return "MAX_FRAME_SIZE";
	        case HelperClass.SETTINGS_MAX_HEADER_LIST_SIZE:
	            return "MAX_HEADER_LIST_SIZE";
	        default:
	            // Unknown keys.
	            return HelperClass.keyToString(key);
	    }
	}

}
