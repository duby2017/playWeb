package com.dby.test.mapper;

import com.dby.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/12/28.
 */
@Mapper
public interface UserMapper {

    void add(User user);

    void update(User user);

    void updateUserPwd(@Param(value = "username") String username,@Param(value = "pwd") String pwd);

    void updateUserInfo(@Param(value = "username") String username, @Param(value = "nickname") String nickname,
                        @Param(value = "name") String name, @Param(value = "email") String email);

    void delete(String id);

    User getUserByName(String userName);

    List<User> listUsers(@Param(value = "statNum") int statNum, @Param(value = "endNum") int endNum,
                         @Param(value = "filerName") String filerName);

    User get(String id);

    int countUsers(@Param(value = "filerName") String filerName);
}