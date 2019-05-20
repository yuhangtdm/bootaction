package com.allinjava.bootaction.service;

import com.allinjava.bootaction.entity.Job;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-20
 */
public interface JobService extends IService<Job> {

    Page pageList(Job job, Page page);
}
