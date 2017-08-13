package com.bok.ip;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class IPValidationRegex {

    private String regEx = null;

    private static final String SEGMENT_REGEX = "([01]?[0-9][0-9]?|25[0-5]|2[0-4][0-9])"; //final regex per segment
    public static final String DEFAULT_FILE = "ipList.txt";

    //for testing segments
    public String getRegExPerNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("[01]?[0-9][0-9]?");
        sb.append("|");
        sb.append("25[0-5]"); //250-255
        sb.append("|");
        sb.append("2[0-4][0-9]"); //200-249
        sb.append(")");
        return sb.toString();
    }

    public String getRegEx() {
        if (regEx == null) {
            //String regExPerSegment = getRegExPerNumber();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(SEGMENT_REGEX);
                sb.append("\\.");
            }
            sb.append(SEGMENT_REGEX);

            regEx = sb.toString();
        }
        return regEx;
    }

    public boolean isMatch(String ipAddress) {
        return Pattern.matches(getRegEx(), ipAddress);
    }

    public static void main (String[] a) {

    }
}
