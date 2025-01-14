# Property Source
- Secara default, application properties hanya akan mengambil dari file di application.properties yang terdapat di classpath project.
- Namun, Spring memiliki fitur yang bisa kita gunakan jika kita ingin menambahkan application properties dari file lain, namanya adalah PropertySource.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/PropertySource.html).
- Kita bisa sebutkan Resource mana yang kita tambahkan ke application properties.
- Jika kita ingin menambah lebih dari satu property source, kita bisa gunakan annotation PropertySources.
- Kode: Sample Properties
```text
sample.name=Sample Project
sample.version=1
```
- Kode: Property Source
```java
@SpringBootApplication
@PropertySources({
        @PropertySources("classpath:/sample.properties")
})
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
- Kode: Test Property Source
```java
@SpringBootTest(classes = PropertySourceTest.TestApplication)
public class PropertySourceTest {
    @Autowired
    private TestApplication.SampleProperties sampleProperties;

    @Test
    void testPropertySource() {
        Assertions.assertEquals("Sample Project", sampleProperties.getName());
        Assertions.assertEquals(1, sampleProperties.getVersion());
    }
}
```