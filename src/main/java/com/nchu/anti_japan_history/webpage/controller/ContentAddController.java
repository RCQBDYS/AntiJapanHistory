package com.nchu.anti_japan_history.webpage.controller;

import com.nchu.anti_japan_history.utils.RandomUtils;
import com.nchu.anti_japan_history.utils.SensitiveWordFilter;
import com.nchu.anti_japan_history.webpage.entity.*;
import com.nchu.anti_japan_history.webpage.service.*;
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
 * @Date: 2020/4/22
 * @Description: 负责除历史条目，其他内容页面的跳转以及添加
 */

@Controller
public class ContentAddController {

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


    //配置文件中的图片保存路径
    @Value("${cbs.imagesPath}")
    private String ImagesPath;

    //书籍PDF存储路径
    @Value("${cbs.pdf}")
    private String pdfPath;

    //抗战人物添加页面的跳转
    @GetMapping("/addAntiPerson")
    public String skipAddAntiPerson() {
        return "addAntiPerson";
    }

    //抗战遗址添加页面的跳转
    @GetMapping("/addAntiSite")
    public String skipAddAntiSite() {
        return "addAntiSite";
    }

    //抗战故事添加页面的跳转
    @GetMapping("/addAntiStories")
    public String skipAddAntiStories() {
        return "addAntiStories";
    }

    //书籍资料添加页面的跳转
    @GetMapping("/addBook")
    public String skipAddBook() {
        return "addBook";
    }

    //国际友人添加页面的跳转
    @GetMapping("/addInternationalFriend")
    public String skipAddInternationalFriend() {
        return "addInternationalFriend";
    }

    //报纸资料添加页面的跳转
    @GetMapping("/addNewspaper")
    public String skipAddNewspaper() {
        return "addNewspaper";
    }

    //期刊资料添加页面的跳转
    @GetMapping("/addPeriodical")
    public String skipAddPeriodical() {
        return "addPeriodical";
    }
    //图片资料添加页面的跳转
    @GetMapping("/addPicture")
    public String skipAddPicture(){
        return "addPicture";
    }

