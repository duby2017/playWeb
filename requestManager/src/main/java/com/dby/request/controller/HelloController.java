package com.dby.request.controller;

import com.dby.common.Hello;
import com.dby.request.entity.User;
import com.dby.request.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[1];
        array = list.toArray(array);

        return array.length+"";
    }

    @GetMapping("/my")
    @Transactional
    public void testMybatis() {

        User user = new User();
        user.setId("1");
        user.setName("dby");
        user.setAge(28);

        User user1 = new User();
        user1.setId("1");
        user1.setName("dby");
        user1.setAge(28);
        List<User>  list = Arrays.asList(user,user1);
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return 0;
            }
        });

    }
}
