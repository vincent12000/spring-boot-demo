package com.vic.demo.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "jwt")
@Getter
@Setter
@Component
public class JwtProperties {

    private String header;
    private String secret;
    private String expiration;
    private String tokenHead;
}
