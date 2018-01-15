package com.dby.request.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 配置静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/request/static/js/");
        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/request/static/css/");
        registry.addResourceHandler("/static/fonts/**").addResourceLocations("classpath:/static/request/static/fonts/");
        registry.addResourceHandler("/static/img/*").addResourceLocations("classpath:/static/request/static/img/");
        super.addResourceHandlers(registry);
    }
}
