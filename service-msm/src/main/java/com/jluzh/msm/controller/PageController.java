package com.jluzh.msm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面测试
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
