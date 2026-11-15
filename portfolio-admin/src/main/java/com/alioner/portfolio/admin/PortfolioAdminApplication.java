package com.alioner.portfolio.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alioner.portfolio")
public class PortfolioAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioAdminApplication.class, args);
    }
}
