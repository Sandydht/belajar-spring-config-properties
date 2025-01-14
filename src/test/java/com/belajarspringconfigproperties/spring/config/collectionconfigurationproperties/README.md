# Collection Configuration Properties
- Configuration Properties juga mendukung binding properties untuk jenis collection seperti List atau Map.
- Hal ini kadang bermanfaat ketika memang data yang kita butuhkan sangat kompleks, bisa Collection yang berisi data sederhana, atau bahkan collection yang berisi Java Bean lagi.
- Kode: Collection Configuration Properties
```java
@Getter
@Setter
@ConfigurationProperties("application")
public class DatabaseProperties {
    private List<String> whitelistTables;
    private Map<String, Integer> maxTablesSize;
}
```
- Kode: Sample Properties
```text
application.database.username=sandy
application.database.password=rahasia
application.database.database=belajar
application.database.url=jdbc:contoh
#application.database.whitelist-tables=products,customers,categories
application.database.whitelist-tables[0]=products
application.database.whitelist-tables[1]=customers
application.database.whitelist-tables[2]=categories
application.database.max-tables-size.products=100
application.database.max-tables-size.customers=100
application.database.max-tables-size.categories=100
```
- Kode: Sample Properties Dengan Index
```text
#application.database.whitelist-tables=products,customers,categories
application.database.whitelist-tables[0]=products
application.database.whitelist-tables[1]=customers
application.database.whitelist-tables[2]=categories
application.database.max-tables-size.products=100
application.database.max-tables-size.customers=100
application.database.max-tables-size.categories=100
```
- Kode: Unit Test Collection Configuration Properties
```java
@Test
void testCollectionConfigurationProperties() {
    Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), applicationProperties.getDatabase().getWhitelistTables());
    Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("products"));
    Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("customers"));
    Assertions.assertEquals(100, applicationProperties.getDatabase().getMaxTablesSize().get("categories"));
}
```