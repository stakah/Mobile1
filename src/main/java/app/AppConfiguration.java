package app;

import auth.permission.SecurityPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Classe que configura os beans para persistencia
 * 
 * @author Usuário de Teste
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "app-EntityManagerFactory",
        transactionManagerRef = "app-TransactionManager"
)
class AppConfiguration {
   	private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    @Primary

    @Bean(name="app-EntityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("app");
        return factoryBean;
    }

    @Bean(name = "app-TransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
  
    //Criando dinamicamente os dados do App
    Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
    URL url = this.getClass().getClassLoader().getResource("classpath:src/main/java/app/populate.json");

//        LOGGER.info("Jackson2Repo url=" + url.toString());

        String strJSON = "[" +
                "{" +
                "     \"_class\": \"app.entity.User\", " +
                "         \"id\": \"304BF43E-0E62-4F4A-8A63-3F22D7AD4611\", " +
                "       \"name\": \"admin\", " +
                "      \"login\": \"admin\", " +
                "   \"password\": \"$2a$10$LjzpM1Q3VoAtG2dTCCabNuW0/amVPjL3Iyvyi2Dj7NP.HngtzSewu\"" +
                "}," +
                "{" +
                "     \"_class\": \"app.entity.Role\"," +
                "         \"id\": \"404BF43E-0000-4F4A-8A63-3F22D7AD6556\"," +
                "       \"name\": \"Administrators\"" +
                "}," +
                "{" +
                "     \"_class\": \"app.entity.Role\"," +
                "         \"id\": \"404BF43E-0000-4F4A-8A63-3E22D7AD6540\"," +
                "       \"name\": \"Meta\"" +
                "}," +
                "{" +
                "     \"_class\": \"app.entity.UserRole\"," +
                "         \"id\": \"404BF43E-0E62-4F4A-8A63-3F22D7AD6556\"," +
                "       \"user\": { \"id\" : \"304BF43E-0E62-4F4A-8A63-3F22D7AD4611\" } ," +
                "       \"role\": { \"id\" : \"404BF43E-0000-4F4A-8A63-3F22D7AD6556\" }" +
                "}," +
                "{" +
                "     \"_class\": \"app.entity.UserRole\"," +
                "         \"id\": \"404BF43E-0E62-4F4A-8A63-3E22D7AD6530\"," +
                "       \"user\": { \"id\" : \"304BF43E-0E62-4F4A-8A63-3F22D7AD4611\" } ," +
                "       \"role\": { \"id\" : \"404BF43E-0000-4F4A-8A63-3E22D7AD6540\" }" +
                "}" +
                "]";

    if (url != null) {
      File file = new File(url.getFile());

      try {
        Scanner scanner = new Scanner(file);
        strJSON = scanner.useDelimiter("\\A").next();
        scanner.close();
      } catch (Exception e) {
      }
    }

    strJSON = strJSON.replaceAll(Pattern.quote("{{ROLE_ADMIN_NAME}}"), SecurityPermission.ROLE_ADMIN_NAME);
    //strJSON = strJSON.replaceAll(Pattern.quote("{{ROLE_META_NAME}}"), SecurityPermission.ROLE_META_NAME);

    LOGGER.info("strJSON=" + strJSON.toString());
    Resource sourceData = new InputStreamResource(new java.io.ByteArrayInputStream(strJSON.getBytes()));
    factory.setResources(new Resource[] { sourceData });

    return factory;
  
    }
    
}