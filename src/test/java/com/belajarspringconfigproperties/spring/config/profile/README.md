# Profile
- Profile merupakan fitur di Spring yang bisa kita gunakan untuk menentukan component jalan di profile mana.
- Profile cocok sekali ketika kita butuh component berbeda pada kondisi tertentu, misal kita buat component untuk koneksi ke Memory Database, tapi jika di Local misal kita ingin component nya diganti dengan koneksi di memory aplikasi saja.
- Untuk menandai sebuah component dengan informasi Profile, kita bisa menggunakan Annotation Profile.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Profile.html).

# Profile Properties
- Untuk menentukan profile apa yang berjalan, kita bisa menentukannya di application properties dengan menggunakan key spring.profiles.active.
- Dimana kita bisa menentukan active profile lebih dari satu jika kita mau.
- Kode: Application Properties
```text
application.name=Belajar Spring Boot
application.version=1
application.production-mode=false

spring.profiles.active=local
```
- Kode: Test Component
```java
@Component
@Profile({"local"})
public static class SayHelloLocal implements SayHello {
    @Override
    public String say(String name) {
        return "Hello " + name + " from local";
    }
}

@Component
@Profile({"production"})
public static class SayHelloProduction implements SayHello {
    @Override
    public String say(String name) {
        return "Hello " + name + " from production";
    }
}
```
- Kode: Unit Test Profile
```java
@SpringBootTest(classes = ProfileTest.TestApplication.class)
public class ProfileTest {
    @Autowired
    private TestApplication.SayHello sayHello;

    @Test
    void testProfile() {
        Assertions.assertEquals("Hello Sandy from local", sayHello.say("Sandy"));
    }
}
```

# Active Profile
- Kadang jika harus mengubah profile di application properties akan menyulitkan ketika kita membuat unit test untuk beberapa profile.
- Untuk mengubah profile di unit test, kita bisa menggunakan annotation ActiveProfiles.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/ActiveProfiles.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/test/context/ActiveProfiles.html).
- Kode: Active Profiles
```java
@SpringBootTest(classes = ProfileTest.TestApplication.class)
@ActiveProfiles({"production"})
public class ProfileTest {
    @Autowired
    private TestApplication.SayHello sayHello;

    @Test
    void testProfile() {
        Assertions.assertEquals("Hello Sandy from production", sayHello.say("Sandy"));
    }
}
```

# Profile di Environment
- Kadang kita ingin mendapatkan profile pada saat aplikasi berjalan.
- Jika ada kasus seperti ini, kita bisa menggunakan Environment.
- Terdapat method getActiveProfiles() untuk mendapatkan profile yang sedang aktif.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html#getActiveProfiles--](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/Environment.html#getActiveProfiles--).
- Kode: Profile Environment
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    public static class SampleProfile implements EnvironmentAware {
        @Setter
        private Environment environment;
        
        public String[] getActiveProfiles() {
            return environment.getActiveProfiles();
        }
    }
}
```
- Kode: Unit Test Profile di Environment
```java
@SpringBootTest(classes = ProfileEnvironmentTest.TestApplication.class)
@ActiveProfiles({"production", "local"})
public class ProfileEnvironmentTest {
    @Autowired
    private TestApplication.SampleProfile sampleProfile;

    @Test
    void testProfileEnvironment() {
        Assertions.assertArrayEquals(new String[]{"production", "local"}, sampleProfile.getActiveProfiles());
    }
}
```