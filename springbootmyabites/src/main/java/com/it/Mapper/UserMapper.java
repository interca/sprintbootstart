package com.it.Mapper;

import com.it.domain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
    User getById(Integer id);
}
