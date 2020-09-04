package com.nchu.anti_japan_history.utils;

public class StringReplace {

    public StringReplace(){
    }
    public String StrReplace(String s){
        String content = "";
        if (s.length() == 0){
            System.out.println("字符串为NULL");
        }
        content = s.replace("&amp;","&");
        content = content.replace("&lt;","<");
        content = content.replace("&gt;",">");
        content = content.replace("&nbsp;"," ");
        content = content.replace("&#39;","\'");
        content = content.replace("&quot;","\"");
        content = content.replace("<br>","\n");
        return content;
    }
}
