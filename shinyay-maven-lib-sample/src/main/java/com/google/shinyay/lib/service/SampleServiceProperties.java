package com.google.shinyay.lib.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("sample")
public class SampleServiceProperties {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
