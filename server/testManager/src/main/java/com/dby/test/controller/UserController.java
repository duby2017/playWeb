package com.dby.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dby.test.entity.User;
import com.dby.test.mapper.UserMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/1/15.
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/list/users")
    public JSONObject listUsers(@RequestParam(name = "page", required = true) int page, @RequestParam(name = "limit", required = true) int limit,
                                @RequestParam(name = "name", defaultValue = "") String filerName, HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        JSONObject ret = new JSONObject();
        if (session == null) {
            ret.put("errcode", 40001);
            ret.put("errmsg", "不合法的参数");
            return ret;
        }

        System.out.println(session.getId());

        int statNum = (page - 1) * limit;
        int endNum = page * limit - 1;

        int count = userMapper.countUsers(filerName);

        List<User> userList = userMapper.listUsers(statNum, endNum, filerName);
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(userList);

        ArrayNode node = new ObjectMapper().createArrayNode();
        ret.put("total", count);
        ret.put("limit", limit);
        ret.put("users", jsonArray);
        return ret;
    }


    @PutMapping("/users/profile")
    public JSONObject updateUser(@RequestBody JsonNode params, HttpServletRequest req) {

        JSONObject ret = new JSONObject();
        HttpSession session = req.getSession(false);
        if (session == null) {
            ret.put("errcode", 40001);
            ret.put("errmsg", "不合法的参数");
            return ret;
        }

        String userName = params.path("useranme").asText();
        String nickName = params.path("nickname").asText();
        String name = params.path("name").asText();
        String email = params.path("email").asText();

        userMapper.updateUserInfo(userName, nickName, name, email);

        ret.put("errcode", 0);
        ret.put("errmsg", "修改成功");
        return ret;
    }

    @PutMapping("/auth/changePwd")
    public JSONObject changePwd(@RequestBody JsonNode params, HttpServletRequest req) {

        JSONObject ret = new JSONObject();
        HttpSession session = req.getSession(false);
        if (session == null) {
            ret.put("errcode", 40005);
            ret.put("errmsg", "不合法的参数");
            return ret;
        }

        String userName = session.getAttribute("username").toString();

        String oldPwd = params.path("oldPwd").asText();
        String newPwd = params.path("newPwd").asText();

        User user = userMapper.getUserByName(userName);
        if (!oldPwd.equals(user.getPassWord())) {
            ret.put("errcode", 40005);
            ret.put("errmsg", "原密码不对");
            return ret;
        }

        userMapper.updateUserPwd(userName, newPwd);

        ret.put("errcode", 0);
        ret.put("errmsg", "修改成功");
        return ret;
    }


}
