package com.epam.jdi.light.material.elements.utils;

import java.util.Random;

public class StringUtils {

    public static String generateRandomString() {
        final String symbols =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789$&@?<>~!%#";

        Random r = new Random();
        char[] password = new char[r.nextBoolean()?12:13];
        for(int i=0; i<password.length; i++) {
            char ch = symbols.charAt(r.nextInt(symbols.length()));
            password[i] = ch;
        }

        return new String(password);
    }
}
