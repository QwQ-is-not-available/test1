package org.example.controller;

import com.alibaba.nacos.common.utils.ThreadUtils;
import lombok.extern.slf4j.Slf4j;
import org.example.config.TryHotUpdate;
import org.example.testfeign.Hw2Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/hw1")
public class HelloController {

    @Autowired
    private Hw2Client hw2Client;

    @Autowired
    private TryHotUpdate tryHotUpdate;

    @RequestMapping("/hello1")
    public String hello1() {
        log.info("Hello World 1 in hw1");
//        ThreadUtils.sleep(500);
        return "Hello World 1 in hw1";
    }

    @RequestMapping("/hello2")
    public String hello2() {
        //测试openfeign
        log.info("Hello World 2 in hw1");

        String result = hw2Client.getHello1FromHw2();
        log.info("get msg by openfeign: "+result);

        return "Hello World 2 in hw1 "+result;
    }

    @RequestMapping("/hello3")
    public String hello3() {
        //测试nacos配置热更新
        log.info("Hello World 3 in hw1");
        log.info("try to get from nacos: "+tryHotUpdate.getASentence());

        return "Hello World 3 in hw1";
    }
}
