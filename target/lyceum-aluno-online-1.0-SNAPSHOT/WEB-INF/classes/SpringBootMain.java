import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
/**
 * Classe responsável iniciar a aplicação, por padrão ela executará as seguintes etapas:
 *  - Criar uma instância do ApplicationContext;
 *  - Registrar um CommandLinePropertySource para expor argumentos como propriedades do Spring;
 *  - Atualizar o contexto de aplicação para carregar os singletons;
 *  - Executar qualquer bean do tipo CommandLineRunner;
 */
@ComponentScan(basePackages = {
  "auth.permission", "api.rest.events", "aol", "app", "metadata"
})
@SpringBootApplication
public class SpringBootMain extends SpringBootServletInitializer {
  
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }

}
