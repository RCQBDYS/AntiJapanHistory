package com.nchu.anti_japan_history.webpage.controller;

import com.nchu.anti_japan_history.utils.RandomUtils;
import com.nchu.anti_japan_history.utils.SensitiveWordFilter;
import com.nchu.anti_japan_history.utils.StringReplace;
import com.nchu.anti_japan_history.webpage.entity.*;
import com.nchu.anti_japan_history.webpage.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * @Author: wangshen
 * @Date: 2020/5/11
 * @Description: 普通用户后台管理中心
 */

@Controller
public class ConsumerController {
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
    @Autowired
    UserService userService;

    //配置文件中的图片保存路径
    @Value("${cbs.imagesPath}")
    private String ImagesPath;

    //普通用户中心
    //用户进入个人中心
    @GetMapping("/unit")
    public String skipUserUnit(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Object ourSer = session.getAttribute("user");
        User user = null;
        if (ourSer instanceof  User){
             user =(User)ourSer;
        }
        String antiHistoryContribution = user.getUserName();
        //System.out.println("userName="+userName);
        //查询用户未通过的历史条目
        List<AntiHistory> consumerNotAdoptedListAll = antiHistoryService.consumerNotAdoptedListAll(antiHistoryContribution);
        //查询用户待审核的历史条目
        List<AntiHistory> consumerAuditHistoryListAll = antiHistoryService.consumerAuditHistoryListAll(antiHistoryContribution);
        //查询用户已通过的历史条目
        List<AntiHistory> consumerPassHistoryListAll = antiHistoryService.consumerPassHistoryListAll(antiHistoryContribution);

        //查询审核通过的历史人物
        List<AntiJapanPerson> consumerPassPersonListAll = antiJapanPersonService.consumerPassPerson(antiHistoryContribution);
        //查询待审核的历史人物
        List<AntiJapanPerson> consumerAuditPersonListAll = antiJapanPersonService.consumerAuditPerson(antiHistoryContribution);
        //查询未通过的历史人物
        List<AntiJapanPerson> consumerNotAdoptedPersonListAll = antiJapanPersonService.consumerNotAdoptedPerson(antiHistoryContribution);

        //查询审核通过的抗战故事
        List<AntiWarStories> consumerPassStories = antiWarStoriesService.consumerPassStories(antiHistoryContribution);
        //查询待审核的抗战故事
        List<AntiWarStories> consumerAuditStories = antiWarStoriesService.consumerAuditStories(antiHistoryContribution);
        //查询未通过的抗战故事
        List<AntiWarStories> consumerNotAdoptedStores = antiWarStoriesService.consumerNotAdoptedStores(antiHistoryContribution);

        ///查询审核通过的抗战遗址
        List<AntiSite> consumerPassSite = antiSiteService.consumerPassSite(antiHistoryContribution);
        //查询待审核的抗战遗址
        List<AntiSite> consumerAuditSite = antiSiteService.consumerAuditSite(antiHistoryContribution);
        //查询未通过的抗战遗址
        List<AntiSite> consumerNotAdoptedSite = antiSiteService.consumerNotAdoptedSite(antiHistoryContribution);

        //查询审核通过的国际友人
        List<InternationalFriend> consumerPassFriend = internationalFriendService.consumerPassFriend(antiHistoryContribution);
        //查询待审核的国际友人
        List<InternationalFriend> consumerAuditFriend = internationalFriendService.consumerAuditFriend(antiHistoryContribution);
        //查询未通过的国际友人
        List<InternationalFriend> consumerNotAdoptedFriend = internationalFriendService.consumerNotAdoptedFriend(antiHistoryContribution);

        //查询通过的书籍信息
        List<Books> consumerPassBook = bookService.consumerPassBook(antiHistoryContribution);
        //查询待审核的书籍信息
        List<Books> consumerAuditBook = bookService.consumerAuditBook(antiHistoryContribution);
        //查询未通过的书籍信息
        List<Books> consumerNotAdoptedBook = bookService.consumerNotAdoptedBook(antiHistoryContribution);

        //查询通过的期刊信息
        List<Periodical> consumerPassPeriodical = periodicalService.consumerPassPeriodical(antiHistoryContribution);
        //查询待审核的期刊信息
        List<Periodical> consumerAuditPeriodical = periodicalService.consumerAuditPeriodical(antiHistoryContribution);
        //查询未通过的期刊信息
        List<Periodical> consumerNotAdoptedPeriodical = periodicalService.consumerNotAdoptedPeriodical(antiHistoryContribution);

        //查询通过的报纸信息
        List<Newspaper> consumerPassNews = newspaperService.consumerPassNewspaper(antiHistoryContribution);
        //查询待审核的报纸信息
        List<Newspaper> consumerAuditNews = newspaperService.consumerAuditNewspaper(antiHistoryContribution);
        //查询未通过的报纸信息
        List<Newspaper> consumerNotAdoptedNews = newspaperService.consumerNotAdoptedNewspaper(antiHistoryContribution);

        //查询通过的图片信息
        List<Picture> consumerPassPicture = pictureService.consumerPassPicture(antiHistoryContribution);
        //查询待审核的图片信息
        List<Picture> consumerAuditPicture = pictureService.consumerAuditPicture(antiHistoryContribution);
        //查询未通过的图片信息
        List<Picture> consumerNotAdoptedPicture = pictureService.consumerNotAdoptedPicture(antiHistoryContribution);

        model.addAttribute("consumerNotAdoptedListAll", consumerNotAdoptedListAll);
        model.addAttribute("consumerAuditHistoryListAll", consumerAuditHistoryListAll);
        model.addAttribute("consumerPassHistoryListAll", consumerPassHistoryListAll);

        model.addAttribute("consumerPassPersonListAll", consumerPassPersonListAll);
        model.addAttribute("consumerAuditPersonListAll", consumerAuditPersonListAll);
        model.addAttribute("consumerNotAdoptedPersonListAll", consumerNotAdoptedPersonListAll);

        model.addAttribute("consumerPassStories", consumerPassStories);
        model.addAttribute("consumerAuditStories", consumerAuditStories);
        model.addAttribute("consumerNotAdoptedStores", consumerNotAdoptedStores);

        model.addAttribute("consumerPassSite", consumerPassSite);
        model.addAttribute("consumerAuditSite", consumerAuditSite);
        model.addAttribute("consumerNotAdoptedSite", consumerNotAdoptedSite);

        model.addAttribute("consumerPassFriend", consumerPassFriend);
        model.addAttribute("consumerAuditFriend", consumerAuditFriend);
        model.addAttribute("consumerNotAdoptedFriend", consumerNotAdoptedFriend);

        model.addAttribute("consumerPassBook", consumerPassBook);
        model.addAttribute("consumerAuditBook", consumerAuditBook);
        model.addAttribute("consumerNotAdoptedBook", consumerNotAdoptedBook);

        model.addAttribute("consumerPassPeriodical", consumerPassPeriodical);
        model.addAttribute("consumerAuditPeriodical", consumerAuditPeriodical);
        model.addAttribute("consumerNotAdoptedPeriodical", consumerNotAdoptedPeriodical);

        model.addAttribute("consumerPassNews", consumerPassNews);
        model.addAttribute("consumerAuditNews", consumerAuditNews);
        model.addAttribute("consumerNotAdoptedNews", consumerNotAdoptedNews);

        model.addAttribute("consumerPassPicture", consumerPassPicture);
        model.addAttribute("consumerAuditPicture", consumerAuditPicture);
        model.addAttribute("consumerNotAdoptedPicture", consumerNotAdoptedPicture);

        return "userUnit";
    }

