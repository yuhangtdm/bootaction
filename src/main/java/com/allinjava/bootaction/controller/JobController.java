package com.allinjava.bootaction.controller;


import com.allinjava.bootaction.common.result.ReturnResult;
import com.allinjava.bootaction.entity.Job;
import com.allinjava.bootaction.entity.User;
import com.allinjava.bootaction.service.JobService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuhang
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有工作",position = 1)
    public ReturnResult<List<Job>> findAll(){
        ReturnResult<List<Job>> result = null;
        List<Job> jobs = jobService.selectList(new EntityWrapper<>());
        if (jobs.size()>0){
            result  = ReturnResult.success(jobs);
        }else {
            result = ReturnResult.error(HttpStatus.NO_CONTENT);
        }
        return result;
    }

    @PostMapping("/insert")
    @ApiOperation(value = "插入工作",position = 2)
    public ReturnResult<Job> insert(Job job){
        ReturnResult<Job> result = null;
        boolean insert = jobService.insert(job);
        if (insert){
            result  = ReturnResult.success(job);
        }else {
            result = ReturnResult.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return result;
    }

    @GetMapping("page")
    @ApiOperation(value = "查询工作分页",position = 3)
    public ReturnResult<Page> page(Job job, Page page){
        page=jobService.pageList(job,page);
        return ReturnResult.success(page);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据主键查询工作",position = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path", name = "id", value = "工作id", required = true, dataType = "long"),
    })
    public ReturnResult<Job> findById(@PathVariable Long id){
        ReturnResult<Job> result = null;
        Job job = jobService.selectById(id);
        if (job!=null){
            result  = ReturnResult.success(job);
        }else {
            result = ReturnResult.error(HttpStatus.NO_CONTENT);
        }
        return result;
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "根据名称查询工作",position = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "name", value = "工作名称", required = true, dataType = "string"),
    })
    public ReturnResult<Job> findByName(String name){
        ReturnResult<Job> result = null;
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("name",name);
        Job job = jobService.selectOne(wrapper);
        if (job!=null){
            result  = ReturnResult.success(job);
        }else {
            result = ReturnResult.error(HttpStatus.NO_CONTENT);
        }
        return result;
    }

}

