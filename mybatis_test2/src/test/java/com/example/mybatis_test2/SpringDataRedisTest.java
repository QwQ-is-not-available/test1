package com.example.mybatis_test2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringDataRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate(){
        System.out.println(redisTemplate);
        //操作字符串的
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //操作哈希的
        HashOperations hashOperations = redisTemplate.opsForHash();
        //操作列表的
        ListOperations listOperations = redisTemplate.opsForList();
        //操作set的
        SetOperations setOperations = redisTemplate.opsForSet();
        //操作zset的
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
    }

    @Test
    public void testString(){
        redisTemplate.opsForValue().set("city","beijing");
        String city = (String) redisTemplate.opsForValue().get("city");
        System.out.println(city);
        //setex
        redisTemplate.opsForValue().set("code","1234",3, TimeUnit.MINUTES);
        //setnx
        redisTemplate.opsForValue().setIfAbsent("lock1","1");
        redisTemplate.opsForValue().setIfAbsent("lock1","2");
    }

    @Test
    public void testhash(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        //hset
        hashOperations.put("hashkey1","name","wdnmd");
        hashOperations.put("hashkey1","age","35");
        //hget
        String name = (String) hashOperations.get("hashkey1", "name");
        System.out.println(name);
        //hkeys
        Set keys = hashOperations.keys("hashkey1");
        System.out.println(keys);
        //hvals
        List values = hashOperations.values("hashkey1");
        System.out.println(values);
        //hdel
        hashOperations.delete("hashkey1","age");
    }


}
