package com.belajarspringconfigproperties.spring.config.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringBootMessageSourceTest.TestApplication.class)
public class SpringBootMessageSourceTest {
    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHelloSandy() {
        Assertions.assertEquals("Hello Sandy", sampleSource.helloSandy(Locale.ENGLISH));
        Assertions.assertEquals("Halo Sandy", sampleSource.helloSandy(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestApplication {
        @Component
        public static class SampleSource implements MessageSourceAware {
            @Setter
            private MessageSource messageSource;

            public String helloSandy(Locale locale) {
                return messageSource.getMessage("hello", new Object[]{"Sandy"}, locale);
            }
        }
    }
}
