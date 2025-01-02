package org.example.springboot_aop.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class DurationAspect {

    @Pointcut("execution(* org.example.springboot_aop.controller.*.*(..))")
    private void pt1() {}

    @Around("pt1()")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        Long begin = System.currentTimeMillis();
        log.info("aspect around start...");

        Object result = pjp.proceed();

        Long end = System.currentTimeMillis();
        log.info("aspect around end, Method:{}; execution duration: {}ms", pjp.getSignature() , end - begin);
        return result;
    }

    @Before("execution(* org.example.springboot_aop.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("aspect before...");

        // 获取目标类
        String className = joinPoint.getTarget().getClass().getName();
        log.info("aspect before, get className: {}", className);

        // 获取目标方法
        String methodName = joinPoint.getSignature().getName();
        log.info("aspect before, get methodName: {}()", methodName);

        // 获取目标方法参数
        Object[] args = joinPoint.getArgs();
        log.info("aspect before, get args: {}", Arrays.toString(args));

    }

    @After("execution(* org.example.springboot_aop.controller.*.*(..))")
    public void after() {
        log.info("aspect after...");
    }

    @After("@annotation(org.example.springboot_aop.anno.AnnoTest1)")
    public void after1() {
        log.info("aspect after1...");
    }

}
