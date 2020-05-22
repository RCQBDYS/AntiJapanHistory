package com.nchu.anti_japan_history.webpage.controller;
/**
 * @Author: wangshen
 * @Date: 2020/5/6
 * @Description: 管理员进行信息管理，用户信息管理，贡献资料审查
 */

import com.nchu.anti_japan_history.utils.RandomUtils;
import com.nchu.anti_japan_history.utils.StringReplace;
import com.nchu.anti_japan_history.webpage.entity.*;
import com.nchu.anti_japan_history.webpage.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.bind.v2.runtime.reflect.ListTransducedAccessorImpl;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminManageController {
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
    @Autowired
    UserService userService;

    //配置文件中的图片保存路径
    @Value("${cbs.imagesPath}")
    private String ImagesPath;

    //用户信息关于名称的模糊搜索
    @PostMapping("/searchUser")
    public String SearchUser(String keyWord, Model model) {
        //System.out.println("keyWord="+keyWord);
        List<User> userList = userService.searchByKeyWord(keyWord);
        model.addAttribute("userList", userList);
        model.addAttribute("keyWord", keyWord);
        return "adminCenter";
    }

    //跳转至用户信息修改页面
    @GetMapping("/userMessageEdit")
    public String UserMessageEdit(String userId, Model model) {
        Long UserId = Long.parseLong(userId);
        User userMessage = userService.selectById(UserId);
        model.addAttribute("userMessage", userMessage);
        return "editUserMessage";
    }

    //管理员针对用户修改用户信息保存
    @PostMapping("/userMessageUpdate")
    public String userMessageUpdate(@RequestParam(value = "userPicture") MultipartFile multipartFile,
                                    @RequestParam(value = "userName") String userName,
                                    @RequestParam(value = "userPassword") String userPassword,
                                    @RequestParam(value = "userPower") int userPower,
                                    @RequestParam(value = "flag") int Flag,
                                    @RequestParam(value = "sessionPicture") String sessionPicture,
                                    @RequestParam(value = "userId") int userId, Model model) {
        User user1 = new User();
        user1.setUserName(userName);
        user1.setUserPassword(userPassword);
        user1.setUserId(userId);
        user1.setUserPower(userPower);
        if (Flag == 0) {
            user1.setUserPicture(sessionPicture);
        } else {
            String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
            String originalFilename = multipartFile.getOriginalFilename();
            String pictureName = RandomUtils.random() + originalFilename;
            File parentDir = new File(parentDirPath);
            String userPicture = "images" + "\\" + pictureName;
            user1.setUserPicture(userPicture);
            try {
                //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
                multipartFile.transferTo(new File(parentDirPath + pictureName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //用户信息报存
        userService.update(user1);
        //查询所有用户信息
        List<User> userList = userService.userMessageListAll();
        model.addAttribute("userList", userList);
        return "adminCenter";

    }

    //用户信息删除
    @PostMapping("/userMessageDelete")
    public String UserMessageDelete(String userId, Model model) {
        Long UserId = Long.parseLong(userId);
        userService.deleteById(UserId);
        List<User> userList = userService.userMessageListAll();
        model.addAttribute("userList", userList);
        return "adminCenter";
    }


    //历史条目审查页面概览
    @RequestMapping("/examineAntiHistory")
    public String skipExamineAntiHistory(Model model) {
        //显示已通过的历史条目
        List<AntiHistory> antiHistoryPastList = antiHistoryService.antiHistoryPastListAll();
        //显示待审核的历史条目
        List<AntiHistory> antiHistoryAuditList = antiHistoryService.antiHistoryAuditListAll();
        //显示未通过的历史条目
        List<AntiHistory> antiHistoryListNotAdoptedList = antiHistoryService.antiHistoryNotAdoptedListAll();
        model.addAttribute("antiHistoryListNotAdoptedList", antiHistoryListNotAdoptedList);
        model.addAttribute("antiHistoryPastList", antiHistoryPastList);
        model.addAttribute("antiHistoryAuditList", antiHistoryAuditList);
        return "examineAntiHistory";
    }

    //历史条目审查具体页面跳转
    @GetMapping("/examineInAntiHistory")
    public String skipExamineInAntiHistory(String antiHistoryId, Model model) {
        Long AntiHistoryId = Long.parseLong(antiHistoryId);
        AntiHistory antiHistoryMessage = antiHistoryService.selectHistoryDisplay(AntiHistoryId);
        String content = antiHistoryMessage.getAntiHistoryContent();
        StringReplace stringReplace = new StringReplace();
        content = stringReplace.StrReplace(content);
        antiHistoryMessage.setAntiHistoryContent(content);
        model.addAttribute("antiHistoryMessage", antiHistoryMessage);
        return "examineInAntiHistory";
    }

    //管理员审核意见保存
    @PostMapping("/examineSave")
    public String ExamineSave(int antiHistoryId, @RequestParam(value = "notAdoptedReason") String notAdoptedReason,
                              @RequestParam(value = "antiHistoryState") int antiHistoryState,
                              @RequestParam(value = "antiHistoryContribution") String antiHistoryContribution,
                              Model model) {
        AntiHistory antiHistory = new AntiHistory();
        antiHistory.setAntiHistoryId(antiHistoryId);
        antiHistory.setAntiHistoryState(antiHistoryState);
        antiHistory.setNotAdoptedReason(notAdoptedReason);
        antiHistoryService.examineUpdate(antiHistory);
        User user = userService.userMessage(antiHistoryContribution);
        int power = user.getUserPower();
        if (power == 0) {
            if (antiHistoryState == 2) {
                int core = user.getUserPoint();
                int number = user.getNumber();
                number += 1;
                if (number == 20) {
                    user.setUserPower(2);
                    userService.powerUpdate(user);
                }
                core += 7;
                user.setNumber(number);
                user.setUserPoint(core);
                user.setUserName(antiHistoryContribution);
                userService.coreUpdate(user);
            }
        } else {
            int number = user.getNumber();
            number += 1;
            user.setNumber(number);
            userService.numberUpdate(user);
        }
        return "redirect:/examineAntiHistory";
    }

    //管理员删除历史条目
    @PostMapping("/deleteAntiHistory")
    public String DeleteAntiHistory(Long antiHistoryId, Model model) {
        antiHistoryService.deleteByAntiHistoryId(antiHistoryId);
        return "redirect:/examineAntiHistory";
    }


    //历史人物审查概览页面跳转
    @GetMapping("/examineAntiPerson")
    public String skipExamineAntiPerson(Model model) {
        //通过的信息
        List<AntiJapanPerson> antiPersonPass = antiJapanPersonService.adminPassPerson();
        //待审核的信息
        List<AntiJapanPerson> antiPersonAudit = antiJapanPersonService.adminAuditPerson();
        //未通过的信息
        List<AntiJapanPerson> antiPersonNotAdopted = antiJapanPersonService.adminNotAdoptedPerson();
        model.addAttribute("antiPersonPass", antiPersonPass);
        model.addAttribute("antiPersonAudit", antiPersonAudit);
        model.addAttribute("antiPersonNotAdopted", antiPersonNotAdopted);
        return "examineAntiPerson";
    }

    //删除历史人物
    @PostMapping("/deleteAntiPerson")
    public String DeleteAntiPerson(Long antiJapanPersonId) {
        antiJapanPersonService.deleteByPersonId(antiJapanPersonId);
        return "redirect:/examineAntiPerson";
    }

    //评审历史人物信息
    @GetMapping("/examineInPerson")
    public String ExamineInPerson(Long antiJapanPersonId, Model model) {
        AntiJapanPerson antiJapanPersonDisplay = antiJapanPersonService.antiPersonDisplay(antiJapanPersonId);
        String content = antiJapanPersonDisplay.getContent();
        StringReplace stringReplace = new StringReplace();
        content = stringReplace.StrReplace(content);
        antiJapanPersonDisplay.setContent(content);
        model.addAttribute("antiJapanPersonDisplay", antiJapanPersonDisplay);
        return "examineInAntiPerson";
    }

    //历史人物评审内容保存
    @PostMapping("/examinePersonSave")
    public String ExaminePersonSave(int antiJapanPersonId,
                                    @RequestParam(value = "personState") int personState,
                                    @RequestParam(value = "personNotReason") String personNotReason) {
        AntiJapanPerson antiJapanPerson = new AntiJapanPerson();
        antiJapanPerson.setAntiJapanPersonId(antiJapanPersonId);
        antiJapanPerson.setPersonState(personState);
        antiJapanPerson.setPersonNotReason(personNotReason);
        antiJapanPersonService.examinePersonUpdate(antiJapanPerson);
        return "redirect:/examineAntiPerson";
    }


    //抗战故事审核概览
    @GetMapping("/examineAntiStories")
    public String ExamineAntiStories(Model model) {

        //通过
        List<AntiWarStories> antiWarStoriesPass = antiWarStoriesService.adminPassStories();
        //待审核
        List<AntiWarStories> antiWarStoriesAudit = antiWarStoriesService.adminAuditStories();
        //未通过
        List<AntiWarStories> antiWarStoriesNotAdopted = antiWarStoriesService.adminNotAdoptedStories();

        model.addAttribute("antiWarStoriesPass", antiWarStoriesPass);
        model.addAttribute("antiWarStoriesAudit", antiWarStoriesAudit);
        model.addAttribute("antiWarStoriesNotAdopted", antiWarStoriesNotAdopted);

        return "examineAntiStories";
    }

    //抗战故事的删除
    @PostMapping("/deleteStories")
    public String DeleteStories(Long antiWarId) {
        antiWarStoriesService.deleteByStoriesId(antiWarId);
        return "redirect:/examineAntiStories";
    }


    //抗战故事的审核
    @GetMapping("/examineInStories")
    public String ExamineInStories(Long antiWarId, Model model) {
        AntiWarStories antiWarStoriesDisplay = antiWarStoriesService.antiStoriesDisplay(antiWarId);
        String content = antiWarStoriesDisplay.getStoriesContent();
        StringReplace stringReplace = new StringReplace();
        content = stringReplace.StrReplace(content);
        antiWarStoriesDisplay.setStoriesContent(content);
        //System.out.println("id="+antiWarStoriesDisplay.getAntiWarId());
        model.addAttribute("antiWarStoriesDisplay", antiWarStoriesDisplay);
        return "examineInAntiStories";
    }

    //故事的审核信息保存
    @PostMapping("/examineStoriesSave")
    public String ExamineStoriesSave(int antiWarId,
                                     @RequestParam(value = "storiesState") int storiesState,
                                     @RequestParam(value = "storiesNotReason") String storiesNotReason) {
        AntiWarStories antiWarStories = new AntiWarStories();
        antiWarStories.setStoriesState(storiesState);
        antiWarStories.setStoriesNotReason(storiesNotReason);
        antiWarStories.setAntiWarId(antiWarId);
        antiWarStoriesService.examineStoriesSave(antiWarStories);
        return "redirect:/examineAntiStories";
    }

    //抗战遗址信息审核概览
    @GetMapping("/examineAntiSite")
    public String ExamineAntiSite(Model model) {
        //通过
        List<AntiSite> antiSitesPass = antiSiteService.adminPassSite();
        //待审核
        List<AntiSite> antiSitesAudit = antiSiteService.adminAuditSite();
        //未通过
        List<AntiSite> antiSitesNotAdopted = antiSiteService.adminNotAdoptSite();

        model.addAttribute("antiSitesPass", antiSitesPass);
        model.addAttribute("antiSitesAudit", antiSitesAudit);
        model.addAttribute("antiSitesNotAdopted", antiSitesNotAdopted);

        return "examineAntiSite";
    }

    //抗战遗址删除
    @PostMapping("/deleteSite")
    public String DeleteSite(Long antiSiteId) {
        antiSiteService.deleteByAntiSiteId(antiSiteId);
        return "redirect:/examineAntiSite";
    }

    //抗战遗址审核页面
    @GetMapping("/examineInSite")
    public String ExamineInSite(Model model, Long antiSiteId) {
        AntiSite antiSiteDisplay = antiSiteService.antiSiteDisplay(antiSiteId);
        model.addAttribute("antiSiteDisplay", antiSiteDisplay);
        return "examineInAntiSite";
    }

    //抗战遗址审核信息保存
    @PostMapping("/examineSiteSave")
    public String ExamineSiteSave(@RequestParam(value = "antiSiteState") int antiSiteState,
                                  @RequestParam(value = "antiSiteNotReason") String antiSiteNotReason,
                                  int antiSiteId) {
        AntiSite antiSite = new AntiSite();
        antiSite.setAntiSiteState(antiSiteState);
        antiSite.setAntiSiteNotReason(antiSiteNotReason);
        antiSite.setAntiSiteId(antiSiteId);
        antiSiteService.examineSiteUpdate(antiSite);
        return "redirect:/examineAntiSite";
    }


    //国际友人审核概览
    @GetMapping("/examineFriend")
    public String ExamineFriend(Model model) {
        List<InternationalFriend> friendsPass = internationalFriendService.adminPassFriend();
        List<InternationalFriend> friendsAudit = internationalFriendService.adminAuditFriend();
        List<InternationalFriend> friendsNotAdopted = internationalFriendService.adminNotAdoptedFriend();
        model.addAttribute("friendsPass", friendsPass);
        model.addAttribute("friendsAudit", friendsAudit);
        model.addAttribute("friendsNotAdopted", friendsNotAdopted);
        return "examineFriend";
    }

    //国际友人信息的删除
    @PostMapping("/deleteFriend")
    public String DeleteFriend(Long internationalFriendId) {
        internationalFriendService.deleteByFriendId(internationalFriendId);
        return "redirect:/examineFriend";
    }

    //国际友人审核信息
    @GetMapping("/examineInFriend")
    public String ExamineInFriend(Model model, Long internationalFriendId) {
        InternationalFriend internationalFriendDisplay = internationalFriendService.internationalFriendDisplay(internationalFriendId);
        model.addAttribute("internationalFriendDisplay", internationalFriendDisplay);
        return "examineInFriend";
    }

    //国际友人信息审核
    @PostMapping("/examineFriendSave")
    public String ExamineFriendSave(@RequestParam(value = "friendState") int friendState,
                                    @RequestParam(value = "friendNotReason") String friendNotReason,
                                    int internationalFriendId) {
        InternationalFriend internationalFriend = new InternationalFriend();
        internationalFriend.setInternationalFriendId(internationalFriendId);
        internationalFriend.setFriendState(friendState);
        internationalFriend.setFriendNotReason(friendNotReason);
        internationalFriendService.examineFriendUpdate(internationalFriend);
        return "redirect:/examineFriend";
    }

    //图片审核页面
    @GetMapping("/examinePicture")
    public String ExaminePicture(Model model) {
        List<Picture> picturesPass = pictureService.adminPassPicture();
        List<Picture> picturesAudit = pictureService.adminAuditPicture();
        List<Picture> picturesNotAdopted = pictureService.adminNotAdoptedPicture();
        model.addAttribute("picturesPass", picturesPass);
        model.addAttribute("picturesAudit", picturesAudit);
        model.addAttribute("picturesNotAdopted", picturesNotAdopted);
        return "examinePicture";
    }

    //图片信息删除
    @PostMapping("/deletePicture")
    public String DeletePicture(Long pictureId) {
        pictureService.deleteByPictureId(pictureId);
        return "redirect:/examinePicture";
    }

    //图片信息审核
    @GetMapping("/examineInPicture")
    public String ExamineInPicture(Long pictureId, Model model) {
        Picture pictureDisplay = pictureService.pictureDisplay(pictureId);
        model.addAttribute("pictureDisplay", pictureDisplay);
        return "examineInPicture";
    }

    //图片审核信息保存
    @PostMapping("/examinePictureSave")
    public String ExaminePictureSave(@RequestParam(value = "pictureState") int pictureState,
                                     @RequestParam(value = "pictureNotReason") String pictureNotReason,
                                     int pictureId) {
        Picture picture = new Picture();
        picture.setPictureState(pictureState);
        picture.setPictureNotReason(pictureNotReason);
        picture.setPictureId(pictureId);
        pictureService.examinePictureUpdate(picture);
        return "redirect:/examinePicture";
    }

    //期刊审核概览
    @GetMapping("/examinePeriodical")
    public String ExamineNews(Model model) {
        List<Periodical> periodicalsPass = periodicalService.adminPassPeriodical();
        List<Periodical> periodicalsAudit = periodicalService.adminAuditPeriodical();
        List<Periodical> periodicalsNotAdopted = periodicalService.adminNotAdoptedPeriodical();
        model.addAttribute("periodicalsPass", periodicalsPass);
        model.addAttribute("periodicalsAudit", periodicalsAudit);
        model.addAttribute("periodicalsNotAdopted", periodicalsNotAdopted);
        return "examinePeriodical";
    }


}
