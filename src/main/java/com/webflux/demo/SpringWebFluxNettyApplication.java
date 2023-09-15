package com.webflux.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringWebFluxNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxNettyApplication.class, args);
    }

}
