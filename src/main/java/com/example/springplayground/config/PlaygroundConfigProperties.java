package com.example.springplayground.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("playground")
@ConstructorBinding
public class PlaygroundConfigProperties {
    private final String secretId;
    private final String secretPassword;

    public PlaygroundConfigProperties(String secretId, String secretPassword) {
        this.secretId = secretId;
        this.secretPassword = secretPassword;
    }

    public String getSecretId() {
        return secretId;
    }

    public String getSecretPassword() {
        return secretPassword;
    }
}
