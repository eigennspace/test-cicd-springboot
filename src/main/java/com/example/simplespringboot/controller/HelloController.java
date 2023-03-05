package com.example.simplespringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "Hello World CI/CD";
    }

    @GetMapping("/hello/{name}")
    public String helloParameterize(@PathVariable("name") String name){
        log.info("Changing");
        log.info("Say hello to {}", name);
        return "Hello " + name + " how are you";
    }
}