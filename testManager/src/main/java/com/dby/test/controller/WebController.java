package com.dby.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/1/2.
 */
@Controller
public class WebController {

    @GetMapping("/web")
    public  String lookWeb()
    {
        return "index";
    }
}
