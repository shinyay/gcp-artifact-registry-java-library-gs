package com.google.shinyay.lib.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("shinyay")
public class ShinyaServiceProperties {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
