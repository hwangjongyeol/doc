package com.skt.tidhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class startApplication {

	public static void main(String[] args) {
		SpringApplication.run(startApplication.class, args);
	}
}
