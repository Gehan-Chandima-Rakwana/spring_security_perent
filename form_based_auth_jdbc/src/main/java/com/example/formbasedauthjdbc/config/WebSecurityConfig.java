package com.example.formbasedauthjdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource; //It will read database connection information from the application.properties file.

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("SELECT username,password,enabled FROM users WHERE users.username =?")
                .authoritiesByUsernameQuery("SELECT username,role FROM users WHERE users.username = ?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/food").permitAll()
                .antMatchers("/food/addView","/food/addNewFood").hasAnyRole("ADMIN","USER")
                .antMatchers("/food/updateView/*","/food/updateNewFood/*","/food/deleteFood/*").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/food",true).permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
