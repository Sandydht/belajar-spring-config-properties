# Profile Properties File
- Saat kita menggunakan fitur profile, kita juga bisa membuat file properties sesuai dengan profile yang aktif.
- Penamaan properties file adalah application-{profile}.properties.
- Misal jika active profile adalah dev, maka application-dev.properties akan di load.
- Jika active profile lebih dari satu, maka semua files properties tiap profile akan di load.
- Jangan lupa application.properties akan tetap di load disemua profile.
- Kode: Test Application
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    @Getter
    public static class ProfileProperties {
        @Value("${profile.default}")
        private String defaultFile;
        
        @Value("${profile.production}")
        private String productionFile;
        
        @Value("${profile.test}")
        private String testFile;
    }
}
```
- Kode: Unit Test Properties Files
```java
@SpringBootTest(classes = ProfileFileTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ProfileFileTest {
    @Autowired
    private TestApplication.ProfileProperties profileProperties;

    @Test
    void testProfileFiles() {
        Assertions.assertEquals("Default", profileProperties.getDefaultFile());
        Assertions.assertEquals("Production", profileProperties.getProductionFile());
        Assertions.assertEquals("Test", profileProperties.getTestFile());
    }
}
```