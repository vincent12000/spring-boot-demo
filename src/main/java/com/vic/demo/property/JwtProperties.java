package com.vic.demo.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
public class JwtProperties {

    private String header;
    private String secret;
    private String expiration;
    private String tokenHead;
}
