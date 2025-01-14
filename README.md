# Pengenalan Config Properties
- Saat kita membuat aplikasi, sudah dipastikan bahwa kita akan menambahkan konfigurasi pada aplikasi kita.
- Misal saja konfigurasi untuk database.
- Spring sendiri memiliki fitur yang sangat baik dalam mendukung pengaturan konfigurasi aplikasi.

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

## Resource Loader
- Spring memiliki fitur yang bisa kita gunakan untuk mengambil data resource secara otomatis tanpa harus membuat objek resource-nya, namanya ResourceLoader.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/ResourceLoader.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/ResourceLoader.html).
- ResourceLoader memiliki method bernama ``` getResource(string) ``` yang bisa kita gunakan untuk mengambil sebuah resource.
- ResourceLoader akan mendeteksi jenis Resource yang butuh diambil dari data String-nya.

## Resource Protocol
| Prefix     | Sample                                         | Description                                     |
|------------|------------------------------------------------|-------------------------------------------------|
| classpath: | classpath:/com/pzn/application.properties      | Mengambil resource dari classpath (isi project) |
| file       | file:///Users/khannedy/file.properties         | Mengambil resource dari file system             |
| https:     | https://www.programmerzamannow/file.properties | Mengambil resource dari http                    |

## Resource Loader Aware 
- ResourceLoader adalah sebuah interface, sehingga untuk menggunakannya kita perlu implementasi class-nya.
- ApplicationContext adalah turunan dari ResourceLoader, sehingga kita juga bisa menggunakan ApplicationContext untuk mendapatkan Resource.
- Atau kita juga bisa menggunakan ResourceLoaderAware untuk mendapatkan ResourceLoader secara otomatis.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ResourceLoaderAware.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ResourceLoaderAware.html).
- Kode: Resource Loader Aware
```java
@SpringBootApplication
public static class TestApplication {
    @Component
    public static class SampleResource implements ResourceLoaderAware {
        @Setter
        private ResourceLoader resourceLoader;

        public String getText() throws IOException {
            Resource resource = resourceLoader.getResource("classpath://resource.txt");
            try (var inputStream = resource.getInputStream()) {
                return new String(inputStream.readAllBytes());
            }
        }
    }
}
```

## Message Resource
- Spring memiliki fitur bernama Message Resource, yaitu fitur untuk mengambil message dari resource.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html).
- MessageSource mengkombinasikan Properties dan MessageFormat, sehingga kita tidak perlu melakukannya secara manual seperti yang pernah kita praktekan di kelas Java Internationalization.

### Properties 
- Pada kelas Java, kita sudah belajar tentang Properties dan juga cara melakukan Internationalization menggunakan Properties.
- Di Spring, kita juga melakukan hal yang sama dengan cara yang lebih baik, tidak perlu melakukannya secara manual.

### Message Resource Implementation
- MessageSource adalah sebuah interface, untuk menggunakannya kita butuh implementasi class-nya.
- Kita tidak butuh membuatnya secara manual, kita bisa menggunakan class implementasi yang sudah disediakan oleh Spring, yaitu ResourceBundleMessageSource.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/ResourceBundleMessageSource.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/ResourceBundleMessageSource.html).
- Kode: Message Resource
```java
@Configuration
public static class TestConfiguration {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("my");
        return messageSource;
    }
}
```
- Kode: Test Message Source
```java
@Test
void testMessageSource() {
    ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    MessageSource messageSource = context.getBean(MessageSource.class);

    String hello = messageSource.getMessage("hello", new Object[]{"Sandy"}, Locale.getDefault());
    Assertions.assertEquals("Hello sandy", hello);
}
```


