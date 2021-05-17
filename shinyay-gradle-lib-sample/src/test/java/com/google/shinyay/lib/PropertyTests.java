package com.google.shinyay.lib;

import com.google.shinyay.lib.service.SampleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(value = "sample.message=Hello")
class PropertyTests {

	@Autowired
	private SampleService service;

	@Test
	void contextLoads() {
		Assertions.assertThat(service.message()).isNotNull();
	}

	@SpringBootApplication
	static class TestProperty{}

}
