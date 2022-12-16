/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lyngo.amondscoffeehouse.utils;

import java.security.MessageDigest;

public class EncryptionUtils {

    private static final String algorithm = "MD5";
    public static String encrypt(String txt){
        String result = "";
        try {
            byte[] bytes = txt.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(bytes);
            byte[] hashedBytes = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hashedBytes.length; ++i) {
                sb.append(Integer.toHexString((hashedBytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            result = sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
