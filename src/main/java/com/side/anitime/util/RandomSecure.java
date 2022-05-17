package com.side.anitime.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomSecure {
    private final String randomEng = "abcdefghijklmnopqrstuvwxyz";
    private final String randomNum = "0123456789";
    private final String mixRandom = randomEng + randomNum;

    private final int initLength = 10;

    private static SecureRandom random = new SecureRandom();

    public String initGenerate(){
        if (initLength < 1) throw new IllegalArgumentException("length must be a positive number.");
        StringBuilder sb = new StringBuilder(initLength);
        for (int i = 0; i < initLength; i++) {
            sb.append(mixRandom.charAt(random.nextInt(mixRandom.length())));
        }
        return sb.toString();
    }

    public String userGenerate(){
        String tmpString = initGenerate().toString();
        return "ani" + tmpString + "time";
    }
}

