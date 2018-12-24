package com.vic.demo.service.impl;

import com.vic.demo.model.Test;
import com.vic.demo.dao.TestMapper;
import com.vic.demo.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author vic
 * @since 2018-10-27
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Override
    public List<Test> findAll() {
        return this.list(null);
    }
}
