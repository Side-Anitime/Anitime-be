package com.side.anitime.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomSecure {
    private final String randomEng = "abcdefghijklmnopqrstuvwxyz";
    private final String randomNum = "0123456789";
    private final String mixRandom = randomEng + randomNum;

    private final int length = 10;

    private static SecureRandom random = new SecureRandom();

    public String generate(){
        if (length < 1) throw new IllegalArgumentException("length must be a positive number.");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(mixRandom.charAt(random.nextInt(mixRandom.length())));
        }
        return sb.toString();
    }
}

