package com.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaAuditing
@RestController
@SpringBootApplication

public class APIRunApplication {

    public static void main(String[] args) {
        // 固定的代码 启动springboot程序 初始化spring容器
        SpringApplication.run(APIRunApplication.class, args);
    }



}
