package com.it.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.domain.Book;

import java.util.List;

/**
 * 业务层接口
 */
public interface BookService {

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Integer id);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book>getPage(int currentPage,int pageSize);


    IPage<Book> getPage(int currentPage, int pageSize, Book book);
}
