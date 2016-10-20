# SpringBoot

Aplicação Web com Spring e módulos: **Data** e **Security**.

## Prérequisitos

1. Maven 3+
2. Java 8+

## Como rodar

1. Baixe seu projeto do ide em 
2. Descompacte
3. Entre na pasta
4. Execute 

```
mvn spring-boot:run -Dserver.port=8080

```
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.3.4.RELEASE)

2016-05-12 13:59:13.867  INFO 21395 --- [           main] SpringBootMain                           : Starting SpringBootMain on spring.local with PID 21395 (/Users/humbertodias/Downloads/1/target/classes started by humbertodias in /Users/humbertodias/Downloads/1)
2016-05-12 13:59:13.873  INFO 21395 --- [           main] SpringBootMain                           : No active profile set, falling back to default profiles: default
2016-05-12 13:59:13.969  INFO 21395 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@4a8efde4: startup date [Thu May 12 13:59:13 BRT 2016]; root of context hierarchy
2016-05-12 13:59:16.268  INFO 21395 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [class org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$66d0011c] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2016-05-12 13:59:17.177  INFO 21395 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2016-05-12 13:59:17.201  INFO 21395 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2016-05-12 13:59:17.202  INFO 21395 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.0.33
2016-05-12 13:59:17.331  INFO 21395 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2016-05-12 13:59:17.332  INFO 21395 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3369 ms
2016-05-12 13:59:17.852  INFO 21395 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'characterEncodingFilter' to: [/*]
2016-05-12 13:59:17.853  INFO 21395 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2016-05-12 13:59:17.853  INFO 21395 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2016-05-12 13:59:17.853  INFO 21395 --- [ost-startStop-1] o.s.b.c.embedded.FilterRegistrationBean  : Mapping filter: 'requestContextFilter' to: [/*]
2016-05-12 13:59:17.855  INFO 21395 --- [ost-startStop-1] .e.DelegatingFilterProxyRegistrationBean : Mapping filter: 'springSecurityFilterChain' to: [/*]
2016-05-12 13:59:17.856  INFO 21395 --- [ost-startStop-1] o.s.b.c.e.ServletRegistrationBean        : Mapping servlet: 'dispatcherServlet' to [/]
2016-05-12 13:59:18.252  INFO 21395 --- [ost-startStop-1] o.s.o.jpa.LocalEntityManagerFactoryBean  : Building JPA EntityManagerFactory for persistence unit 'security'
...
2016-05-12 13:59:23.825  INFO 21395 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2016-05-12 13:59:24.002  INFO 21395 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2016-05-12 13:59:24.016  INFO 21395 --- [           main] SpringBootMain                           : Started SpringBootMain in 10.707 seconds (JVM running for 15.344)
```
5. Por fim, acesse pelo navegador

[http://localhost:8080](http://localhost:8080)


## Referências

[Spring Boot Reference Guide](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/)

[SpringBoot Initializer](https://start.spring.io/)
