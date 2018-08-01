package com.qunhe.i18n.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Base64;
import java.util.regex.Pattern;

public class VerificationUtil {
    private static final String tokenRegex = "^[a-zA-Z0-9+/]+\\.[a-zA-Z0-9+/]+\\.[a-zA-Z0-9+/_\\-]+$";

    public static String getPayload(String string) {
        String result = null;
        if (check(string)) {
            String payload = string.split("\\.")[1];
            result = decodeBese64(payload);
        }
        return result;
    }

    public static boolean check(String token) {
        return Pattern.matches(tokenRegex, token);
    }

    public static boolean verify(String token, String secret) {
        boolean verified = false;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            verified = true;
        } catch (Exception e) {

        }
        return verified;
    }

    public static String decodeBese64(String string) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(string));
    }
}
