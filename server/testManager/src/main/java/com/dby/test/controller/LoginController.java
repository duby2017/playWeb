package com.dby.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.dby.test.entity.User;
import com.dby.test.mapper.UserMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2018/1/15.
 */
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/auth/login")
    public JSONObject login(@RequestBody JsonNode params, HttpServletRequest req) {

        JSONObject ret = new JSONObject();
        String userName = params.path("username").asText();

        String pwd = params.path("pwd").asText();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(pwd)) {
            ret.put("errcode", 40002);
            ret.put("errmsg", "不合法的参数");
            return ret;
        }

        User user = userMapper.getUserByName(userName);
        if (user == null) {
            ret.put("errcode", 40003);
            ret.put("errmsg", "用户不存在");
            return ret;
        }

        if (!user.getPassWord().equals(pwd)) {
            ret.put("errcode", 40004);
            ret.put("errmsg", "密码错误");
            return ret;
        }
        HttpSession session = req.getSession();
        session.setAttribute("username", user.getUserName());
        System.out.println(session.getId());

        ret.put("id", user.getId());
        ret.put("username", user.getUserName());
        ret.put("nickname", user.getNickName());
        ret.put("name", user.getName());
        ret.put("email", user.getEmail());
        return ret;
    }

    @GetMapping("/users/logout")
    public JSONObject loginOut(HttpServletRequest req) {

        JSONObject ret = new JSONObject();
        HttpSession session = req.getSession(false);
        System.out.println(session);
        if (session != null) {
            System.out.println(session.getId());
            session.invalidate();
        }

        ret.put("errcode", 0);
        ret.put("errmsg", "退出完成");
        return ret;
    }


}
