package com.allinjava.bootaction.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

//@XmlRootElement(name="User")
@ApiModel(value = "User",description = "用户实体")
public class User {

    @ApiModelProperty(value = "用户id")
    private long id;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "用户名称")
    private String username;
    @ApiModelProperty(value = "用户角色")
    private String role;
    @ApiModelProperty(value = "用户状态")
    private int status;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "注册时间")
    private Date regTime;
    @ApiModelProperty(value = "注册IP")
    private String regIp;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

}