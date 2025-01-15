# Mengubah Profile
- Selain mengubah active profile menggunakan application properties, kita juga bisa menggunakan command line argument untuk mengubah active profile.
- Kita bisa gunakan argument :
  ``` --spring.profiles.active=first,second  ```
- Kode: Mengubah Active Profile
``` java -jar target/belajar-spring-config-properties-0.0.1-SNAPSHOT.jar --spring.profiles.active=production,test ```