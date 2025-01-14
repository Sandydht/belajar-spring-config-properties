package com.belajarspringconfigproperties.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("application")
public class DatabaseProperties {
    private String username;
    private String password;
    private String database;
    private String url;
    private List<String> whitelistTables;
    private Map<String, Integer> maxTablesSize;
}
