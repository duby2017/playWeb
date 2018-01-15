package com.dby.test.config;

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
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/test/static/js/");
        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/test/static/css/");
        registry.addResourceHandler("/static/fonts/**").addResourceLocations("classpath:/static/test/static/fonts/");
        registry.addResourceHandler("/static/img/*").addResourceLocations("classpath:/static/test/static/img/");
        super.addResourceHandlers(registry);
    }
}
