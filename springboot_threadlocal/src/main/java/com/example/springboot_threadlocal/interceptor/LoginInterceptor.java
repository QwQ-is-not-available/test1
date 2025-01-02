package com.example.springboot_threadlocal.interceptor;

import com.example.springboot_threadlocal.utils.CurrentHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("before threadlocal: {}", CurrentHolder.getCurrent());
        CurrentHolder.setCurrent("1111 from preHandle");

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("in afterCompletion threadlocal: {}", CurrentHolder.getCurrent());
        CurrentHolder.removeCurrent();
        log.info("remove in threadlocal");
    }
}
