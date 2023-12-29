package com.example.mybatis_test2.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.mybatis_test2.pojo.Result;
import com.example.mybatis_test2.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //判断url里是否有login
        String url = req.getRequestURI();
        log.info("请求的url:{}",url);
        if(url.contains("login")){
            log.info("登录操作，继续...");
            return true;
        }

        //获得请求头里的token
        String jwt = req.getHeader("token");

        //判断token是否为空
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token是空");
            String notLogin = JSONObject.toJSONString(Result.error("not login"));
            resp.getWriter().write(notLogin);
            return false;
        }
        //尝试解析jwt
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录");
            String notLogin = JSONObject.toJSONString(Result.error("not login"));
            resp.getWriter().write(notLogin);
            return false;

        }
        //放行
        log.info("令牌合格");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...111");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...111");
    }
}
