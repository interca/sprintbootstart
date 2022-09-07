package com.it.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.domain.LoginUser;
import com.it.domain.User;
import com.it.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * 登录实现
 * @since 2022-9-7
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询
        LambdaQueryWrapper<User>queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
        //用户不存在
        if(Objects.isNull(user)){
           throw new RuntimeException("用户名或者密码错误");
        }
        //封装成UserDetails返回
        return new LoginUser(user);
    }
}
