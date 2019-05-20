package com.allinjava.bootaction.util;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.lang.reflect.Field;

/**
 * 表单查询的公共类
 * @author: yuhang
 * @date: 2018/9/1
 */
public class QueryUtil {

    /**
     * 查询表单的公共方法 模糊查询 页面上传递的参数 适合于单表
     */
    public static void queryForm(EntityWrapper wrapper,Object entity){
        try {
            if(entity!=null){
                Field[] declaredFields = entity.getClass().getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    declaredField.setAccessible(true);
                    Object field = declaredField.get(entity);
                    if (!declaredField.getName().equals("serialVersionUID")){
                        if(StringUtil.isNotEmptyObj(field)){
                            TableField annotation = declaredField.getAnnotation(TableField.class);
                            if(StringUtil.isNotEmptyObj(annotation)){
                                wrapper.and().like(annotation.value(),String.valueOf(field));
                            }else {
                                wrapper.and().like(declaredField.getName(),String.valueOf(field));
                            }

                        }
                    }

                }
            }
        }catch (Exception e){

        }

    }
}
