package com.example.demo.controller;

import com.example.demo.service.HelloService;
import com.example.demo.service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/8.
 */
@RestController
public class HelloController {

    @Autowired
    public HelloService helloService;

    @Autowired
    public TalkService talkService;

    @GetMapping("/")
    public String sayHello() {
        return helloService.sayHello();
    }

    @GetMapping("/talk")
    public String talk() {
        return talkService.talk();
    }
}
