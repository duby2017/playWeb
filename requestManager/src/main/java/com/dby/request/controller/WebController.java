package com.dby.request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2018/1/5.
 */
@Controller
public class WebController {


    @GetMapping("/web")
    public String lookWeb() {
        return "index";
    }
}
