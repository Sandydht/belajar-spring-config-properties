# Environment
- Environment tidak hanya bisa digunakan untuk mengakses Application Properties.
- Environment juga bisa digunakan untuk mengakses data environment variable pada sistem operasi.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html).
- Kita bisa menggunakan EnvironmentAware jika ingin mendapatkan object Environment.
- Kode: Environment
```java
@Autowired
private Environment environment;

@Test
void testEnvironment() {
    String java_home = environment.getProperty("JAVA_HOME");
    System.out.println(java_home);
}
```