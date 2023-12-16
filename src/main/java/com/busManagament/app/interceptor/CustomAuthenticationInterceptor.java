package com.busManagament.app.interceptor;


import com.busManagament.app.service.authentication.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class CustomAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AuthenticationService authenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        authenticationService.isAuthenticated(request);
        return true;
    }
}