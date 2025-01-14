# Configuration Properties
- Spring Boot memiliki sebuah fitur canggih bernama Configuration Properties.
- Fitur ini bisa digunakan melakukan binding secara otomatis key yang ada di application properties ke Java Bean property secara otomatis.
- Namun untuk menggunakan fitur ini, kita perlu menambahkan dependency yang dibutuhkan, yaitu spring-boot-configuration-processor.
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artefactId>spring-boot-configuration-processor</artefactId>
    <optional>true</optional>
</dependency>
```

# Configuration Properties Annotation
- Untuk menandai Java Bean agar secara otomatis di binding ke Application Properties, kita perlu menandai class nya dengan annotation ConfigurationProperties.
- [https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/ConfigurationProperties.html).
- Selanjutnya kita perlu menentukan prefix untuk key di application properties nya.
- Kode: Java Bean Properties
```java
@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private String name;
    private Integer version;
    private boolean productionMode;
}
```

# Spring Configuration Metadata
- Sebenarnya, untuk membuat Spring melakukan automatic binding ke Configuration Properties, kita harus membuat sebuah file metadata.
- Namun hal tersebut tidak perlu kita lakukan manual, secara otomatis ketika menambahkan dependency configuration properties, dependency tersebut akan melakukan auto generate file metadata dari class yang kita tandai menggunakan annotation ConfigurationProperties.
- Cara untuk membuat file metadata secara auto generate cukup kita lakukan kompilasi saja project kita, misal jika menggunakan maven, tinggal gunakan perintah : mvn compile.

# Enable Configuration Properties
- Secara default, Configuration Properties tidak akan berjalan jika kita tidak beritahukan ke Spring Boot Application.
- Kita perlu memberitahu bahwa kita membuat class Configuration Properties dengan menggunakan Annotation EnableConfigurationProperties.
- [https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/EnableConfigurationProperties.html](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/properties/EnableConfigurationProperties.html).
- Kode: Spring Boot Application
```java
@SpringBootApplication
@EnableConfigurationProperties({
        ApplicationProperties.class
})
public static class TestApplication {
    
}
```
- Kode: Unit Test Configuration Properties
```java
@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {
    @Autowired
    private ApplicationProperties applicationProperties;
    
    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertFalse(applicationProperties.getProductionMode());
    }
}
```