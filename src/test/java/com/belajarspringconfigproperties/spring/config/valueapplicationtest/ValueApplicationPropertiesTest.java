package com.belajarspringconfigproperties.spring.config.valueapplicationtest;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueApplicationPropertiesTest.TestApplication.class)
public class ValueApplicationPropertiesTest {
    @Autowired
    private TestApplication.ValueApplicationProperties properties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testApplicationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertFalse(properties.isProductionMode());
    }

    @Test
    void testSystemProperties() {
        System.out.println(systemProperties.getJavaHome());
//        Assertions.assertNotNull(systemProperties.javaHome);
    }

    @SpringBootApplication
    public static class TestApplication {
        @Component
        @Getter
        public static class SystemProperties {
            @Value("${JAVA_HOME}")
            private String javaHome;
        }

        @Component
        @Getter
        public static class ValueApplicationProperties {
            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private boolean isProductionMode;
        }
    }
}
