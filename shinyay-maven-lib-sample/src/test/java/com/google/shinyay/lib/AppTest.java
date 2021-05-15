package com.google.shinyay.lib;


import com.google.shinyay.lib.service.ShinyaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("shinyay.message=Hello")
public class AppTest 
{
    @Autowired
    private ShinyaService shinyaService;

    @Test
    public void contextLoads() {
        Assertions.assertThat(shinyaService.message()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration{}
}
