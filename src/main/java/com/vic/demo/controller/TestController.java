package com.vic.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vic.demo.model.RestResponse;
import com.vic.demo.model.Test;
import com.vic.demo.service.ITestService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class TestController {

    @Autowired
    private ITestService testService;


    @GetMapping("/a")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RestResponse<Test> index() {
        log.info("request /a");
//        Test t = testService.getById(1);
        Test t = new Test();
        t.setCount(1L);
        t.setId(2L);
        t.setPrice(BigDecimal.valueOf(210.0).multiply(BigDecimal.valueOf(0.7)).setScale(2, RoundingMode.UP));
        return RestResponse.success(t);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public List<Test> all() {
        return testService.findAll();
    }
}
