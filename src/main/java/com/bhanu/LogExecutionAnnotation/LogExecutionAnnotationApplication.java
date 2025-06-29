package com.bhanu.LogExecutionAnnotation;

import com.bhanu.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.bhanu.*"})
public class LogExecutionAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogExecutionAnnotationApplication.class, args);
	}

}
