package org.example;

import org.example.config.DefaultFeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(defaultConfiguration = DefaultFeignConfig.class)
@SpringBootApplication
public class NacosTest2Hw1Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosTest2Hw1Application.class, args);
    }

}
