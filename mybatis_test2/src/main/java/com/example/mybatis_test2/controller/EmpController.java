package com.example.mybatis_test2.controller;

import com.example.mybatis_test2.mapper.EmpMapper;
import com.example.mybatis_test2.pojo.Emp;
import com.example.mybatis_test2.pojo.Result;
import com.example.mybatis_test2.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpMapper empMapper;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        Emp emp1=empMapper.login(emp);
//        if(emp1!=null){
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("id",emp1.getId());
//            claims.put("name",emp1.getName());
//            claims.put("username",emp1.getUsername());
//
//            String jwt = JwtUtils.generateJwt(claims);
//
//        }

        return  emp1!=null?Result.success():Result.error();
    }


}
