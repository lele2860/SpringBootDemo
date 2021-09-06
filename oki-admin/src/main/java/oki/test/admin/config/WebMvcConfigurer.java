package oki.test.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebMvcConfigurer implements org.springframework.web.servlet.config.annotation.WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        org.springframework.web.servlet.config.annotation.WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("POST","GET","OPYIONS","DELETE")
                .maxAge(168000)
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
