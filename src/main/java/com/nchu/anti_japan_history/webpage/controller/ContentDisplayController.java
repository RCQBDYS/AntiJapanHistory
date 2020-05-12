package com.nchu.anti_japan_history.webpage.controller;

import com.nchu.anti_japan_history.utils.StringReplace;
import com.nchu.anti_japan_history.webpage.entity.*;
import com.nchu.anti_japan_history.webpage.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentDisplayController {
    //日志
    Logger logger = LoggerFactory.getLogger(indexController.class);
    @Autowired
    AntiJapanPersonService antiJapanPersonService;
    @Autowired
    AntiSiteService antiSiteService;
    @Autowired
    AntiWarStoriesService antiWarStoriesService;
    @Autowired
    InternationalFriendService internationalFriendService;
    @Autowired
    BookService bookService;
    @Autowired
    NewspaperService newspaperService;
    @Autowired
    PeriodicalService periodicalService;
    @Autowired
    PictureService pictureService;
    @Autowired
    AntiHistoryService antiHistoryService;

    //局部战争详细显示
    @GetMapping("/partHistoryDisplay")
    public String PartHistoryDisplay(String antiHistoryId, Model model) {
        //System.out.println("antiHistoryId="+antiHistoryId);
        Long AntiHistoryId = Long.parseLong(antiHistoryId);
        AntiHistory partHistoryDisplay = antiHistoryService.selectHistoryDisplay(AntiHistoryId);
        String content = partHistoryDisplay.getAntiHistoryContent();
        StringReplace stringReplace = new StringReplace();
        content = stringReplace.StrReplace(content);
        //System.out.println("content="+content);
        partHistoryDisplay.setAntiHistoryContent(content);
        model.addAttribute("partHistoryDisplay",partHistoryDisplay);
        return "detailsHistory";
    }

    //抗战人物详细显示
    @GetMapping("/antiPersonDisplay")
    public String AntiPersonDisplay(String antiJapanPersonId,Model model){
        Long PersonId = Long.parseLong(antiJapanPersonId);
        AntiJapanPerson antiJapanPersonDisplay = antiJapanPersonService.antiPersonDisplay(PersonId);
        String content = antiJapanPersonDisplay.getContent();
        StringReplace stringReplace = new StringReplace();
        content = stringReplace.StrReplace(content);
        antiJapanPersonDisplay.setContent(content);
        model.addAttribute("antiJapanPersonDisplay",antiJapanPersonDisplay);
        return "detailsHistoryPerson";
    }

    //抗战故事的详细显示
    @GetMapping("/antiStoriesDisplay")
    public String AntiStoriesDisplay(String antiWarId,Model model){
        Long AntiWarId = Long.parseLong(antiWarId);
        AntiWarStories antiWarStoriesDisplay = antiWarStoriesService.antiStoriesDisplay(AntiWarId);
        String storiesContent = antiWarStoriesDisplay.getStoriesContent();
        StringReplace stringReplace = new StringReplace();
        storiesContent = stringReplace.StrReplace(storiesContent);
        antiWarStoriesDisplay.setStoriesContent(storiesContent);
        model.addAttribute("antiWarStoriesDisplay",antiWarStoriesDisplay);
        return "detailsHistoryStories";
    }

    //抗日历史遗址详细显示
    @GetMapping("/antiSiteDisplay")
    public String AntiSiteDisplay(String antiSiteId,Model model){
        Long AntiSiteId = Long.parseLong(antiSiteId);
        AntiSite antiSiteDisplay = antiSiteService.antiSiteDisplay(AntiSiteId);
        model.addAttribute("antiSiteDisplay",antiSiteDisplay);
        return "detailsAntiSite";
    }

    //国际友人信息详细显示
    @GetMapping("/friendDisplay")
    public String FriendDisplay(String internationalFriendId,Model model){
        Long InternationalFriendId = Long.parseLong(internationalFriendId);
        InternationalFriend internationalFriendDisplay = internationalFriendService.internationalFriendDisplay(InternationalFriendId);
        String achievement = internationalFriendDisplay.getAchievement();
        StringReplace stringReplace = new StringReplace();
        achievement = stringReplace.StrReplace(achievement);
        internationalFriendDisplay.setAchievement(achievement);
        model.addAttribute("internationalFriendDisplay",internationalFriendDisplay);
        return "detailsFriend";
    }

    //书籍信息的详细显示
    @GetMapping("/bookDisplay")
    public String BookDisplay(String bookId,Model model){
        Long BookId = Long.parseLong(bookId);
        Books booksDisplay = bookService.bookDisplay(BookId);
        model.addAttribute("booksDisplay",booksDisplay);
        return "detailsBook";
    }

    //报纸信息的详细显示
    @GetMapping("/newspaperDisplay")
    public String NewspaperDisplay(String newspaperId,Model model){
        Long NewspaperId = Long.parseLong(newspaperId);
        Newspaper newspaperDisplay = newspaperService.newspaperDisplay(NewspaperId);
        model.addAttribute("newspaperDisplay",newspaperDisplay);
        return "detailsNewspaper";
    }

    //期刊信息的详细显示
    @GetMapping("/periodicalDisplay")
    public String PeriodicalDisplay(String periodicalId,Model model){
        Long PeriodicalId = Long.parseLong(periodicalId);
        Periodical periodicalDisplay = periodicalService.periodicalDisplay(PeriodicalId);
        model.addAttribute("periodicalDisplay",periodicalDisplay);
        return "detailsPeriodical";
    }

    //图片信息的详细显示
    @GetMapping("/pictureDisplay")
    public String PictureDisplay(String pictureId,Model model){
        Long PictureId = Long.parseLong(pictureId);
        Picture pictureDisplay = pictureService.pictureDisplay(PictureId);
        model.addAttribute("pictureDisplay",pictureDisplay);
        return "detailsPicture";
    }
}
