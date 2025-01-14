package com.belajarspringconfigproperties.spring.config.collectionconfigurationproperties;

import com.belajarspringconfigproperties.spring.config.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = CollectionConfigurationPropertiesTest.TestApplication.class)
public class CollectionConfigurationPropertiesTest {
    @Autowired
    private ApplicationProperties applicationProperties;

    @Test
    void testCollectionConfigurationProperties() {
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), applicationProperties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("products"));
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("customers"));
        Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("categories"));
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}
