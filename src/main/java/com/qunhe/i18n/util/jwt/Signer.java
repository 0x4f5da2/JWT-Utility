package com.qunhe.i18n.util.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.codec.binary.Base64;
import java.nio.charset.StandardCharsets;

/**
 * The JWTCreator class holds the sign method to generate a complete JWT (with Signature) from a given Header and Payload content.
 */
@SuppressWarnings("WeakerAccess")
public final class Signer {
    public static String sign(String headerJson, String payloadJson, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String header = Base64.encodeBase64URLSafeString(headerJson.getBytes(StandardCharsets.UTF_8));
            String payload = Base64.encodeBase64URLSafeString(payloadJson.getBytes(StandardCharsets.UTF_8));
            String content = String.format("%s.%s", header, payload);

            byte[] signatureBytes = algorithm.sign(content.getBytes(StandardCharsets.UTF_8));
            String signature = Base64.encodeBase64URLSafeString((signatureBytes));

            return String.format("%s.%s", content, signature);
        } catch (Exception e) {
            return null;
        }
    }
}
