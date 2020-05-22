package com.nchu.anti_japan_history.webpage.service;

import com.nchu.anti_japan_history.webpage.entity.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    //查询书籍all
    List<Books> bookListAll();
    //保存书籍
    int bookSave(Books books);
    //书籍信息详细显示
    Books bookDisplay(Long bookId);
    //普通用户查询通过书籍信息
    List<Books> consumerPassBook(String bookContribution);
    //普通用户查询待审核书籍信息
    List<Books> consumerAuditBook(String bookContribution);
    //普通用户查询未通过书籍信息
    List<Books> consumerNotAdoptedBook(String bookContribution);

    //管理员查询通过
    List<Books> adminPassBook();
    //管理员查询待审核
    List<Books> adminAuditBook();
    //管理员查询未通过
    List<Books> adminNotAdoptedBook();

    //删除书籍信息
    int deleteByBookId(Long bookId);

}
