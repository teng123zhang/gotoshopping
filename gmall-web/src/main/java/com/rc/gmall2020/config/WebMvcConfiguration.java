package com.rc.gmall2020.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration //xx.xml
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	private AuthInterceptor authInterceptor;
	@Override
	//拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		//配置拦截器
		
		registry.addInterceptor(authInterceptor).addPathPatterns("/**");
		//添加拦截器
		super.addInterceptors(registry);
		
	}

}
