package com.vic.demo.security.service.impl;

import com.vic.demo.model.User;
import com.vic.demo.security.utils.JwtUserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);//应该改为从数据库拿
        User user = new User();
        user.setId(1l);
        user.setUsername("vic");
        user.setPassword("123456");
        user.setRoles(Arrays.asList(new String[]{"admin"}));

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
