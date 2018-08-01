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
        String ret = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Yaml yaml = new Yaml();
            JWTCreator.Builder builder = JWT.create();
            Map yamlMap = yaml.load(yamlString);
            builder.with
            ret = builder.withHeader(yamlMap).sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static void testYaml(String yamlString) {
        System.out.println(yamlString);
        Yaml yaml = new Yaml();
        Map res = yaml.load(yamlString);
        for(Object each:res.keySet()){
            String k = (String)each;
            System.out.println(k);
            Object val = res.get(each);
            if(null != val) {
                System.out.println(val.getClass());
                val.toString();
            } else {
                System.out.println("null");
            }
        }
    }
}
