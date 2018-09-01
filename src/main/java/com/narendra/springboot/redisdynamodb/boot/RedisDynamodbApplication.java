package com.narendra.springboot.redisdynamodb.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = "com.narendra.springboot.redisdynamodb")
public class RedisDynamodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDynamodbApplication.class, args);
    }
}
