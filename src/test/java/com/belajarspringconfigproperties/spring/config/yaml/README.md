# YAML
- Selain menggunakan file properties, Spring Boot juga mendukung penggunaan file Yaml.
- Caranya sangat mudah, kita bisa mengganti semua file properties yang kita gunakan menjadi file Yaml.
- File Yaml sangat mempermudah ketika kita membuat configuration yang sangat kompleks.
- Kode: Contoh File Yaml
```yaml
application:
  name: Belajar Spring Boot
  version: 1
  production-mode: true
```
- Kode: Menjalankan Dengan Yaml
``` java -jar target/belajar-spring-config-properties-0.0.1-SNAPSHOT.jar --spring.config.location=application.yaml ```