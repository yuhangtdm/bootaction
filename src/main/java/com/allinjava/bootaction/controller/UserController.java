package com.allinjava.bootaction.controller;

import com.allinjava.bootaction.common.result.ReturnResult;
import com.allinjava.bootaction.entity.User;
import com.allinjava.bootaction.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author:yuhang
 * @Date:2019/5/20
 */
@Controller
@RequestMapping("user")
@Api(description="用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询用户列表",notes="查询用户列表",position = 1,responseContainer="List",produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public ReturnResult<List<User>> findAll(){
        ReturnResult<List<User>> result = null;
        List<User> users = userService.getAll();
        if (users.size()>0){
            result  = ReturnResult.success(users);
        }else {
            result = ReturnResult.error(HttpStatus.NO_CONTENT);
        }
        return result;
    }
}
