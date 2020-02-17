package com.springboot.microservices.mvp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("*")
        .allowedHeaders("*")
        .exposedHeaders("Content-Disposition", "Content-length", "Content-Transfer-Encoding");    
    }
//    
//	@Bean
//	public FilterRegistrationBean accessLogFilterBean() {
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new ApiAccessLog());
//		return registrationBean;
//	}
}
