# Resource Loader
- Spring memiliki fitur yang bisa kita gunakan untuk mengambil data resource secara otomatis tanpa harus membuat objek resource-nya, namanya ResourceLoader.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/ResourceLoader.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/io/ResourceLoader.html).
- ResourceLoader memiliki method bernama ``` getResource(string) ``` yang bisa kita gunakan untuk mengambil sebuah resource.
- ResourceLoader akan mendeteksi jenis Resource yang butuh diambil dari data String-nya.

# Resource Protocol
| Prefix     | Sample                                         | Description                                     |
|------------|------------------------------------------------|-------------------------------------------------|
| classpath: | classpath:/com/pzn/application.properties      | Mengambil resource dari classpath (isi project) |
| file       | file:///Users/khannedy/file.properties         | Mengambil resource dari file system             |
| https:     | https://www.programmerzamannow/file.properties | Mengambil resource dari http                    |

# Resource Loader Aware
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