package com.dby.test.controller;

import com.dby.test.client.HelloService;
import com.dby.test.mapper.UserMapper;
import com.dby.thread.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

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
        String a = getString("aa", "bb");
        return a;
    }

    @GetMapping("/2")
    public void sayHello2() {
        Map<String, String> map = new HashMap<>(10);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "f");
        map.forEach((k, v) -> {
            System.out.println(
                    k + "," + v);
        });

        List<String> list = Arrays.asList("a", "b", "c");

        List<String> s = list.stream().filter(str -> str == "a").collect(Collectors.toList());
        System.out.println(s);

    }

    @GetMapping("/3")
    public String sayHello3() {


        ExecutorService a = ThreadPoolUtils.getInstance();
        ExecutorService b = ThreadPoolUtils.getInstance();
        if (a == b) {
            return "true";
        }
        return "false";
    }

    private String getString(String... list) {
        StringBuilder strs = new StringBuilder();
        for (String a : list) {
            strs.append(a).append(" ");
        }
        return strs.toString() + "ccaeddrf";
    }
}
