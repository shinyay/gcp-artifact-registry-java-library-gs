package com.google.shinyay.lib.service;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ShinyaServiceProperties.class)
public class ShinyaService {
}
