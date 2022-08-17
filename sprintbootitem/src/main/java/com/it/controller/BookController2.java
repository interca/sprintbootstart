package com.it.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.domain.Book;
import com.it.service.BookService;
import com.it.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restful风格
@RestController
@RequestMapping("books")
public class BookController2 {
    @Autowired
   private BookService bookService;

    @GetMapping
    public R getAll(){
        List<Book> all = bookService.getAll();
        return new R(true,bookService.getAll());
    }
    @PostMapping
    public  R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    @PutMapping
    public  R update(@RequestBody Book book){

        return new R(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable int id){

        return new R(bookService.delete(id));
    }


    @GetMapping("/{id}")
    public R getById(@PathVariable int id){

        return new R(true,bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return new R(true ,bookService.getPage(currentPage,pageSize));
    }
}
