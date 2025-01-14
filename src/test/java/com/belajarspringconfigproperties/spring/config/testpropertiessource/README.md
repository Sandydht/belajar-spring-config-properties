# Test Properties Source
- Saat membuat unit test, kadang - kadang kita ingin menggunakan properties file yang berbeda untuk mencoba skenario yang berbeda.
- Hal ini agak sulit jika dilakukan dengan menggunakan Annotation PropertySource.
- Untungnya di Spring sudah disediakan Annotation TestPropertySource untuk kebutuhan ini, jadi kita bisa menggunakan properties file yang kita mau di unit test.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/TestPropertySource.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/TestPropertySource.html).
- Jika membutuhkan properties file lebih dari satu, kita bisa gunakan annotation TestPropertySources.
- Kode: Test Properties
```text
sample.name=Test Project
sample.version=1
```
- Kode: Test Application
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    @Getter
    public static class SampleProperties {
        @Value("${sample.name}")
        private String name;

        @Value("${sample.version}")
        private Integer version;
    }
}
```
- Kode: Test Properties Source
```java
@TestPropertySources({
        @TestPropertySource("classpath:/test.properties")
})
@SpringBootTest(classes = PropertySourceTest.TestApplication.class)
public class PropertySourceTest {
    @Autowired
    private TestApplication.SampleProperties sampleProperties;

    @Test
    void testPropertySourceTest() {
        Assertions.assertEquals("Test Project", sampleProperties.getName());
        Assertions.assertEquals(1, sampleProperties.getVersion());
    }
}
```