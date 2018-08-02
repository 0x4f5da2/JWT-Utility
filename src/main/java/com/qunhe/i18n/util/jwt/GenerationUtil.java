package com.qunhe.i18n.util.jwt;

import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.yaml.snakeyaml.Yaml;

import javax.swing.text.StyledEditorKit;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
public class GenerationUtil {
    public static String generate(String yamlString, String secret){
        try{
            String header = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
            String payload = JSON.toJSONString(new Yaml().load(yamlString));
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return Signer.sign(header, payload, secret);
        } catch (Exception e) {
            return null;
        }
    }
}
