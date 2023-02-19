package com.example.httpbasicauth.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/***
 * This class used to generate BCryptPassword for HTTP Basic Authentication.
 * After run this class we copy the encode password and put it in websecurityconfigclass
 */
public class GenarateSecurePassword {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encodePassword = bCryptPasswordEncoder.encode("admin");
        String encodePassword = bCryptPasswordEncoder.encode("user");

        System.out.println(encodePassword);
    }
}
