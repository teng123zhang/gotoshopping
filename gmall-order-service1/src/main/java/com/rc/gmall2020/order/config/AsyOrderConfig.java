package com.rc.gmall2020.order.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration
@EnableAsync
public class AsyOrderConfig implements AsyncConfigurer {

	//获取执行者
	@Bean
	public Executor getAsyncExecutor() {
		//配置线程池
		
		 ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
	        // 设置线程数
	        threadPoolTaskExecutor.setCorePoolSize(10);
	        // 设置最大连接数
	        threadPoolTaskExecutor.setMaxPoolSize(100);
	        // 设置等待队列，如果10个不够，可以有100个线程等待 缓冲池
	        threadPoolTaskExecutor.setQueueCapacity(100);
	        // 初始化操作
	        threadPoolTaskExecutor.initialize();
	        return threadPoolTaskExecutor;
	}

	//处理异常
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		//自定义异常！
		return null;
	}

}