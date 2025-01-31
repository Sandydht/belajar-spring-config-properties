package com.belajarspringconfigproperties.spring.config.runner;

import com.belajarspringconfigproperties.spring.config.properties.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ApplicationPropertiesRunner implements ApplicationRunner {
    private ApplicationProperties applicationProperties;

    @Override
    public void run(ApplicationArguments agrs) throws Exception {
        log.info(applicationProperties.getName());
        log.info(String.valueOf(applicationProperties.getVersion()));
        log.info(String.valueOf(applicationProperties.isProductionMode()));
    }
}
