package com.example.security.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
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
 * @Description: 自定义认证成功处理
 */
@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
        request.getSession().setAttribute("user", securityUser.getCurrentUserInfo());
        response.setContentType("text/html charset=utf-8");
        SavedRequest savedRequest = this.requestCache.getRequest(request, response);
        String targetUrl;
        if (savedRequest != null) {
            targetUrl = savedRequest.getRedirectUrl();
        } else {
            targetUrl = "/";
        }
        JSONObject obj = new JSONObject();
        obj.put("code", "200");
        obj.put("msg", "登录成功");
        obj.put("data", targetUrl);
        response.getWriter().print(obj.toJSONString());
    }
}
