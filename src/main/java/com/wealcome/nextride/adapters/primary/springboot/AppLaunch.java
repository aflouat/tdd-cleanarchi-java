package com.wealcome.nextride.adapters.primary.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wealcome.nextride")
public class AppLaunch {

        public static void main(String[] args) {
            SpringApplication.run(AppLaunch.class, args);
        }
}
