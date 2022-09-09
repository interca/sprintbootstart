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
    public SystemJsonResponse login(User user)  {
        //进行用户认证,
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        if(Objects.isNull(authenticate))throw  new GlobalSystemException(SystemJsonResponse.fail("登录失败"));
        //认证成功,用userid生成jwt，存入result中返回

        //改变数据库的登录状态
        LambdaQueryWrapper<User>lq=new LambdaQueryWrapper<>();
        user.setIsLogin(1);
        lq.eq(User::getUserName,user.getUserName());
        userMapper.update(user,lq);
        //强转
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userid = loginUser.getUser().getId();
        //生成jwt
        String jwt = JwtUtil.createJWT(userid.toString());
        return  SystemJsonResponse.success(jwt);
    }

    @Override
    public SystemJsonResponse logout() {
        //获取SecurityContextHolder中用户信息
        return SystemJsonResponse.success();
    }
}
