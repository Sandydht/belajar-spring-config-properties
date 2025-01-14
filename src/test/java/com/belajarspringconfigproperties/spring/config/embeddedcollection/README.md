# Embedded Collection
- Configuration Properties juga mendukung jika kita membuat Java Bean di dalam collection
- Kode: Embedded Collection
```java
@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {
    private List<Role> whitelistTables;
    private Map<String, Role> maxTablesSize;
}

@Setter
@Getter
public class RoleProperties {
    private String id;
    private String name;
}
```
- Kode: Application Properties
```text
application.default-roles[0].id=default
application.default-roles[0].name=Default Role
application.default-roles[1].id=guest
application.default-roles[1].name=Guest Role

application.roles.admin.id=admin
application.roles.admin.name=Admin Role
application.roles.finance.id=finance
application.roles.finance.name=Finance Role
```
- Kode: Unit Test Embedded Collection Properties
```java
@Test
void testEmbeddedCollectionProperties() {
    Assertions.assertEquals("default", applicationProperties.getDefaultRoles().get(0).getId());
    Assertions.assertEquals("Default Role", applicationProperties.getDefaultRoles().get(0).getName());
    Assertions.assertEquals("guest", applicationProperties.getDefaultRoles().get(1).getId());
    Assertions.assertEquals("Guest Role", applicationProperties.getDefaultRoles().get(1).getName());

    Assertions.assertEquals("admin", applicationProperties.getRoles().get("admin").getId());
    Assertions.assertEquals("Admin Role", applicationProperties.getRoles().get("admin").getName());
    Assertions.assertEquals("finance", applicationProperties.getRoles().get("finance").getId());
    Assertions.assertEquals("Finance Role", applicationProperties.getRoles().get("finance").getName());
}
```