    //用户跳转至历史条目修改页面
    @GetMapping("/editAntiHistory")
    public String EditAntiHistory(Long antiHistoryId, Model model) {
        AntiHistory antiHistoryEdit = antiHistoryService.selectHistoryDisplay(antiHistoryId);
        String content = antiHistoryEdit.getAntiHistoryContent();
        StringReplace stringReplace = new StringReplace();
        content = stringReplace.StrReplace(content);
        antiHistoryEdit.setAntiHistoryContent(content);
        model.addAttribute("antiHistoryEdit", antiHistoryEdit);
        return "editAntiHistory";
    }

    //普通用户 历史条目更新
    @PostMapping("/editAntiHistoryUpdate")
    public String EditAntiHistoryUpdate(@RequestParam(value = "antiHistoryName") String antiHistoryName,
                                        @RequestParam(value = "antiHistoryDescription") String antiHistoryDescription,
                                        @RequestParam(value = "antiHistoryPicture") MultipartFile antiHistoryPicture,
                                        @RequestParam(value = "antiHistoryContent") String antiHistoryContent,
                                        @RequestParam(value = "antiHistoryType") Integer antiHistoryType,
                                        @RequestParam(value = "antiHistoryContribution") String antiHistoryContribution,
                                        @RequestParam(value = "antiHistoryState") Integer antiHistoryState,
                                        @RequestParam(value = "antiHistorySite") String antiHistorySite,
                                        @RequestParam(value = "antiHistoryTime") Date antiHistoryTime,
                                        @RequestParam(value = "flag") int Flag,
                                        @RequestParam(value = "sessionPicture") String sessionPicture,
                                        @RequestParam(value = "antiHistoryId")Integer antiHistoryId,
                                        Model model) {
        AntiHistory antiHistory = new AntiHistory();
        antiHistory.setAntiHistoryName(antiHistoryName);
        antiHistory.setAntiHistoryDescription(antiHistoryDescription);
        antiHistory.setAntiHistoryContribution(antiHistoryContribution);
        antiHistory.setAntiHistoryState(antiHistoryState);
        antiHistory.setAntiHistoryType(antiHistoryType);
        antiHistory.setAntiHistoryTime(antiHistoryTime);
        antiHistory.setAntiHistorySite(antiHistorySite);
        antiHistory.setAntiHistoryId(antiHistoryId);
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        antiHistoryContent = sensitiveWordFilter.filterInfo(antiHistoryContent);
        antiHistory.setAntiHistoryContent(antiHistoryContent);
        if (Flag == 0) {
            antiHistory.setAntiHistoryPicture(sessionPicture);
        } else {
            String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
            String originalFilename = antiHistoryPicture.getOriginalFilename();
            String pictureName = RandomUtils.random() + originalFilename;
            //File parentDir = new File(parentDirPath);
            String AntiHistoryPicture = "images" + "\\" + pictureName;
            antiHistory.setAntiHistoryPicture(AntiHistoryPicture);
            try {
                antiHistoryPicture.transferTo(new File(parentDirPath + pictureName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        antiHistoryService.editAntiHistoryUpdate(antiHistory);
        return "redirect:/unit";
    }




}
