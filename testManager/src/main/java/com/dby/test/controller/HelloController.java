package com.dby.test.controller;

import com.dby.test.client.HelloService;
import com.dby.test.entity.User;
import com.dby.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/21.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String sayHello() {
        return helloService.sayRequstHello("test");
    }

    @GetMapping("/1")
    public String sayHello1() {
        return "hello1";
    }

    @GetMapping("/my")
    public void testMybatis()
    {
        User user = new User();
        user.setId("1");
        user.setName("dby");
        user.setAge(28);
        userMapper.add(user);
    }
}
