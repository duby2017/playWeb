package com.dby.request.controller;

import com.dby.common.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/22.
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return Hello.sayHello("request");
    }
}
