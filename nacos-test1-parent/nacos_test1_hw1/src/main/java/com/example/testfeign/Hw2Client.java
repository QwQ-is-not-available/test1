package com.example.testfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "nacos-test1-hw2")
public interface Hw2Client {
    @GetMapping("/hello1")
    String getHello1FromHw2();
}
