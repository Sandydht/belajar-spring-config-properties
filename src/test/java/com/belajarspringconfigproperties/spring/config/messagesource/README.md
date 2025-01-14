# Message Resource
- Spring memiliki fitur bernama Message Resource, yaitu fitur untuk mengambil message dari resource.
- [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/MessageSource.html).
- MessageSource mengkombinasikan Properties dan MessageFormat, sehingga kita tidak perlu melakukannya secara manual seperti yang pernah kita praktekan di kelas Java Internationalization.

# Properties
- Pada kelas Java, kita sudah belajar tentang Properties dan juga cara melakukan Internationalization menggunakan Properties.
- Di Spring, kita juga melakukan hal yang sama dengan cara yang lebih baik, tidak perlu melakukannya secara manual.

# Message Resource Implementation
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