package com.example.springboot_threadlocal.controller;

import com.example.springboot_threadlocal.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        CurrentHolder.setCurrent(CurrentHolder.getCurrent()+" from hello");
        log.info("Hello World : "+ CurrentHolder.getCurrent());
        return "Hello World";
    }
}
