package com.example.security.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wxy
 * @Date: 2020/11/18
 * @Description:
 */
@Component
public class AdminAuthenticationFailureHandler implements AuthenticationFailureHandler {

    Logger logger = LoggerFactory.getLogger(AdminAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.error(exception.toString());
        response.setContentType("text/json; charset=UTF-8");
        JSONObject obj = new JSONObject();
        obj.put("code", "400");
        obj.put("msg", "登录失败: " + exception.getMessage());
        response.getWriter().print(obj.toJSONString());
    }
}
