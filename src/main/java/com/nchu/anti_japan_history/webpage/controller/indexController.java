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

    /*
     * 点击抗日战争首页跳转的地方
     * */
    @GetMapping("/index")
    public String skipIndex() {

        return "index";
    }

    /*
     * 登录页面跳转
     * */
    @GetMapping("/login")
    public String skipLogin() {
        return "login";
    }

    /*
     *关于抗战历史(局部、全国、伟大胜利），页面的跳转
     * */
    @GetMapping("/partHistory")
    public String skipPartHistory() {
        return "partHistory";
    }

    @GetMapping("/nationwideHistory")
    public String skipNationwideHistory(){
        return "nationwideHistory";
    }

    @GetMapping("/victoryHistory")
    public String skipVictoryHistory(){
        return "victoryHistory";
    }



}
