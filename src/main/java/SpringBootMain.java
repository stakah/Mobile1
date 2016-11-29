import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.web.*;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Classe responsável iniciar a aplicação, por padrão ela executará as seguintes etapas:
 *  - Criar uma instância do ApplicationContext
 *  - Registrar um CommandLinePropertySource para expor argumentos como propriedades do Spring
 *  - Atualizar o contexto de aplicação para carregar os singletons
 *  - Executar qualquer bean do tipo CommandLineRunner 
 * 
 *
 */
@ComponentScan(basePackages = {
"auth.permission", "api.rest.events", "app", "aol"
})
//@EnableJpaRepositories("aol.dao")
@SpringBootApplication
public class SpringBootMain extends SpringBootServletInitializer {
  
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }

}


