package com.nchu.anti_japan_history.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchString {
    private String parent;
    private String child;
    private int count;

    public MatchString(){

    }

    public MatchString(String parent, String child) {
        this.child = child;
        this.parent = parent;
    }

    //方法2、通过正则表达式
    public int matchStringByRegularExpression(String parent, String child) {

        count = 0;
        Pattern p = Pattern.compile(child);
        Matcher m = p.matcher(parent);
        while (m.find()) {
            count++;
            // System.out.println( "匹配项" + count+"：" + m.group() ); //group方法返回由以前匹配操作所匹配的输入子序列。
        }
        //System.out.println( "匹配个数为"+count );                              //结果输出
        return count;
    }
}
