package com.dby.test.controller;

import com.dby.common.Hello;
import com.dby.test.client.HelloService;
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

    @GetMapping("/")
    public String sayHello() {
        return helloService.sayRequstHello("test");
    }

    @GetMapping("/1")
    public String sayHello1() {
        return "hello1";
    }
}
