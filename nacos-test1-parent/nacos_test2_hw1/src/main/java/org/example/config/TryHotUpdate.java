package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "test2.test")
public class TryHotUpdate {
    //用来配合热更新,这个是配置文件里没有的
    private String aSentence;
}
