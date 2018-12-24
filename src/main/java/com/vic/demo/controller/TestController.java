package com.vic.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vic.demo.model.Test;
import com.vic.demo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author vic
 * @since 2018-10-27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("/a")
    public Test index() {
        Test t = testService.getById(1);
        System.out.println(t.getCount());
        return t;
    }

    @GetMapping("/all")
    public List<Test> all() {
        return testService.findAll();
    }
}
