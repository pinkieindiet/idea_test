package com.lyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserProviderDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(UserProviderDemo1Application.class, args);
    }

}
