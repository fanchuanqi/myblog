package com.example.demo.Util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author niwang
 * @Date 3/6
 */
public class JWTUtil {
    private static final long EFFECT_TIME = 8*60*60*1000;
    private static final String TOKEN_SECRET="29ce66c63dac44c6834a428828643b74";

    public static String sign(String username,String userId){
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EFFECT_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            Map<String,Object> header = new HashMap<String, Object>();
            header.put("type","JWT");
            header.put("alg","HS256");

            return JWT.create()
                    .withHeader(header)
                    .withClaim("loginName",username)
                    .withClaim("userId",userId)
                    .withExpiresAt(date)
                    .sign(algorithm);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
            return null;
        }

    }

    public static boolean verify(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT jwt = jwtVerifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
