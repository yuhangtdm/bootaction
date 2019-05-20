package com.allinjava.bootaction.mapper;

import com.allinjava.bootaction.entity.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author:yuhang
 * @Date:2018/12/25
 */
public interface UserMapper {

    // 查询所有用户
    List<User> getAll();
}
