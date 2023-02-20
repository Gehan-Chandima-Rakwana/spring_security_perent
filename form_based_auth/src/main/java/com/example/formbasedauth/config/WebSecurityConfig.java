package com.example.formbasedauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("user")
                .password("$2a$10$Uehl3Fk79dQ9byQB3FehrOMIGKUoak1PghCiE7DhKKCqFu7Q.QItK") //user
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withUsername("admin")
                .password("$2a$10$rieuLfq0evvSN1y29JVSTuXirYiFi32VyEYSyhQ13FxGM6Mo6gdme") //admin
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user2);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/food").permitAll()
                .antMatchers("/food/addView","/food/addNewFood").hasAnyRole("ADMIN","USER")
                .antMatchers("/food/updateView/*","/food/updateNewFood/*","/food/deleteFood/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/food")
                    .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
