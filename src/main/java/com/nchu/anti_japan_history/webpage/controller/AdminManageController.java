package com.nchu.anti_japan_history.webpage.controller;
/**
 * @Author: wangshen
 * @Date: 2020/5/6
 * @Description: 管理员进行信息管理，用户信息管理，贡献资料审查
 */

import com.nchu.anti_japan_history.utils.RandomUtils;
import com.nchu.anti_japan_history.utils.StringReplace;
import com.nchu.anti_japan_history.webpage.entity.AntiHistory;
import com.nchu.anti_japan_history.webpage.entity.User;
import com.nchu.anti_japan_history.webpage.service.*;
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
    public String ExamineSave(int antiHistoryId,@RequestParam(value = "notAdoptedReason")String notAdoptedReason,
                              @RequestParam(value = "antiHistoryState")int antiHistoryState, Model model){
        AntiHistory antiHistory = new AntiHistory();
        antiHistory.setAntiHistoryId(antiHistoryId);
        antiHistory.setAntiHistoryState(antiHistoryState);
        antiHistory.setNotAdoptedReason(notAdoptedReason);
        antiHistoryService.examineUpdate(antiHistory);
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
    //

}
