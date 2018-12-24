package com.vic.demo.service;

import com.vic.demo.model.Test;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author vic
 * @since 2018-10-27
 */
public interface ITestService extends IService<Test> {

    List<Test> findAll();
}
