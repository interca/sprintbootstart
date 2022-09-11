package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.Exception.GlobalSystemException;
import com.it.domain.LoginUser;
import com.it.domain.User;
import com.it.mapper.MenuMapper;
import com.it.mapper.UserMapper;
import com.it.util.SystemJsonResponse;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


/**
 * 登录实现
 * @since 2022-9-7
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询
        LambdaQueryWrapper<User>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        //用户不存在
        if(Objects.isNull(user)){
           throw new RuntimeException("用户不存在");
        }
        // 查询对应的权限信息
        List<String> permission = menuMapper.selectPermsByUserId(user.getId());
        //封装成UserDetails返回
        return new LoginUser(user,permission);
    }
}

