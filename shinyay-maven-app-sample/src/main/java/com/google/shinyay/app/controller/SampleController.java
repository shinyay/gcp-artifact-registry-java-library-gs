package com.google.shinyay.app.controller;

import com.google.shinyay.lib.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private final SampleService service;

    public SampleController(SampleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String homeMessage() {
        return service.message();
    }
}
