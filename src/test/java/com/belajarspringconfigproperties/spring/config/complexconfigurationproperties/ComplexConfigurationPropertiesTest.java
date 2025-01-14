package com.belajarspringconfigproperties.spring.config.complexconfigurationproperties;

import com.belajarspringconfigproperties.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ComplexConfigurationPropertiesTest.TestApplication.class)
public class ComplexConfigurationPropertiesTest {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    void testComplexConfigurationProperties() {
        Assertions.assertEquals("sandy", applicationProperties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", applicationProperties.getDatabase().getPassword());
        Assertions.assertEquals("jdbc:contoh", applicationProperties.getDatabase().getUrl());
        Assertions.assertEquals("belajar", applicationProperties.getDatabase().getDatabase());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
