# Externalized Properties File
- Saat aplikasi Spring Boot kita sudah selesai, semua config properties akan dibungkus di dalam jar file.
- Pertanyaannya bagaimana jika kita ingin mengubah isi informasi nya?.
- Misal konfigurasi database tidak mungkin kita simpan di dalam kode program.
- Ada beberapa cara untuk menggunakan configuration dari luar aplikasi, ketika aplikasi kita sudah menjadi jar file.

# External Properties File
- Pertama kita bisa membuat application.properties file dari luar, lalu ketika menjalankan aplikasi Jar Spring Boot kita, kita bisa menyebutkan lokasi application.properties nya.
- Caranya kita bisa gunakan perintah:
  ``` java -jar lokasi/file.jar --spring.config.location=lokasi/file/application.properties ```
- Kode: Contoh Program Sederhana
```java
@Slf4j
@Component
@AllArgsConstructor
public class ApplicationPropertiesRunner implements ApplicationRunner {
    private ApplicationProperties applicationProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(applicationProperties.getName());
        log.info(String.valueOf(applicationProperties.getVersion()));
        log.info(String.valueOf(applicationProperties.isProductionMode()));
    }
}
```
- Kode: Contoh External Application Properties
```text
application.name=Spring Boot Application
application.version=1
application.production-mode=false
```