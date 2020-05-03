package com.nchu.anti_japan_history.webpage.mapper;

import com.nchu.anti_japan_history.webpage.entity.Books;

import java.util.List;

public interface BookMapper {
    //查询书籍all
    List<Books> bookListAll();
    //保存书籍
    int bookSave(Books books);
}
