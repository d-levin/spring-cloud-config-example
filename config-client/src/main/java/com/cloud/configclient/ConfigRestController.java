package com.cloud.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("configurations")
public class ConfigRestController {

    private final DatabaseConfig databaseConfig;

    @Autowired
    public ConfigRestController(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    @GetMapping("database")
    public Map<String, String> getDatabaseConfiguration() {
        final Map<String, String> config = new HashMap<>();
        config.put("url", databaseConfig.getUrl());
        config.put("username", databaseConfig.getUsername());
        config.put("password", databaseConfig.getPassword());
        return config;
    }

}
