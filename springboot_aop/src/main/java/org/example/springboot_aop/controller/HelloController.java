package org.example.springboot_aop.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot_aop.anno.AnnoTest1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @AnnoTest1
    @RequestMapping("/hello")
    public String hello() {
        log.info("Hello World");
        return "Hello World";
    }

}
