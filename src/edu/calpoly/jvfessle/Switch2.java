package edu.calpoly.jvfessle;

public final class Switch2 {
	public static String keyToString(char key) {//1,7
	    switch (key) {
	        case DoubleMathHelper.SETTINGS_HEADER_TABLE_SIZE:
	            return "HEADER_TABLE_SIZE";
	        case DoubleMathHelper.SETTINGS_ENABLE_PUSH:
	            return "ENABLE_PUSH";
	        case DoubleMathHelper.SETTINGS_MAX_CONCURRENT_STREAMS:
	            return "MAX_CONCURRENT_STREAMS";
	        case DoubleMathHelper.SETTINGS_INITIAL_WINDOW_SIZE:
	            return "INITIAL_WINDOW_SIZE";
	        case DoubleMathHelper.SETTINGS_MAX_FRAME_SIZE:
	            return "MAX_FRAME_SIZE";
	        case DoubleMathHelper.SETTINGS_MAX_HEADER_LIST_SIZE:
	            return "MAX_HEADER_LIST_SIZE";
	        default:
	            // Unknown keys.
	            return DoubleMathHelper.keyToString(key);
	    }
	}

}
