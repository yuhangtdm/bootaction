package com.allinjava.bootaction;

import com.allinjava.bootaction.entity.Job;
import com.allinjava.bootaction.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuhang   2019/6/14 13:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void addCache(){
        Cache cache = cacheManager.getCache("bootaction");
        cache.put("myKey1","myValue1");
        cache.put("myKey2",new Job(1,"java开发"));
        List<String> list = Arrays.asList("java","php","go");
        cache.put("myKey3",list);
    }
}
