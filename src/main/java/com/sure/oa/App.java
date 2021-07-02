package com.sure.oa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication //此注解说明这是Spring Boot的启动类
@ServletComponentScan //扫描过滤器等组件
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);//启动Spring Boot应用
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//允许任何地址跨域
                        .allowedOriginPatterns("*")//设置允许跨域请求的域名
                        .allowedMethods("*")//允许任何请求（get, post, put, delete, head, options等等）跨域
                        .allowCredentials(true);//允许客户端发送凭证（即sessionId），以利于识别客户端
            }
        };
    }
}
