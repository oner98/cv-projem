package com.alioner.portfolio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.alioner.portfolio")
@EntityScan(basePackages = "com.alioner.portfolio")
@EnableJpaRepositories(basePackages = "com.alioner.portfolio")
public class PortfolioApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApiApplication.class, args);
    }
}
