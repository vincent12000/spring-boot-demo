package com.vic.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vic.demo.model.User;
import org.springframework.stereotype.Component;

public interface IUserService  extends IService<User>{
    User findByUsername(String username);

    void saveUser(User user);
}
