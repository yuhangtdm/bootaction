package com.allinjava.bootaction.controller;


import com.allinjava.bootaction.entity.Job;
import com.allinjava.bootaction.entity.User;
import com.allinjava.bootaction.service.JobService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yuhang
 * @since 2019-05-20
 */
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("/findAll")
    public ResponseEntity findAll(){
        List<Job> jobs = jobService.selectList(new EntityWrapper<>());
        return new ResponseEntity(jobs, HttpStatus.OK);
    }

    @RequestMapping("/insert")
    public ResponseEntity insert(Job job){
        jobService.insert(job);
        return new ResponseEntity( HttpStatus.OK);
    }

    @RequestMapping("page")
    public ResponseEntity page(Job job, Page page){
        page=jobService.pageList(job,page);
        return new ResponseEntity(page,HttpStatus.OK);
    }
}

