package com.dby.request.mapper;

import com.dby.request.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator on 2017/12/28.
 */
@Mapper
public interface UserMapper {

    void add(User user);

    void update(User user);

    void delete(String id);

    User get(String id);
}