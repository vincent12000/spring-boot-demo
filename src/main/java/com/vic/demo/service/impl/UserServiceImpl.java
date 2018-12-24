package com.vic.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vic.demo.dao.TestMapper;
import com.vic.demo.dao.UserMapper;
import com.vic.demo.model.User;
import com.vic.demo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User findByUsername(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        return this.getOne(queryWrapper);

    }

    @Override
    public void saveUser(User user) {
        this.save(user);
    }
}
