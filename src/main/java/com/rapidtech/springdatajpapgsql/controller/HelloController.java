package com.rapidtech.springdatajpapgsql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hellospring")
    public String helloSpring(){
        return "Hello Spring Boot Framework !";
    }
}