package com.dby.request.controller;

import com.dby.common.Hello;
import com.dby.request.entity.User;
import com.dby.request.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/22.
 */
@RestController
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return Hello.sayHello(name);
    }

    @GetMapping("/hello1")
    public String sayHello1() {
        return "hello1";
    }

    @GetMapping("/my")
    @Transactional
    public void testMybatis() {
        User user = new User();
        user.setId("1");
        user.setName("dby");
        user.setAge(28);
        userMapper.add(user);
    }
}
