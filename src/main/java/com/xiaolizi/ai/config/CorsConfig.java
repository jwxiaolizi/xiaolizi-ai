package com.xiaolizi.ai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author l4784
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * 重写addCorsMappings方法，用于配置跨域资源共享（CORS）设置。
     *
     * @param registry CORS注册中心，用于配置CORS规则
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加CORS映射
        registry.addMapping("/**")
                // 允许所有来源的跨域请求
                .allowedOrigins("*")
                // 允许的方法类型
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // 允许的头信息
                .allowedHeaders("*");
    }

}
