package com.allinjava.bootaction.controller;

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

    @GetMapping("/")
    public String index(){
        int i =10/0; // 出现异常后 会自动跳转 templates/error/5xx.html
        return "index";
    }

}
