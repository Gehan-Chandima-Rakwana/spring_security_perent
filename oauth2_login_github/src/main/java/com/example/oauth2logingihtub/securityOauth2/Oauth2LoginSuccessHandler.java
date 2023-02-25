package com.example.oauth2logingihtub.securityOauth2;

import com.example.oauth2logingihtub.serviceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Oauth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOauth2User oauth2User = (CustomOauth2User) authentication.getPrincipal();
        String loginName = oauth2User.getLogin();
        System.out.println(loginName);

        // You can check here User is already exist or not using user service
        // if user not exist can save user details to the table
        // if user exist can update same user in the database.

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
