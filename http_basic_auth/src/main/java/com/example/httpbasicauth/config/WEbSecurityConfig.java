package com.example.httpbasicauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WEbSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password("$2a$10$rieuLfq0evvSN1y29JVSTuXirYiFi32VyEYSyhQ13FxGM6Mo6gdme") // copy from pre generated encode password "admin"
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("$2a$10$Uehl3Fk79dQ9byQB3FehrOMIGKUoak1PghCiE7DhKKCqFu7Q.QItK") //user
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/food").permitAll() // home page can access anyone
                .antMatchers("/food/addView","/food/addNewFood").hasAnyRole("ADMIN","USER")
                .antMatchers("/food/updateView/*","/food/updateNewFood/*","/food/deleteFood/*").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
