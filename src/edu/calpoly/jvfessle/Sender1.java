package edu.calpoly.jvfessle;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class Sender1 {
	public static void send() { // 7,4
		
        String timestamp = String.valueOf(System.currentTimeMillis());
        for (Map.Entry<Statistics, AtomicReference<long[]>> entry : 
Statistics.statisticsMap.entrySet()) {
            // get statistics data
            Statistics statistics = entry.getKey();
            AtomicReference<long[]> reference = entry.getValue();
            long[] numbers = reference.get();
            long success = numbers[0];
            long failure = numbers[1];
            long input = numbers[2];
            long output = numbers[3];
            long elapsed = numbers[4];
            long concurrent = numbers[5];
            long maxInput = numbers[6];
            long maxOutput = numbers[7];
            long maxElapsed = numbers[8];
            long maxConcurrent = numbers[9];
            String version = HelperClass.getUrl().getParameter(HelperClass.DEFAULT_PROTOCOL);

            // send statistics data
            URL url = statistics.getUrl()
                    .addParameters(HelperClass.TIMESTAMP, timestamp,
                    		HelperClass.SUCCESS, String.valueOf(success),
                    		HelperClass.FAILURE, String.valueOf(failure),
                    		HelperClass.INPUT, String.valueOf(input),
                    		HelperClass.OUTPUT, String.valueOf(output),
                    		HelperClass.ELAPSED, String.valueOf(elapsed),
                    		HelperClass.CONCURRENT, String.valueOf(concurrent),
                    		HelperClass.MAX_INPUT, String.valueOf(maxInput),
                    		HelperClass.MAX_OUTPUT, String.valueOf(maxOutput),
                    		HelperClass.MAX_ELAPSED, String.valueOf(maxElapsed),
                    		HelperClass.MAX_CONCURRENT, 
String.valueOf(maxConcurrent),
HelperClass.DEFAULT_PROTOCOL, version
                    );
            HelperClass.collect(url);

            // reset
            long[] current;
            long[] update = new long[HelperClass.LENGTH];
            do {
                current = reference.get();
                if (current == null) {
                    update[0] = 0;
                    update[1] = 0;
                    update[2] = 0;
                    update[3] = 0;
                    update[4] = 0;
                    update[5] = 0;
                } else {
                    update[0] = current[0] - success;
                    update[1] = current[1] - failure;
                    update[2] = current[2] - input;
                    update[3] = current[3] - output;
                    update[4] = current[4] - elapsed;
                    update[5] = current[5] - concurrent;
                }
            } while (!reference.compareAndSet(current, update));
        }
}

}
