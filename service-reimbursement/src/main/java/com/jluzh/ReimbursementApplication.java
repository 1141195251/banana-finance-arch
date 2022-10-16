package com.jluzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.jluzh.dao")
public class ReimbursementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReimbursementApplication.class, args);
    }
    }

