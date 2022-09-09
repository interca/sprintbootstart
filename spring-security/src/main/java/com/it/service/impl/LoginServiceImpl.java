package com.it.service.impl;

import com.it.domain.LoginUser;
import com.it.domain.User;
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
    AuthenticationManager authenticationManager;
    @Override
    public SystemJsonResponse login(User user) {
        //进行用户认证,
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败
        if(Objects.isNull(authenticate))throw  new RuntimeException("登录失败");
        //认证成功,用userid生成jwt，存入result中返回

        //强转
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userid = loginUser.getUser().getId();
        //生成jwt
        String jwt = JwtUtil.createJWT(userid.toString());
        return  SystemJsonResponse.success(jwt);
    }
}
