package com.example.loginrememberusingcookies.serviceimpl;

import com.example.loginrememberusingcookies.config.MyUserDetails;
import com.example.loginrememberusingcookies.entity.User;
import com.example.loginrememberusingcookies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Not Found");

        return new MyUserDetails(user);
    }
}
