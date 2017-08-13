package com.bok.timing;

import java.time.*;
import java.util.concurrent.*;

public class TimingUtil {

    public static void measureDuration(Runnable anyMethod) {

        try {
            Instant start = Instant.now();
            anyMethod.run();
            Instant end = Instant.now();

            System.out.println("duration >>> " + Duration.between(start, end));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}