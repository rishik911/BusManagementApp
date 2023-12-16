package com.busManagament.app.service.authentication;


import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    String generateToken(String userName, String Password) throws Exception;

    void isAuthenticated(HttpServletRequest request) throws Exception;

}