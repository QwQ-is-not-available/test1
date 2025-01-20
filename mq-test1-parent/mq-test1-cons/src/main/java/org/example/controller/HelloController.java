package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @RequestMapping("/hello1")
    public String hello() {
        log.info("Hello World 1 in cons");
        return "Hello World 1 in cons";
    }

}
