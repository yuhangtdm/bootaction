package com.allinjava.bootaction.mp;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 配置
 * 插入时 创建时间和更新时间的自动插入
 * 更新时 更新时间的自动插入
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object testType = getFieldValByName("createTime", metaObject);
        if (testType == null) {
            setFieldValByName("createTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
        Object testType2 = getFieldValByName("updateTime", metaObject);
        if (testType2 == null) {
            setFieldValByName("updateTime",  new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime",  new Date(), metaObject);//mybatis-plus版本2.0.9+
    }

}
