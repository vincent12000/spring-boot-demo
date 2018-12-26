package com.vic.demo.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Configuration
//@EnableConfigurationProperties(JwtProperties.class)
@Component
public class JwtProperty {

//    @Autowired
//    private JwtProperties jwtProperties;

    public static String header;
    public static String secret;
    public static String expiration;
    public static String tokenHead;

//    @PostConstruct
//    public void initConstants() {
//        JwtProperty.header = jwtProperties.getHeader();
//        JwtProperty.secret = jwtProperties.getSecret();
//        JwtProperty.expiration = jwtProperties.getExpiration();
//        JwtProperty.tokenHead = jwtProperties.getTokenHead();
//    }

    @Value("${jwt.header}")
    public void setHeader(String header) {
        this.header = header;
    }

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Value("${jwt.expiration}")
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Value("${jwt.tokenHead}")
    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }
}