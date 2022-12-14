package com.it.cofig;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mp=new MybatisPlusInterceptor();
        //分页
        mp.addInnerInterceptor(new PaginationInnerInterceptor());
        //乐观锁；拦截器
        mp.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mp;
    }
}