    //抗战人物信息的保存
    @PostMapping("/antiPersonSave")
    public String AntiPersonSave(@RequestParam(value = "personName")String personName,
                                 @RequestParam(value = "personPicture")MultipartFile personPicture,
                                 @RequestParam(value = "timeQuantum")String timeQuantum,
                                 @RequestParam(value = "content")String content,
                                 @RequestParam(value = "personState")Integer personState,
                                 @RequestParam(value = "personContribution")String personContribution){
        //进行内容的敏感词汇过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        content = sensitiveWordFilter.filterInfo(content);

        //上传图片
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        String originalFilename = personPicture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String PersonPicture = "images" +"\\"+ pictureName;
        //将数据导入实体类
        AntiJapanPerson antiJapanPerson = new AntiJapanPerson();
        antiJapanPerson.setPersonName(personName);
        antiJapanPerson.setPersonPicture(PersonPicture);
        antiJapanPerson.setContent(content);
        antiJapanPerson.setPersonContribution(personContribution);
        antiJapanPerson.setPersonState(personState);
        antiJapanPerson.setTimeQuantum(timeQuantum);
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            personPicture.transferTo(new File(parentDirPath + pictureName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }
        if (flag == 0) {
            logger.info("");
            return "addAntiPerson";
        } else {
            antiJapanPersonService.antiPersonSave(antiJapanPerson);
            return "index";
        }
    }

    //抗战博物馆信息添加
    @PostMapping("/antiSiteSave")
    public String AntiSiteSave(@RequestParam(value = "antiSiteName")String antiSiteName,
                               @RequestParam(value = "antiSitePicture")MultipartFile antiSitePicture,
                               @RequestParam(value = "exhibitions")String exhibitions,
                               @RequestParam(value = "collections")String collections,
                               @RequestParam(value = "address")String address,
                               @RequestParam(value = "url")String url,
                               @RequestParam(value = "antiSiteState")Integer antiSiteState,
                               @RequestParam(value = "antiSiteContribution")String antiSiteContribution){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        String originalFilename = antiSitePicture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String AntiSitePicture = "images" +"\\"+ pictureName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        antiSiteName = sensitiveWordFilter.filterInfo(antiSiteName);
        exhibitions = sensitiveWordFilter.filterInfo(exhibitions);
        collections = sensitiveWordFilter.filterInfo(collections);
        //数据的填充
        AntiSite antiSite = new AntiSite();
        antiSite.setAntiSiteName(antiSiteName);
        antiSite.setAntiSitePicture(AntiSitePicture);
        antiSite.setExhibitions(exhibitions);
        antiSite.setCollections(collections);
        antiSite.setAddress(address);
        antiSite.setUrl(url);
        antiSite.setAntiSiteState(antiSiteState);
        antiSite.setAntiSiteContribution(antiSiteContribution);

        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            antiSitePicture.transferTo(new File(parentDirPath + pictureName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }
        if (flag == 0) {
            logger.info("");
            return "addAntiSite";
        } else {
            antiSiteService.antiSiteSave(antiSite);
            return "index";
        }
    }

    //抗战故事的保存
    @PostMapping("/antiStoriesSave")
    public String AntiStoriesSave(@RequestParam(value = "title")String title,
                                  @RequestParam(value = "storiesPicture")MultipartFile storiesPicture,
                                  @RequestParam(value = "storiesContent")String storiesContent,
                                  @RequestParam(value = "storiesContribution")String storiesContribution,
                                  @RequestParam(value = "storiesState")Integer storiesState){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        String originalFilename = storiesPicture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String StoriesPicture = "images" +"\\"+ pictureName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        title = sensitiveWordFilter.filterInfo(title);
        storiesContent = sensitiveWordFilter.filterInfo(storiesContent);
        //数据的填充
        AntiWarStories antiWarStories = new AntiWarStories();
        antiWarStories.setTitle(title);
        antiWarStories.setStoriesContent(storiesContent);
        antiWarStories.setStoriesPicture(StoriesPicture);
        antiWarStories.setStoriesContribution(storiesContribution);
        antiWarStories.setStoriesState(storiesState);
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            storiesPicture.transferTo(new File(parentDirPath + pictureName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }
        if (flag == 0) {
            return "addAntiStories";
        } else {
            antiWarStoriesService.antiStoriesSave(antiWarStories);
            return "index";
        }
    }

    //国际友人信息的保存
    @PostMapping("/friendSave")
    public String FriendSave(@RequestParam(value = "name")String name,
                             @RequestParam(value = "achievement")String achievement,
                             @RequestParam(value = "picture")MultipartFile picture,
                             @RequestParam(value = "friendState")Integer friendState,
                             @RequestParam(value = "friendContribution")String friendContribution){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        String originalFilename = picture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String Picture = "images" +"\\"+ pictureName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        name = sensitiveWordFilter.filterInfo(name);
        achievement = sensitiveWordFilter.filterInfo(achievement);
        //数据的导入
        InternationalFriend internationalFriend = new InternationalFriend();
        internationalFriend.setName(name);
        internationalFriend.setAchievement(achievement);
        internationalFriend.setFriendContribution(friendContribution);
        internationalFriend.setFriendState(friendState);
        internationalFriend.setPicture(Picture);
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            picture.transferTo(new File(parentDirPath + pictureName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }
        if (flag == 0) {
            return "addInternationalFriend";
        } else {
            internationalFriendService.internationalFriendSave(internationalFriend);
            return "index";
        }
    }

    //书籍信息保存
    @PostMapping("/bookSave")
    public String BookSave(@RequestParam(value = "bookName")String bookName,
                           @RequestParam(value = "bookPicture")MultipartFile bookPicture,
                           @RequestParam(value = "bookAuthor")String bookAuthor,
                           @RequestParam(value = "publicationTime") Date publicationTime,
                           @RequestParam(value = "publishingCompany")String publishingCompany,
                           @RequestParam(value = "briefIntroduction")String briefIntroduction,
                           @RequestParam(value = "bookState")Integer bookState,
                           @RequestParam(value = "bookContribution")String bookContribution,
                           @RequestParam(value = "bookPath")MultipartFile bookPath){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        //System.out.println("parentDirPath"+ parentDirPath);
        String originalFilename = bookPicture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String Picture = "images" +"\\"+ pictureName;
        //处理书籍文件存储
        String fileDirPath = pdfPath.substring(pdfPath.indexOf(':')+1,pdfPath.length());
        //System.out.println("fileDirPath:" + fileDirPath);
        String fileOriginalName = bookPath.getOriginalFilename();
        //System.out.println("fileOriginalName"+ fileOriginalName);
        File fileParentDir = new File(fileDirPath);
        String BookPath = "pdf" + "\\" + fileOriginalName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        bookName = sensitiveWordFilter.filterInfo(bookName);
        bookAuthor = sensitiveWordFilter.filterInfo(bookAuthor);
        publishingCompany = sensitiveWordFilter.filterInfo(publishingCompany);
        briefIntroduction = sensitiveWordFilter.filterInfo(briefIntroduction);
        //数据的填充
        Books books = new Books();
        books.setBookName(bookName);
        books.setBookAuthor(bookAuthor);
        books.setBookContribution(bookContribution);
        books.setBookState(bookState);
        books.setBriefIntroduction(briefIntroduction);
        books.setPublicationTime(publicationTime);
        books.setPublishingCompany(publishingCompany);
        books.setBookPicture(Picture);
        books.setBookPath(BookPath);
        //进行文件拷贝
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        if(!fileParentDir.exists()){
            fileParentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            bookPicture.transferTo(new File(parentDirPath + pictureName));
            bookPath.transferTo(new File(fileDirPath+fileOriginalName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }

        if (flag == 0) {
            return "addBook";
        } else {
            bookService.bookSave(books);
            return "index";
        }

    }

    //报纸信息保存
    @PostMapping("/newspaperSave")
    public String NewspaperSave(@RequestParam(value = "newspaperName")String newspaperName,
                                @RequestParam(value = "newspaperPicture")MultipartFile newspaperPicture,
                                @RequestParam(value = "newspaperPath")MultipartFile newspaperPath,
                                @RequestParam(value = "principalPerson")String principalPerson,
                                @RequestParam(value = "publishing") String publishing,
                                @RequestParam(value = "placeOfPublication")String placeOfPublication,
                                @RequestParam(value = "publicationTime")Date publicationTime,
                                @RequestParam(value = "newspaperState")Integer newspaperState,
                                @RequestParam(value = "newspaperContribution")String newspaperContribution){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        //System.out.println("parentDirPath"+ parentDirPath);
        String originalFilename = newspaperPicture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String Picture = "images" +"\\"+ pictureName;
        //处理期刊文件存储
        String fileDirPath = pdfPath.substring(pdfPath.indexOf(':')+1,pdfPath.length());
        String fileOriginalName = newspaperPath.getOriginalFilename();
        File fileParentDir = new File(fileDirPath);
        String NewspaperPath = "pdf" + "\\" + fileOriginalName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        newspaperName = sensitiveWordFilter.filterInfo(newspaperName);
        principalPerson = sensitiveWordFilter.filterInfo(principalPerson);
        publishing = sensitiveWordFilter.filterInfo(publishing);
        placeOfPublication = sensitiveWordFilter.filterInfo(placeOfPublication);
        //数据填充
        Newspaper newspaper = new Newspaper();
        newspaper.setNewspaperContribution(newspaperContribution);
        newspaper.setNewspaperName(newspaperName);
        newspaper.setNewspaperPicture(Picture);
        newspaper.setNewspaperState(newspaperState);
        newspaper.setPlaceOfPublication(placeOfPublication);
        newspaper.setPrincipalPerson(principalPerson);
        newspaper.setPublicationTime(publicationTime);
        newspaper.setPublishing(publishing);
        newspaper.setNewspaperPath(NewspaperPath);
        //文件复制
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        if(!fileParentDir.exists()){
            fileParentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            newspaperPicture.transferTo(new File(parentDirPath + pictureName));
            newspaperPath.transferTo(new File(fileDirPath+fileOriginalName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }

        if (flag == 0) {
            return "addNewspaper";
        } else {
            newspaperService.newspaperSave(newspaper);
            return "index";
        }
    }

    //期刊文件的保存
    @PostMapping("/periodicalSave")
    public String PeriodicalSave(@RequestParam(value = "periodicalName")String periodicalName,
                                 @RequestParam(value = "periodicalPicture")MultipartFile periodicalPicture,
                                 @RequestParam(value = "periodicalPath")MultipartFile periodicalPath,
                                 @RequestParam(value = "publishingCompany")String publishingCompany,
                                 @RequestParam(value = "sponsorPerson")String sponsorPerson,
                                 @RequestParam(value = "periodicalState")Integer periodicalState,
                                 @RequestParam(value = "periodicalContribution")String periodicalContribution){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        //System.out.println("parentDirPath"+ parentDirPath);
        String originalFilename = periodicalPicture.getOriginalFilename();
        String pictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String PeriodicalPicture = "images" +"\\"+ pictureName;
        //处理期刊文件存储
        String fileDirPath = pdfPath.substring(pdfPath.indexOf(':')+1,pdfPath.length());
        String fileOriginalName = periodicalPath.getOriginalFilename();
        File fileParentDir = new File(fileDirPath);
        String PeriodicalPath = "pdf" + "\\" + fileOriginalName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        periodicalName = sensitiveWordFilter.filterInfo(periodicalName);
        publishingCompany = sensitiveWordFilter.filterInfo(publishingCompany);
        sponsorPerson = sensitiveWordFilter.filterInfo(sponsorPerson);
        //数据的导入
        Periodical periodical = new Periodical();
        periodical.setPeriodicalContribution(periodicalContribution);
        periodical.setPeriodicalName(periodicalName);
        periodical.setPeriodicalPath(PeriodicalPath);
        periodical.setPeriodicalPicture(PeriodicalPicture);
        periodical.setPeriodicalState(periodicalState);
        periodical.setPublishingCompany(publishingCompany);
        periodical.setSponsorPerson(sponsorPerson);
        //文件复制
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        if(!fileParentDir.exists()){
            fileParentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            periodicalPicture.transferTo(new File(parentDirPath + pictureName));
            periodicalPath.transferTo(new File(fileDirPath+fileOriginalName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }

        if (flag == 0) {
            return "addPeriodical";
        } else {
            periodicalService.periodicalSave(periodical);
            return "index";
        }

    }

    //图片信息保存
    @PostMapping("/pictureSave")
    public String PictureSave(@RequestParam(value = "pictureName")String pictureName,
                              @RequestParam(value = "pictureWay")MultipartFile pictureWay,
                              @RequestParam(value = "pictureDescription")String pictureDescription,
                              @RequestParam(value = "pictureState")Integer pictureState,
                              @RequestParam(value = "pictureContribution") String pictureContribution){
        //处理图片的存储
        String parentDirPath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length());
        //System.out.println("parentDirPath"+ parentDirPath);
        String originalFilename = pictureWay.getOriginalFilename();
        String PictureName = RandomUtils.random() + originalFilename;
        File parentDir = new File(parentDirPath);
        String Picture = "images" +"\\"+ PictureName;
        //内容的过滤
        SensitiveWordFilter sensitiveWordFilter = new SensitiveWordFilter("CensorWords.txt");
        sensitiveWordFilter.InitializationWork();
        pictureDescription = sensitiveWordFilter.filterInfo(pictureDescription);
        pictureName = sensitiveWordFilter.filterInfo(pictureName);
        //数据填充
        Picture picture = new Picture();
        picture.setPictureContribution(pictureContribution);
        picture.setPictureDescription(pictureDescription);
        picture.setPictureName(pictureName);
        picture.setPictureState(pictureState);
        picture.setPictureWay(Picture);
        //文件复制
        int flag = 0;
        if (!parentDir.exists()) //如果那个目录不存在先创建目录
        {
            parentDir.mkdir();
        }
        try {
            //全局配置文件中配置的目录加上文件名,将用户选择的图片，写入磁盘中
            pictureWay.transferTo(new File(parentDirPath + PictureName));
            flag = 1;
        } catch (IOException e) {
            flag = 0;
            e.printStackTrace();
        }

        if (flag == 0) {
            return "addPeriodical";
        } else {
            pictureService.pictureSave(picture);
            return "index";
        }

    }
}
