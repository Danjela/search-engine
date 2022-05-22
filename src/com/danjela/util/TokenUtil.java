package com.danjela.util;

import java.util.regex.Pattern;

public class TokenUtil {

    public static boolean isAlphanumeric(String token) {
        return Pattern.matches("^[a-zA-Z0-9]+$", token);
    }
}
