# Value
- Value merupakan Annotation yang bisa kita gunakan untuk melakukan inject data dari properties ke field yang kita tandai.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Value.html).

# Value Application Properties
- Annotation Value bisa kita gunakan untuk mengambil data dari application properties.
- Kita bisa menggunakan kode ``` ${nama.properties.nya} ```.
- Secara otomatis akan diambil valuenya, dan secara otomatis akan melakukan konversi juga.
- Kode: Application Properties
```text
application.name=Belajar Spring Boot
application.version=1
application.production-mode=false
```
- Kode: Inject Value
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    @Getter
    public static class ApplicationProperties {
        @Value("${application.name}")
        private String name;
        
        @Value("${application.version}")
        private Integer version;
        
        @Value("${application.production-mode}")
        private Boolean isProductionMode;
    }
}
```
- Kode: Unit Test Value Properties
```java
@SpringBootTest(classes = ValuePropertiesTest.TestApplication.class)
public class ValuePropertiesTest {
    @Autowired
    private TestApplication.ApplicationProperties properties;
    
    @Test
    void testApplicationProperties() {
        Assertions.assertEquals("Belajar Spring Boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertFalse(properties.isProductionMode);
    }
}
```

# Value System Variable
- Selain application properties, Annotation Value juga bisa digunakan untuk mengambil data dari system properties atau environment variable.
- Caranya sama seperti mengambil application properties.
- Secara otomatis akan diambil valuenya, dan secara otomatis akan melakukan konversi juga.
- Kode: Value System Variable
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    @Getter
    public static class SystemProperties {
        @Value("${JAVA_HOME}")
        private String javaHome;
    }
}
```
- Kode: Unit Test Value System Variable
```java
@Autowired
private TestApplication.SystemProperties systemProperties;

@Test
void testSystemProperties() {
    Assertions.assertEquals(
            "/Users/sandydht/Tools/jdk-17.0.1.jdk/Contects/Home",
            systemProperties.getJavaHome()
    );
}
```