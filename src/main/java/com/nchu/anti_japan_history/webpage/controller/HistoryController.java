package com.nchu.anti_japan_history.webpage.controller;

import com.nchu.anti_japan_history.utils.MatchString;
import com.nchu.anti_japan_history.utils.RandomUtils;
import com.nchu.anti_japan_history.utils.SensitiveWordFilter;
import com.nchu.anti_japan_history.webpage.entity.AntiHistory;
import com.nchu.anti_japan_history.webpage.service.AntiHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

/**
 * @Author: wangshen
 * @Date: 2020/4/6
 * @Description: 抗战历史控制类
 */
@Controller
public class HistoryController {
    //日志
    Logger logger = LoggerFactory.getLogger(indexController.class);
    @Autowired
    AntiHistoryService antiHistoryService;

    //配置文件中的图片保存路径
    @Value("${cbs.imagesPath}")
    private String ImagesPath;

    /*
     * 局部、全国、伟大胜利等历史信息的纤细显示
     * */
    @GetMapping("/historyDetails")
    public String skipHistoryDetails() {
        return "historyDetails";
    }

    /*
    * 跳转至条目的添加
    * */
    @GetMapping("/addEntries")
    public String skipAddEntries(){
        return "addEntries";
    }

    /*
    * 添加历史事件，在添加的数据中有图片文件，
    * 因此无法单纯使用实体类进行数据的映射
    * */
    @PostMapping("/addEntriesData")
    public String addEntriesData(@RequestParam(value = "antiHistoryName")String antiHistoryName,
                                 @RequestParam(value = "antiHistoryDescription")String antiHistoryDescription,
                                 @RequestParam(value = "antiHistoryPicture")MultipartFile antiHistoryPicture,
                                 @RequestParam(value = "antiHistoryContent")String antiHistoryContent,
                                 @RequestParam(value = "specialTopicId")Integer specialTopicId,
                                 @RequestParam(value = "antiHistoryContribution")String antiHistoryContribution,
                                 @RequestParam(value = "antiHistoryState")Integer antiHistoryState,
                                 @RequestParam(value = "antiHistorySite")String antiHistorySite,
                                 @RequestParam(value = "antiHistoryTime") Date antiHistoryTime){
        AntiHistory antiHistory = new AntiHistory();
        antiHistory.setAntiHistoryName(antiHistoryName);
        antiHistory.setAntiHistoryDescription(antiHistoryDescription);
        antiHistory.setAntiHistoryContribution(antiHistoryContribution);
        antiHistory.setAntiHistoryState(antiHistoryState);
        antiHistory.setAntiHistoryType(specialTopicId);
        antiHistory.setAntiHistoryTime(antiHistoryTime);
        antiHistory.setAntiHistorySite(antiHistorySite);
        //进行敏感词汇过滤，铭感词汇替换成
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        //System.out.println("被检测字符长度="+antiHistoryContent.length());
        antiHistoryContent = sensitiveWordFilter.filterInfo(antiHistoryContent);
        MatchString matchString = new MatchString();
        String child = "\\*";
        int count = matchString.matchStringByRegularExpression(antiHistoryContent,child);
        System.out.println(count);
        //System.out.println("过滤之后的Content="+antiHistoryContent);
        //logger.info("替换后的内容：" + antiHistoryContent);
        antiHistory.setAntiHistoryContent(antiHistoryContent);
        int flag = 0;
        //通过对imagesPath路径的截取，以获得图片存储的文件路径
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        //logger.info("parentDirPath=" + parentDirPath);
        //获取图片名称
        String originalFilename = antiHistoryPicture.getOriginalFilename();
        //logger.info("originalFilename=" + originalFilename);
        //生成随机图片前缀+图片名称
        String pictureName = RandomUtils.random() + originalFilename;
        //logger.info("fileName=" + pictureName);
        //将路径转变为文件存储路径格式
        File parentDir = new File(parentDirPath);
        //图片的访问路径
        String AntiHistoryPicture = "images" +"\\"+ pictureName;
        antiHistory.setAntiHistoryPicture(AntiHistoryPicture);
        //logger.info("parentDir = " + parentDir);
        //logger.info("userPicture = " + userPicture);

        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            antiHistoryPicture.transferTo(new File(parentDirPath + pictureName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }

        //通过flag来判断图片文件是否复制成功
        if (flag == 0) {
            logger.info("");
            return "addEntries";
        } else {
            antiHistoryService.addEntriesDataSave(antiHistory);
            return "index";
        }

    }

}
