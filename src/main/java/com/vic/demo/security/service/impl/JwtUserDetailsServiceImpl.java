package com.vic.demo.security.service.impl;

import com.vic.demo.model.User;
import com.vic.demo.security.utils.JwtUserFactory;
import com.vic.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

//    private static JwtUserDetailsServiceImpl jwtUserDetailsServiceImpl;
//
//    @PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
//    public void init() {
//        jwtUserDetailsServiceImpl = this;
//        jwtUserDetailsServiceImpl.userService = this.userService;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
//        User user = new User();
//        user.setId(1l);
//        user.setUsername("vic");
//        user.setPassword("$2a$10$cw56FoOPWdEAENLkIL9FdO1HK9r/ZGzLbiZLwY5vcG4BXYWXIlIQG");
        user.setRoles(Arrays.asList(new String[]{"admin"}));

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
