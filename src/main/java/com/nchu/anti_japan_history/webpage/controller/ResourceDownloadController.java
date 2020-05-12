package com.nchu.anti_japan_history.webpage.controller;

import com.nchu.anti_japan_history.webpage.service.BookService;
import com.nchu.anti_japan_history.webpage.service.NewspaperService;
import com.nchu.anti_japan_history.webpage.service.PeriodicalService;
import com.nchu.anti_japan_history.webpage.service.PictureService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
*@Author: wangshen
*@Date: 2020/5/12
*@Description: 文件资源的下载控制类
*/


@Controller
public class ResourceDownloadController {
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

    @RequestMapping("/pictureDownload")
    public void PictureDownload(String pictureName, HttpServletResponse response) throws IOException {
        //二进制数据文件
        response.setContentType("application/octet-stream");
        //获取图片名称
        String str = pictureName.substring(0,pictureName.indexOf("s"));
        String PictureName = pictureName.substring(str.length()+2,pictureName.length());
        //System.out.println(PictureName);
        response.setHeader("Content-Disposition", "attachment; filename=" + new String(PictureName.getBytes("gb2312"), "ISO8859-1"));
        //获取文件路径
        String filePath = ImagesPath.substring(ImagesPath.indexOf(':') + 1, ImagesPath.length())+PictureName;
        System.out.println("filePath="+filePath);
        File file = new File(filePath);
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream os = response.getOutputStream();
        IOUtils.copy(is, os);
        //刷新输出流
        os.flush();
        //关闭输入输出流
        os.close();
        is.close();
    }
}
