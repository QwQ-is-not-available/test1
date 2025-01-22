package com.example.controller;

import com.example.testfeign.Hw2Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/hw1")
public class HelloController {

    @Autowired
    private Hw2Client hw2client;

    @RequestMapping("/hello1")
    public String hello() {
        log.info("Hello World 1 in hw1");
        return "Hello World 1 in hw1";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        log.info("Hello World 2 in hw1");
        String result = hw2client.getHello1FromHw2();
        log.info("get msg by openfeign: "+result);
        return "Hello World 2 in hw1 "+result;
    }
}
