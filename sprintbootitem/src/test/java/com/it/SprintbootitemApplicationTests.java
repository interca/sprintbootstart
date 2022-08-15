package com.it;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.domain.Book;
import com.it.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SprintbootitemApplicationTests {

    @Autowired
    private BookMapper bookMapper;
    //根据id查询
    @Test
    void contextLoads() {
        Book byId = bookMapper.selectById(1);
        System.out.println(byId);
    }

    //插入
    @Test
    void  save(){
        Book book=new Book();
        book.setName("明朝那些事");
        book.setType("历史");
        book.setDescription("讲述明朝历史故事");
        bookMapper.insert(book);
    }

    @Test
    void update(){
        Book book=new Book();
        book.setId(15);
        book.setDescription("明朝历史");
        bookMapper.updateById(book);
    }

    @Test
    void getall(){
        List<Book> books = bookMapper.selectList(null);
        for(Book book:books){
                System.out.println(book);
        }
    }

    @Test
    void getpage(){
        IPage page=new Page(1,5);
        bookMapper.selectPage(page,null);
        List records = page.getRecords();
        for(Object o:records){
            System.out.println(o);
        }
    }

    @Test
    void selectby(){
        //按条件查询
        QueryWrapper<Book>queryWrapper=new QueryWrapper<>();
        //名字里有spring
        queryWrapper.like("name","spring");
        List<Book> books = bookMapper.selectList(queryWrapper);
        for(Book book:books){
            System.out.println(book);
        }
    }

}
