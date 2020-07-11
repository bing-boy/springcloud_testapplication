package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(scanBasePackages = "com")
@EnableEurekaClient //激活Eureka中的DiscoveryClient实现
public class SpringcloudTestapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudTestapplicationApplication.class, args);
	}

}
