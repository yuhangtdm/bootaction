package com.allinjava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuhang
 * @date: 2019/6/1
 */
@Configuration
public class OutSpringBootConfiguration {

    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
