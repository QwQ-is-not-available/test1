package com.example.mybatis_test2;

import com.example.mybatis_test2.mapper.EmpMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MybatisTest2ApplicationTests {
    @Autowired
    private EmpMapper empMapper;

    @Test
    void contextLoads() {
        System.out.println(empMapper.getEmpList());
    }

    @Test
    public void testGenJWT(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt=Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"miyao")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        Claims claims=Jwts.parser()
                .setSigningKey("miyao")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwMzc4NDkwMn0.l7VxEJV5-RZp0mZj0zJqw__x2KlRa-kChvF148rZgUk")
                .getBody();
        System.out.println(claims);
    }


}
