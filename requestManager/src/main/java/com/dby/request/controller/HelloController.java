package com.dby.request.controller;

import com.dby.common.Hello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/22.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return Hello.sayHello(name);
    }

    @GetMapping("/hello1")
    public String sayHello1() {
        return "hello1";
    }
}
