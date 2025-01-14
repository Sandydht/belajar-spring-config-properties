# Complex Configuration Properties
- Configuration Properties juga mendukung Java Bean yang kompleks, misal yang berisikan Java Bean object lain.
- Hal ini membuat pembuatan Configuration Properties menjadi lebih mudah, karena tidak perlu kita lakukan secara manual.
- Kode: Embedded Class
```java
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private String name;
    private Integer version;
    private boolean productionMode;
    private DatabaseProperties database;
    
    @Setter
    @Getter
    public static class DatabaseProperties {
        private String username;
        private String password;
        private String database;
        private String url;
        private List<String> whitelistTables;
        private Map<String, Integer> maxTablesSize;
    }
}
```
- Kode: Unit Test Complex Configuration Properties
```java
@Test
void testComplexConfigurationProperties() {
    Assertions.assertEquals("sandy", applicationProperties.getDatabase().getUsername());
    Assertions.assertEquals("rahasia", applicationProperties.getDatabase().getPassword());
    Assertions.assertEquals("jdbs:host:port", applicationProperties.getDatabase().getUrl());
    Assertions.assertEquals("belajar", applicationProperties.getDatabase().getDatabase());
}
```