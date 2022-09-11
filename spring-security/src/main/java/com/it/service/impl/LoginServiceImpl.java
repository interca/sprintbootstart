package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.Exception.GlobalSystemException;
import com.it.domain.LoginUser;
import com.it.domain.User;
import com.it.mapper.UserMapper;
import com.it.service.LoginService;
import com.it.util.JwtUtil;
import com.it.util.SystemJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户登录的实现类
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserMapper userMapper;
    @Override
    public SystemJsonResponse login(User user) throws GlobalSystemException {
        //进行用户认证,
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        if(Objects.isNull(authenticate))throw  new RuntimeException("密码错误");
        //认证成功,用userid生成jwt，存入result中返回
        //改变数据库的登录状态
        LambdaQueryWrapper<User>lq=new LambdaQueryWrapper<>();
        user.setIsLogin(1);
        user.setPassword(null);
        lq.eq(User::getUserName,user.getUserName());
        userMapper.update(user,lq);
        //强转
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userid = loginUser.getUser().getId();
        //生成jwt
        String jwt = JwtUtil.createJWT(userid.toString());
        return  SystemJsonResponse.success(jwt);
    }

    //退出登录
    @Override
    public SystemJsonResponse logout() {
            //获取  SecurityContextHolder里面的用户id
            UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = null;
        try {
            loginUser = (LoginUser) authenticationToken.getPrincipal();
        } catch (Exception e) {
            throw new RuntimeException();
        }
            User user=new User();
            user.setId(loginUser.getUser().getId());
            user.setIsLogin(0);
            System.out.println("user"+user);
            LambdaQueryWrapper<User>lq=new LambdaQueryWrapper<>();
            lq.eq(User::getId,user.getId());
            userMapper.update(user,lq);
            return SystemJsonResponse.success();

    }
}

