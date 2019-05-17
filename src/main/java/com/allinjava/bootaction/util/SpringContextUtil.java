package com.allinjava.bootaction.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:yuhang
 * @Date:2019/5/17
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static   ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static  <T> T getBean(String beanName){
        return (T) applicationContext.getBean(beanName);
    }

    public static  <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }
}
