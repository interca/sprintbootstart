package com.it.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域处理配置类
 * @author  hyj
 * @version  1.0
 * @since 2022-9-13
 */
@Configuration  //成为配置类
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域处理
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

       registry
               //允许访问路径
               .addMapping("/**")
               //配置请求来源
               .allowedOriginPatterns("*")
               //允许访问的方法
               .allowedMethods("GET","POST","DELETE","PUT","OPTION")
               //最大效应时间
               .maxAge(3600)
               .allowedHeaders("*")
               //是否允许携带参数,携带token
               .allowCredentials(true);
    }
}
