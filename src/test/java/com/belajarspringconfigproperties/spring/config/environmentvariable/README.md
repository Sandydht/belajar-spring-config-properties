# Environment Variable
- Saat kita menggunakan external properties file, properties file yang ada di dalam Jar tidak akan digunakan.
- Hal ini menyebabkan kita harus menulis ulang semua properties key yang ada di properties file, dan kadang jika isinya terlalu banyak, ini sangat menyulitkan.
- Spring Boot juga mendukung mengambil properties dari environment variable.
- Hal ini membuat kita lebih mudah, karena tidak harus semua properties dibuat ulang di file external properties, cukup yang dibutuhkan aja.
- Selain itu, kita juga bisa membuat default value ketika environment variable nya tidak ada.
- Kode: Properties File
```text
application.name=${APPLICATION_NAME:Belajar Spring Boot}
application.version=${APPLICATION_VERSION:1}
application.production-mode=${APPLICATION_PRODUCTION_MODE:false}
application.default-timeout=1s
application.expire-date=2025-10-10
```
- Kode: Menjalankan Dengan Environment Variable
``` export APPLICATION_NAME="Spring Boot Application" ```
``` export APPLICATION_VERSION="1" ```
``` export APPLICATION_PRODUCTION_MODE="true" ```
``` java -jar target/belajar-spring-config-properties-0.0.1-SNAPSHOT.jar ```