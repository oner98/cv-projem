package com.alioner.portfolio.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alioner.portfolio")
public class PortfolioGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioGatewayApplication.class, args);
    }
}
