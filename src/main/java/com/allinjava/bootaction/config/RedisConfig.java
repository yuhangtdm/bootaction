package com.allinjava.bootaction.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * redis的配置类
 * 该注解可以用在业务查询方法上 会先进行查询,查询到数据 不执行业务方法
 * @Cacheable(value = "brandCache",key = "'select:com.dmall.product.service.impl.BrandServiceImpl.list()'")
 *
 * 该注解用在增删改业务方法上 执行后会更新缓存
 * @CachePut(value = "brandCache",key = "'select:com.dmall.product.service.impl.BrandServiceImpl.list()'")
 *
 * @author:yuhang
 * @Date:2018/8/16
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * springBoot默认配置了RedisTemplate 和StringRedisTemlate
     * RedisAutoConfiguration
     * 配置该RedisTemplate 使用string的key,json的value
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String,Object> redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // hashKey也才有String的序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        // jackson序列化方式
        Jackson2JsonRedisSerializer jsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om=new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jsonRedisSerializer.setObjectMapper(om);

        // value 和hashValue 都采取jackson序列化的方式
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);

        return redisTemplate;
    }


    /**
     * 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }
}
