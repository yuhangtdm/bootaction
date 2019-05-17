package com.allinjava.bootaction.config;

import com.allinjava.bootaction.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author:yuhang
 * @Date:2019/5/17
 */
@Component
public class Tets {
    // 用在 @Component 也可以
    @Bean
    public UserService dataSource(){
        return new UserService();
    }
}
