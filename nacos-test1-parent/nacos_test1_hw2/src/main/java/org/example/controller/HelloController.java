package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hw2")
public class HelloController {
    @RequestMapping("/hello1")
    public String hello() {
        log.info("Hello World 1 in hw2");
        return "Hello World 1 in hw2";
    }
}
