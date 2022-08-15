package com.it;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.it.domain.Book;
import com.it.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private  BookService bookService;
    @Test
    public  void test1(){
        System.out.println(bookService.getById(1));
    }

    @Test
    void test2(){
        List<Book> all = bookService.getAll();
        for(Book a:all){
            System.out.println(a);
        }
    }

    @Test
    void test3(){
        Book book=new Book();
        book.setName("算法和数据结构");
        book.setType("技术");
        book.setDescription("学习算法和数据结构");
        System.out.println(bookService.save(book));
    }

    @Test
    void test4(){
        IPage<Book> page = bookService.getPage(1, 5);
        List<Book> records = page.getRecords();
        for(Book book:records){
            System.out.println(book);
        }
    }

    @Test
    void test5(){
        Book book=new Book();
        book.setId(2);
        book.setDescription("了解童话故事");
        System.out.println(bookService.update(book));
    }
}
