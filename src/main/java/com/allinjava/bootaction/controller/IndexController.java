package com.allinjava.bootaction.controller;

import com.allinjava.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器
 * @author:yuhang
 * @Date:2019/5/17
 */
@Controller
public class IndexController {
// 扫描不到该类 由于不在启动类的同包下
//    @Autowired
//    private HelloService helloService;

    @GetMapping("/")
    public String index(){
//        int i =10/0; // 出现异常后 会自动跳转 templates/error/5xx.html

        return "index";
    }

}
