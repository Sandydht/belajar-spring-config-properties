package com.belajarspringconfigproperties.spring.config.resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {
    @Test
    void testResource() throws IOException {
        var resource = new ClassPathResource("/text/sample.txt");

        System.out.println(resource.getPath());
        System.out.println(resource.getFilename());
        System.out.println(resource.getFile().getAbsolutePath());

        Assertions.assertNotNull(resource);
        Assertions.assertTrue(resource.exists());
        Assertions.assertNotNull(resource.getFile());
    }
}
