package com.nchu.anti_japan_history.webpage.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



/**
 * @Author: wangshen
 * @Date: 2020/4/2
 * @Description: 网站主页面的控制类
 */
@Controller
public class indexController {

//日志
    Logger logger = LoggerFactory.getLogger(indexController.class);

//部分导航栏的页面跳转处理
    @GetMapping("/index")
    public String skipIndex(){

        return "index";
    }

    @GetMapping("/login")
    public String skipLogin(){
        return "login";
    }



}
