package com.nchu.anti_japan_history.webpage.controller;


import com.alibaba.fastjson.JSON;
import com.nchu.anti_japan_history.webpage.entity.*;
import com.nchu.anti_japan_history.webpage.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @Author: wangshen
 * @Date: 2020/4/2
 * @Description: 网站主页面的控制类
 */
@Controller
public class indexController {
    @Autowired
    AntiHistoryService antiHistoryService;//抗战历史
    @Autowired
    AntiSiteService antiSiteService;//抗战遗址
    @Autowired
    AntiWarStoriesService antiWarsStoriesService;//抗战故事
    @Autowired
    AntiJapanPersonService antiJapanPersonService;//抗战人物
    @Autowired
    InternationalFriendService internationalFriendService;//国际友人
    @Autowired
    PeriodicalService periodicalService;//期刊
    @Autowired
    NewspaperService newspaperService;//报纸
    @Autowired
    BookService bookService;//书籍
    @Autowired
    PictureService pictureService;//图片


    //日志
    Logger logger = LoggerFactory.getLogger(indexController.class);

    //进行主页面的数据加载
    @RequestMapping("/")
    public String skipIndex(HttpSession httpSession) {
        //读取抗战历史
        List<AntiHistory> partList = antiHistoryService.partHistorySelect();
        /*for (int i = 0; i < partList.size();i++){
            System.out.println(partList.get(i) + " ");
        }*/
        List<AntiHistory> nationwideList = antiHistoryService.nationwideHistorySelect();
        List<AntiHistory> victoryList = antiHistoryService.victoryHistorySelect();
        List<AntiHistory> guerrillaList = antiHistoryService.guerrillaWarfareSelect();
        //读取抗战人物
        List<AntiJapanPerson> antiJapanPersonList = antiJapanPersonService.antiJapanPersonSelect();
        //读取抗战遗址
        List<AntiSite> antiSiteList = antiSiteService.antiSiteSelect();
        //读取抗战故事
        List<AntiWarStories> antiWarStoriesList = antiWarsStoriesService.antiWarStoriesSelect();
        //读取国际友人
        List<InternationalFriend> internationalFriendList = internationalFriendService.internationalFriendSelect();
        //放进session中
        httpSession.setAttribute("partList", partList);
        httpSession.setAttribute("nationwideList", nationwideList);
        httpSession.setAttribute("victoryList", victoryList);
        httpSession.setAttribute("guerrillaList", guerrillaList);
        httpSession.setAttribute("antiJapanPersonList", antiJapanPersonList);
        httpSession.setAttribute("antiSiteList", antiSiteList);
        httpSession.setAttribute("antiWarStoriesList", antiWarStoriesList);
        httpSession.setAttribute("internationalFriendList", internationalFriendList);
        return "index";
    }

    /*
     * 点击抗日战争首页跳转的地方
     * */
    @GetMapping("/index")
    public String skipIndexData() {
        return "index";
    }

    /*
     * 登录页面跳转
     * */
    @GetMapping("/login")
    public String skipLogin() {
        return "login";
    }
    //退出
    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.removeAttribute("user");
        return "index";
    }

    //局部抗战历史页面的跳转
    @GetMapping("/partHistory")
    public String skipPartHistory(Model model){
        List<AntiHistory> partListAll = antiHistoryService.partListAll();
        model.addAttribute("partListAll", partListAll);
        return "partHistory";
    }
    //局部抗战史的信息显示
  /*  @GetMapping("/partJson")
    public void PartJson(Model model, HttpServletResponse httpServletResponse) throws IOException {
        List<AntiHistory> partListAll = antiHistoryService.partListAll();
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        String json = JSON.toJSONString(partListAll);
        System.out.println("json ="+ json );
        PrintWriter out = httpServletResponse.getWriter();
        out.write(json);
        model.addAttribute("partListAll", partListAll);
    }*/

    @GetMapping("/nationwideHistory")
    public String skipNationwideHistory(Model model) {
        List<AntiHistory> nationwideListAll = antiHistoryService.nationwideListAll();
        model.addAttribute("nationwideListAll", nationwideListAll);
        return "nationwideHistory";
    }

    @GetMapping("/victoryHistory")
    public String skipVictoryHistory(Model model) {
        List<AntiHistory> victoryListAll = antiHistoryService.nationwideListAll();
        model.addAttribute("victoryListAll", victoryListAll);
        return "victoryHistory";
    }

    @GetMapping("/guerrillaWarfare")
    public String skipGuerrillaWarfare(Model model) {
        List<AntiHistory> guerrillaListAll = antiHistoryService.guerrillaWarfareListAll();
        model.addAttribute("guerrillaListAll", guerrillaListAll);
        return "guerrillaWarfare";
    }

    //抗战人物显示listAll
    @GetMapping("/AntiPerson")
    public String skipAntiJapanPerson(Model model) {
        List<AntiJapanPerson> antiPersonListAll = antiJapanPersonService.antiPersonListAll();
        model.addAttribute("antiPersonListAll", antiPersonListAll);
        return "antiPerson";
    }

    //抗战遗址的显示
    @GetMapping("/AntiSite")
    public String skipAntiSite(Model model) {
        List<AntiSite> antiSiteListAll = antiSiteService.antiSiteListAll();
        model.addAttribute("antiSiteListAll", antiSiteListAll);
        return "antiSite";
    }

    //抗战故事的显示all
    @GetMapping("/AntiStories")
    public String skipAntiStories(Model model) {
        List<AntiWarStories> antiWarStoriesListAll = antiWarsStoriesService.antiStoriesListAll();
        model.addAttribute("antiWarStoriesListAll", antiWarStoriesListAll);
        return "antiStories";
    }

    //国际友人的显示all
    @GetMapping("/NationalFriend")
    public String skipNational(Model model) {
        List<InternationalFriend> internationalFriendsListAll = internationalFriendService.internationalFriendListAll();
        model.addAttribute("internationalFriendsListAll", internationalFriendsListAll);
        return "international";
    }

    //期刊显示all
    @GetMapping("/periodical")
    public String skipPeriodical(Model model) {
        List<Periodical> periodicalListAll = periodicalService.periodicalListAll();
        model.addAttribute("periodicalListAll",periodicalListAll);
        return "periodical";
    }

    //书籍显示all
    @GetMapping("/book")
    public String skipBook(Model model){
        List<Books> bookListAll = bookService.bookListAll();
        model.addAttribute("bookListAll",bookListAll);
        return "book";
    }

    //报纸显示all
    @GetMapping("/newspaper")
    public String skipNewspaper(Model model){
        List<Newspaper> newspaperListAll = newspaperService.newspaperListAll();
        model.addAttribute("newspaperListAll",newspaperListAll);
        return "newspaper";
    }

    //图片显示
    @GetMapping("/picture")
    public String skipPicture(Model model){
        List<Picture> pictureListAll = pictureService.pictureListAll();
        model.addAttribute("pictureListAll",pictureListAll);
        return "picture";
    }

    //时间轴的跳转
    @GetMapping("/historyTime")
    public String skipHistoryTime() {
        return "historyTime";
    }

    //历史地图的跳转
    @GetMapping("")
    public String skipHistoryMap(){
        return "historyMap";
    }


}
