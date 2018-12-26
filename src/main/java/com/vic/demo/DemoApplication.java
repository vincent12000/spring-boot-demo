package com.vic.demo;

import com.vic.demo.security.service.impl.JwtUserDetailsServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

@MapperScan("com.vic.demo.dao")
@SpringBootApplication
//@ComponentScan(basePackages = {
//		"com.vic.demo.config",
//		"com.vic.demo.*.controller",
//		"com.vic.demo.service",
//		"com.vic.demo.security.service"})
@Import({
		JwtUserDetailsServiceImpl.class
})
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
