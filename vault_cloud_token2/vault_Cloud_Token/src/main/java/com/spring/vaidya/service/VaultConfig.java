package com.spring.vaidya.service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "")
public class VaultConfig {
    private String Jwt;

    public String getJwt() {
        return Jwt;
    }

    public void setJwt(String jwt) {
        this.Jwt = jwt;
    }
}
