package com.it;

import com.it.domain.Book;
import com.it.mapper.BookMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
