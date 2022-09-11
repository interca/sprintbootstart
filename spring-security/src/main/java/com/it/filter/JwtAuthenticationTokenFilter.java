package com.it.filter;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.Exception.GlobalSystemException;
import com.it.domain.LoginUser;
import com.it.domain.User;
import com.it.mapper.MenuMapper;
import com.it.mapper.UserMapper;
import com.it.util.JwtUtil;
import com.it.util.SystemJsonResponse;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.io.PipedReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 定义过滤器
 * 最后还要配置到security中
 * @since 2022-9-9
 */

//被spring加载
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

   @Autowired
   private UserMapper userMapper;

   @Autowired
   private MenuMapper menuMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token,从请求头中
        String token = request.getHeader("token");
        //字符串为空
        if (!StringUtils.hasText(token)) {
                filterChain.doFilter(request, response);
                return;
        }
        //解析token
        String userid;

        Claims claims = null;
        try {
            claims = JwtUtil.parseJWT(token);
        } catch (Exception e) {
            throw new RemoteException("token不合法");
        }
        userid = claims.getSubject();



        //从数据库中获取信息，看是否登录
        LambdaQueryWrapper<User>qw=new LambdaQueryWrapper<>();
        qw.eq(User::getId,userid);
        User User= userMapper.selectOne(qw);
        System.out.println(User);
        if(User.getIsLogin()==0){
           //throw  new GlobalSystemException(SystemJsonResponse.fail("用户未登录"));
            throw  new RuntimeException("用户未登录");
        }

        List<String> permission=menuMapper.selectPermsByUserId(User.getId());
        LoginUser loginUser = new LoginUser(User, permission);

        //存入SecurityContextHolder
        //TODO 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

          //放行
        filterChain.doFilter(request, response);
    }


}





