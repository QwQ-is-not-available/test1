package com.example.controller;

import com.example.pojo.Address;
import com.example.pojo.Result;
import com.example.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        System.out.println("test for dev-end");  //this from master

        return "hello world";
    }

    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="mingzi", required = false) String username, Integer age){
        System.out.println(username+":"+age);  //change something in master-old
        //change sonething in master
        return "OK";
    }

    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/arrayPojo")
    public String arrayPojo(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }

    @RequestMapping("/dataParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime updateTime){
        System.out.println(updateTime);
        LocalDateTime updateTime1 = LocalDateTime.now();
        System.out.println(updateTime1);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam1(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }

    @RequestMapping("/getAddr")
    public Address getAddr(){
        Address addr = new Address();
        addr.setProvince("设置的省份");
        addr.setCity("设置的城市");
        return addr;
    }

    @RequestMapping("/getAddr1") //用result对象统一返回
    public Result getAddr1(){
        Address addr = new Address();
        addr.setProvince("设置的省份");
        addr.setCity("设置的城市");
        return Result.success(addr);
    }

    @RequestMapping("/getListAddr")
    public List<Address> getListAddr(){
        List<Address> list = new ArrayList<Address>();
        Address addr1 = new Address();
        addr1.setProvince("设置的省份1");
        addr1.setCity("设置的城市1");

        Address addr2 = new Address();
        addr2.setProvince("设置的省份2");
        addr2.setCity("设置的城市2");

        list.add(addr1);
        list.add(addr2);
        return list;
    }

    @RequestMapping("/getListAddr1")  //用result对象统一返回
    public Result getListAddr1(){
        List<Address> list = new ArrayList<>();
        Address addr1 = new Address();
        addr1.setProvince("设置的省份1");
        addr1.setCity("设置的城市1");

        Address addr2 = new Address();
        addr2.setProvince("设置的省份2");
        addr2.setCity("设置的城市2");

        list.add(addr1);
        list.add(addr2);
        return Result.success(list);
    }



}
