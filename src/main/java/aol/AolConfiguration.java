package aol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;
import org.springframework.core.io.*;
import org.springframework.data.repository.init.*;
import java.net.URL;
import java.io.File;
import java.net.URLDecoder;
import java.util.Scanner;
import java.util.regex.Pattern;
import auth.permission.SecurityPermission;


/**
 * Classe que configura os beans para persistencia
 * 
 * @author sergiot
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "aol-EntityManagerFactory",
        transactionManagerRef = "aol-TransactionManager"
)
class AolConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AolConfiguration.class);


    @Bean(name="aol-EntityManagerFactory")
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("aol");
        return factoryBean;
    }

    @Bean(name = "aol-TransactionManager")
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() throws Exception {

        //Criando dinamicamente os dados do App
        Jackson2RepositoryPopulatorFactoryBean factory = new Jackson2RepositoryPopulatorFactoryBean();
        URL url = this.getClass().getClassLoader().getResource("aol/populate.json");

        LOGGER.info("Jackson2Repo url=" + url.toString());
        String strJSON = "";

        if (url != null) {
            File file = new File(URLDecoder.decode(url.getFile(),"UTF-8"));

            try {
                LOGGER.info("url != null:1");
                Scanner scanner = new Scanner(file);
                LOGGER.info("url != null:2");
                strJSON = scanner.useDelimiter("\\A").next();
                LOGGER.info(">>>> strJSON:{" + strJSON + "}");
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