package com.vic.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vic.demo.model.Test;
import com.vic.demo.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    @PreAuthorize("hasRole('admin')")
    public Test index() {
//        Test t = testService.getById(1);
        Test t = new Test();
        t.setCount(1l);
        t.setId(2l);
        t.setPrice(BigDecimal.valueOf(210.0).multiply(BigDecimal.valueOf(0.7)).setScale(2, RoundingMode.UP));
        System.out.println(t.getPrice());
        return t;
    }

    @GetMapping("/all")
    public List<Test> all() {
        return testService.findAll();
    }
}
