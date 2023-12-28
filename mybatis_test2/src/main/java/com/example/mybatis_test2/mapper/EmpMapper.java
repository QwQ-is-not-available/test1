package com.example.mybatis_test2.mapper;

import com.example.mybatis_test2.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp;")
    public List<Emp> getEmpList();

    @Select("select * from emp where username=#{username} and password=#{password};")
    public Emp login(Emp emp);



}
