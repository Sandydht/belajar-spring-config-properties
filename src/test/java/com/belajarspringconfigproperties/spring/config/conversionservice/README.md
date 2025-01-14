# Conversion Service
- Conversion Service merupakan inti dari logic untuk melakukan konversi tipe data di Spring.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/convert/ConversionService.html).
- Saat kita membuat custom converter, maka kita harus registrasikan ke conversion service.
- Kita tidak perlu membuat Conversion Service secara manual, karena implementasi class nya sudah disediakan oleh Spring, yaitu ApplicationConversionService.
- Jika membuat aplikasi berbasis Web, kita tidak perlu melakukannya secara manual, karena sudah otomatis ada di Spring Boot Web, namun karena sekarang kita belum belajar Spring Boot Web, jadi kita perlu membuat Conversion Service secara manual.
- Kode: Membuat Conversion Service
```java
@SpringBootApplication
@EnableConfigurationProperties({
        ApplicationProperties.class
})
@Import(StringToDateConverter.class)
public static class TestApplication {
    @Bean
    public ConversionService conversionService(StringToDateConverter stringToDateConverter) {
        ApplicationConversionService conversionService = new ApplicationConversionService();
        conversionService.addConverter(stringToDateConverter);
        return conversionService;
    }
}
```

# Menggunakan Conversion Service
- Conversion Service selain bisa digunakan untuk melakukan konversi tipe data secara otomatis ketika kita menggunakan config properties, tapi juga bisa digunakan secara programmatically untuk melakukan konversi tipe data.
- Caranya cukup kita ambil object ConversionService.
- Kode: Menggunakan Conversion Service
```java
@Autowired
private ConversionService conversionService;

@Test
void testConversionService() {
    Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));
    Assertions.assertEquals(Duration.ofSeconds(10), conversionService.convert("10s", Duration.class));
}
```