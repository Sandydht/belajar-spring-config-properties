# Spring Boot Message Source
- Jika kita menggunakan Spring Boot, secara otomatis Spring Boot telah membuat Message Source secara otomatis, kita tidak perlu membuat bean untuk MessageSource secara manual.
- Selain itu secara default, Spring Boot akan membuat MessageSource dengan mengambil data resource bundle di message.properties.

# Message Source Aware
- Jika kita ingin menggunakan MessageSource, kita juga bisa menggunakan MessageSourceAware.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSourceAware.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSourceAware.html).
- Atau sebenarnya, ApplicationContext adalah turunan dari MessageSource.
- Kode: Properties
```text
hello=Hello {0}
```
- Kode: Message Source Aware
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    public static class SampleResource implements MessageSourceAware {
        @Setter
        private MessageSource messageSource;

        public String helloSandy() {
            return messageSource.getMessage("hello", new Object[]{"Sandy"}, Locale.getDefault());
        }
    }
}
```
- Kode: Test Message Source
```java
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest(classes = MessageSourceTest.TestApplication.class)
public class MessageSourceTest {
    @Autowired
    private TestApplication.SampleSource sampleSource;
    
    @Test
    void testMessageSource() {
        Assertions.assertEquals("Hello Sandy", sampleSource.helloSandy());
    }
}
```