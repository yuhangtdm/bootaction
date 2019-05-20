package com.allinjava.bootaction.controller;

import com.allinjava.bootaction.entity.User;
import com.allinjava.bootaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author:yuhang
 * @Date:2019/5/20
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ResponseEntity findAll(){
        List<User> users = userService.getAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}
