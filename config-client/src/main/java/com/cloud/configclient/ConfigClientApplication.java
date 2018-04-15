package com.cloud.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfigClientApplication {

    private final DatabaseConfig databaseConfig;

    @Autowired
    public ConfigClientApplication(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> System.out.println(databaseConfig);
    }
}
