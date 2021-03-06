package com.google.shinyay.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.google.shinyay")
public class ShinyayMavenAppSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShinyayMavenAppSampleApplication.class, args);
	}

}
