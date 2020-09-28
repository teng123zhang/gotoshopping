package com.guli.video;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient //启动远程服务
@SpringBootApplication
public class VideoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}
	

}
