# Application Properties
- Saat kita membuat project Spring menggunakan start.spring.io, secara otomatis terdapat sebuah file application.properties.
- File ini adalah pusat dari file properties untuk konfigurasi aplikasi Spring yang kita buat.
- Secara otomatis, Spring Boot akan membaca konfigurasi yang kita masukkan ke dalam file application.properties.
- Ini bukanlah file untuk Internationalization, melainkan file ini digunakan untuk konfigurasi aplikasi, jika kita butuh pesan untuk Internationalization, gunakan file messages.properties seperti yang sudah kita bahas sebelumnya.

# Mengakses Application Properties
- Ada banyak cara untuk mengakses konfigurasi yang terdapat di application.properties, nanti akan dibahas di chapter masing - masing.
- Kode: Application Properties
```text
application.name=Belajar Spring Boot
```
- Kode: Mengakses Application Properties
```java
@SpringBootTest(classes = ApplicationPropertiesTest.TestApplication.class)
public class ApplicationProperties {
    @Autowired
    private Environment environment;
    
    @Test
    void testApplicationProperties() {
        String message = environment.getProperty("application.name");
        Assertions.asserEquals("Belajar Spring Boot", message);
    }
}
```