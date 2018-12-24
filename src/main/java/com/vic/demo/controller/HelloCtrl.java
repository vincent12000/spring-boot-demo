package com.vic.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCtrl {

    @GetMapping("/")
    public String index() {
        return "hello";
    }
}
