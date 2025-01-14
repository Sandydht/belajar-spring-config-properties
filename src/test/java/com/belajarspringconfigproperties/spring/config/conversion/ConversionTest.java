package com.belajarspringconfigproperties.spring.config.conversion;

import com.belajarspringconfigproperties.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@SpringBootTest(classes = ConversionTest.TestApplication.class)
public class ConversionTest {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    void testDurationProperties() {
        Assertions.assertEquals(Duration.ofSeconds(10), applicationProperties.getDefaultTimeout());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
