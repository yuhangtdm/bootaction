package com.allinjava.bootaction.service.impl;

import com.allinjava.bootaction.entity.Job;
import com.allinjava.bootaction.mapper.JobMapper;
import com.allinjava.bootaction.service.JobService;
import com.allinjava.bootaction.util.QueryUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuhang
 * @since 2019-05-20
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public Page pageList(Job job, Page page) {
        EntityWrapper<Job> wrapper=new EntityWrapper<>();
        wrapper.orderBy("update_time",false);
        QueryUtil.queryForm(wrapper,job);
        // 引入了mybatis的分页插件后，调用该方法即可做分页操作
        page = this.selectPage(page,wrapper);
        return page;
    }
}
