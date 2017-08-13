package com.bok.ip;


import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.regex.Pattern;

public class IPValidationRegexTest {

    public static final String[] test0_255= {
            "0",
            "255",
            "250",
            "205",
            "001",
            "010",
            "01",
            "10",
            "25",
            "9",
            "099",
            "99",
            "199",
            "009",
            "99",
    };

    public static final String[] test0_255_fail= {
            "-0",
            "256",
            "0001",
            "257",
            "300",
            "10.",
            "10.0",
            "260",
            "999",
            "0000",
            ""
    };
    public static final String[] testIpAddsPass = {
            "255.255.255.255", //upper limit
            "0.0.0.0",  //lower limit
            "000.000.000.000",  //lower limit
            "199.0.0.1",
            "0.0.0.255",
            "0.0.255.0",
            "0.255.0.0",
            "255.0.0.0",
            "1.2.3.4",
            "001.002.003.004",
            "01.02.03.04",
            "5.5.6.6",
            "99.99.99.99",
            "000.000.056.056"
    };

    public static final String[] testIpAddsFail= {
            "127.1",
            "192.168.1.256",
            "-1.2.3.4",
            "3...3",
            "255.255.255.0255",
            "255.255.0255.255",
            "255.255..255",
            "256.255.0.255",
            "256.001.056.056"
    };

    @Test
    public void testIpAddressesValid() {
        IPValidationRegex ipValidator = new IPValidationRegex();
        for (String ip : testIpAddsPass) {
            assertTrue(ipValidator.isMatch(ip));
        }
    }

    @Test
    public void testIpAddressesInvalid() {
        IPValidationRegex ipValidator = new IPValidationRegex();
        for (String ip : testIpAddsFail) {
            assertFalse(ipValidator.isMatch(ip));
        }
    }


    @Test
    public void testIpAddressesSegmentValid() {
        IPValidationRegex ipValidator = new IPValidationRegex();
        String regEx = ipValidator.getRegExPerNumber();
        for (String ipSegment : test0_255) {
            assertTrue(Pattern.matches(regEx, ipSegment));
        }
    }

    @Test
    public void testIpAddressesSegmentInvalid() {
        IPValidationRegex ipValidator = new IPValidationRegex();
        String regEx = ipValidator.getRegExPerNumber();
        for (String ipSegment : test0_255_fail) {
            assertFalse(Pattern.matches(regEx, ipSegment));
        }
    }


}