package com.belajarspringconfigproperties.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private String name;
    private Integer version;
    private boolean productionMode;
    private DatabaseProperties database;
    private List<RoleProperties> defaultRoles;
    private Map<String, RoleProperties> roles;
    private Duration defaultTimeout;
    private Date expireDate;
}
