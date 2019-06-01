package com.allinjava.bootaction.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * 缓存的配置类
 * @author: yuhang
 * @date: 2019/6/1
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * redis key的生成策略
     * 使用在业务方法时自动生成key的策略
     */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append("business:");
                sb.append(o.getClass().getName()).append(".");
                sb.append(method.getName()).append("(");
                for (Object obj :objects) {
                    sb.append(obj.toString()).append(",");
                }
                sb.append(")");
                return sb.toString();
            }
        };
    }

}
