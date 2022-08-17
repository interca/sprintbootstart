package com.it.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.domain.Book;
import com.it.service.BookService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restful风格
//@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
   private BookService bookService;

    @GetMapping
    public List<Book>getAll(){
        List<Book> all = bookService.getAll();
        return all;
    }
    @PostMapping
    public  boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public  boolean update(@RequestBody Book book){
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return bookService.delete(id);
    }


    @GetMapping("/{id}")
    public  Book getById(@PathVariable int id){
      return bookService.getById(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book>getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }
}
