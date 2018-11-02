package edu.calpoly.jvfessle;

public final class Switch1 {
	public static void verifyStandardSetting(int key, Long value) {//18,18
		DoubleMathHelper.checkNotNull(value, "value");
	    switch (key) {
	        case DoubleMathHelper.SETTINGS_HEADER_TABLE_SIZE:
	            if (value < DoubleMathHelper.MIN_HEADER_TABLE_SIZE
	|| value > DoubleMathHelper.MAX_HEADER_TABLE_SIZE) {
	                throw new IllegalArgumentException(
	"Setting HEADER_TABLE_SIZE is invalid: "
	                        + value);
	            }
	            break;
	        case DoubleMathHelper.SETTINGS_ENABLE_PUSH:
	            if (value != 0L && value != 1L) {
	                throw new IllegalArgumentException(
	"Setting ENABLE_PUSH is invalid: "
	                        + value);
	            }
	            break;
	        case DoubleMathHelper.SETTINGS_MAX_CONCURRENT_STREAMS:
	            if (value < DoubleMathHelper.MIN_CONCURRENT_STREAMS
	|| value > DoubleMathHelper.MAX_CONCURRENT_STREAMS) {
	                throw new IllegalArgumentException(
	                    "Setting MAX_CONCURRENT_STREAMS is invalid: "
	+ value);
	            }
	            break;
	        case DoubleMathHelper.SETTINGS_INITIAL_WINDOW_SIZE:
	            if (value < DoubleMathHelper.MIN_INITIAL_WINDOW_SIZE
	|| value > DoubleMathHelper.MAX_INITIAL_WINDOW_SIZE) {
	                throw new IllegalArgumentException(
	"Setting INITIAL_WINDOW_SIZE is invalid: "
	                        + value);
	            }
	            break;
	        case DoubleMathHelper.SETTINGS_MAX_FRAME_SIZE:
	            if (!DoubleMathHelper.isMaxFrameSizeValid(value.intValue())) {
	                throw new IllegalArgumentException(
	"Setting MAX_FRAME_SIZE is invalid: "
	                        + value);
	            }
	            break;
	        case DoubleMathHelper.SETTINGS_MAX_HEADER_LIST_SIZE:
	            if (value < DoubleMathHelper.MIN_HEADER_LIST_SIZE
	|| value > DoubleMathHelper.MAX_HEADER_LIST_SIZE) {
	                throw new IllegalArgumentException(
	"Setting MAX_HEADER_LIST_SIZE is invalid: "
	                        + value);
	            }
	            break;
	        default:
	            // Non-standard HTTP/2 setting - don't do validation.
	            break;
	    }
	}

}
