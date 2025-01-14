# Resource
- Sebelum kita belajar tentang Config Properties, kita perlu terlebih dahulu belajar tentang Resource di Spring.
- Di Java terdapat fitur bernama Java IO (Input Output) sebagai management resource.
- Spring membungkus resource dalam sebuah interface bernama Resource.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/Resource.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/Resource.html).
- Walaupun resource adalah sebuah interface, untuk membuatnya kita perlu mengimplementasikan secara manual, sudah banyak implementasi resource di Spring.
- Kode: Resource
```java
var resource = new ClassPathResource("/application.properties");

Assertions.assertNotNull(resource);
System.out.println(resource.getPath());
System.out.println(resource.getFilename());
System.out.println(resource.getFile().getAbsolutePath());
```