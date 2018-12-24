package com.vic.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vic.demo.model.User;

public interface IUserService {
    User findByUsername(String username);

    void saveUser(User user);
}
