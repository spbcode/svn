package com.spring.springBootHandsOn.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @RequestMapping("/hi")
    public String test(){
        return "hello ";
    }
}
