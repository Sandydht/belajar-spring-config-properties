# Conversion
- Saat kita menggunakan config properties di Spring, bagaimana Spring melakukan konversi data yang ada di properties file ke tipe data di Java?.
- Jawabannya adalah karena Spring memiliki mekanisme konversi tipe data.
- Secara default, hampir semua tipe data umum di Java didukung, namun bagaimana jika tipe data yang kita buat sendiri?.
- Jika ada kasus seperti itu, kita bisa membuat class Conversion sendiri.

# Conversion Interface
- Semua konversi tipe data di Spring sudah dibuat standarisasinya, yaitu menggunakan interface Converter.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/converter/Converter.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/converter/Converter.html).

# Default Converter
- Secara default, Spring juga sudah menyediakan Converter untuk tipe data bawaan Java, seperti Number, Boolean, Date, Calendar, Duration, dan lain - lain.
- Kita bisa lihat secara semua class turunan dari Converter.
- Kode: Duration Converter
```java
@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private Duration defaultTimeout;
}
```
- Kode: Application Properties
```text
application.name=Belajar Spring Boot
application.version=1
application.production-mode=false
application.default-timeout=10s
```
- Kode: Unit Test Duration
```java
@Test
void testDurationProperties() {
    Assertions.assertEquals(Duration.ofSeconds(10), applicationProperties.getDefaultTimeout());
}
```

# Custom Converter
- Jika ada kasus yang akhirnya mengharuskan kita membuat converter sendiri, kita bisa dengan mudah membuat class turunan interface Converter.
- Misal kita coba buat Converter untuk tipe data String ke Date.
- Kode: String to Date Converter
```java
@Component
public class StringToDateConverter implements Converter<String, Date> {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    @SneakyThrows
    public Date convert(String source) {
        return DATE_FORMAT.parse(source);
    }
}
```
- Kode: Application Properties
```java
@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private Date expireDate;
    private Duration defaultTimeout;
}
```
- Kode: Unit Test Custom Converter
```java
@Test
void testDurationProperties() {
    Assertions.assertEquals(Duration.ofSeconds(10), applicationProperties.getDefaultTimeout());
}
```

# Kenapa Error?
- Secara default, jika kita ingin menggunakan custom Converter, kita harus registrasikan ke ConversionService.