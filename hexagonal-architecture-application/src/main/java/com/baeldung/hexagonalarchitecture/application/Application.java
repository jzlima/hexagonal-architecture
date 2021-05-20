package com.baeldung.hexagonalarchitecture.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EntityScan(basePackages={"com.baeldung.hexagonalarchitecture.core"})
@EnableJpaRepositories(basePackages = "com.baeldung.hexagonalarchitecture.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
