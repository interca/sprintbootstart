package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.domain.Book;
import org.apache.ibatis.annotations.Mapper;


//继承接口，可以实现很多数据库查询方法
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
