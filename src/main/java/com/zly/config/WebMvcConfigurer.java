package com.zly.config;



import com.zly.controller.interceptor.OneInterceptor;
import com.zly.controller.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by zly11 on 2018/4/2.
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

//    @Bean
//    public OneInterceptor getOnInterceptor(){
//        return new OneInterceptor();
//    }
    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return new RequestInterceptor();
    }

    @Bean
    public OneInterceptor getOnInterceptor(){
        return new OneInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(getRequestInterceptor()).addPathPatterns("/*/**");
        registry.addInterceptor(getOnInterceptor()).addPathPatterns("/mi/**");

    }
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}
