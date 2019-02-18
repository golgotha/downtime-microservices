package com.comncon.downtime.ticketing.accept;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public static MessageDigest getMd5() {
        try {
            final MessageDigest crypt = MessageDigest.getInstance("md5");
            crypt.reset();
            return crypt;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error initialization of md5", e);
        }
    }

    public static String toHex(final byte[] bytes) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            final String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
