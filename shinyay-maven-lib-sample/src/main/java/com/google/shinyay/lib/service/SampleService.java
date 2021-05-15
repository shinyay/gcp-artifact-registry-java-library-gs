package com.google.shinyay.lib.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(SampleServiceProperties.class)
public class SampleService {
}
