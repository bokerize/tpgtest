package com.bok.student;


import org.junit.*;
import static org.junit.Assert.fail;
import com.bok.timing.TimingUtil;

public class TimingUtilTest {

    public String dummyMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done";
    }

    public void dummyMethodVoid() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testTiming1() {

        try {
            TimingUtil.measureDuration(
                    new Runnable() {
                        public void run()  {
                            dummyMethod();
                        }
                    });
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testTimingLambda() {
        try {
            TimingUtil.measureDuration(() -> String.format("format This %s %s %s", "1", 2, new Double(2.0)) );
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testTimingLambdaVoid() {
        try {
            TimingUtil.measureDuration(() -> dummyMethodVoid()  );
        } catch (Exception e) {
            fail();
        }
    }

}
