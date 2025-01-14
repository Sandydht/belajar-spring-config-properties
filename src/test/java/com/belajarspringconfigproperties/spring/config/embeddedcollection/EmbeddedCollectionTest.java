package com.belajarspringconfigproperties.spring.config.embeddedcollection;

import com.belajarspringconfigproperties.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EmbeddedCollectionTest.TestApplication.class)
public class EmbeddedCollectionTest {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    void testEmbeddedCollectionProperties() {
        Assertions.assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", applicationProperties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", applicationProperties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", applicationProperties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", applicationProperties.getRoles().get("finance").getName());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
