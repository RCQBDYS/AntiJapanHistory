package com.nchu.anti_japan_history.config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    //配置的路径、图片、视频、音频
    @Value("${cbs.imagesPath}")
    private String ImagesPath;

    @Value("${cbs.videoPath}")
    private  String VideoPath;

    @Value("${cbs.musicPath}")
    private  String MusicPath;

    //对图片的上传进行路径的配置，并设置项目在运行时能够对访问配置路径的下的文件
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        /*if (ImagesPath.equals("")||ImagesPath.equals("${cbs.imagesPath}")){
            String imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
            if (imagesPath.indexOf(".jar")>0){
                imagesPath = imagesPath.substring(0,imagesPath.indexOf(".jar"));

            }else if(imagesPath.indexOf("classes")>0){
                imagesPath = "file:"+imagesPath.substring(0,imagesPath.indexOf("classes"));

            }
            imagesPath = imagesPath.substring(0,imagesPath.lastIndexOf("/"))+"/images/";
            ImagesPath = imagesPath;
        }
        LoggerFactory.getLogger(WebAppConfig.class).info("imagesPath=" + ImagesPath);*/
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/images/**").addResourceLocations("file:F:/Resource/images/");
    }



}
