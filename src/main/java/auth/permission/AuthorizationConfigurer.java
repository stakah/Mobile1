package auth.permission;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import app.dao.UserDAO;
import app.entity.User;

/**
 * Classe que configura o WebSecurity, possibilitando requerer que o
 * usuário esteja logado para acessar qualquer usuário
 * 
 * @author Techne
 *
 */
@Configuration
@EnableWebSecurity
public class AuthorizationConfigurer extends WebSecurityConfigurerAdapter {
  
  /**
   * Instância do authenticationProvider
   * 
   * @see auth.permission.AuthenticationConfigurer
   */
  @Autowired
  private AuthenticationConfigurer authenticationProvider;
  
  @Autowired
  private SecurityPermission securityPermission;
  
  @Autowired
  private UserDAO userRepository;
  
  /**
   * Método que configura o SpringSecurite com o authenticationProvider,
   * responsável também pela criação da base inicial, caso não exista nenhuma
   * permissão cadastrada
   * 
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider);
  }
  
  /**
   * Configurações default para WebSecurity
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    // post sem csrf
    http.csrf().disable();
    
    // session manager
    http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(false).expiredUrl("/index.html").and()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).invalidSessionUrl("/index.html");
    
    // load Security Permission
    securityPermission.loadSecurityPermission(http);
    
    // login/logout
    http.formLogin().loginProcessingUrl("/auth").loginPage("/index.html").successHandler(successHandler())
            .failureHandler(failureHandler()).and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .invalidateHttpSession(true);
    
  }
  
  /**
   * Handler para sucesso de autorização
   */
  private AuthenticationSuccessHandler successHandler() {
    return new AuthenticationSuccessHandler() {
      @Override
      public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp,
                                          Authentication authentication)
              throws IOException, ServletException {
        
        HttpSession session = req.getSession();
        org.springframework.security.core.userdetails.User authUser = (org.springframework.security.core.userdetails.User)SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", authUser.getUsername());
        session.setAttribute(SecurityPermission.AUTHORITIES_ATTRIBUTE, authentication.getAuthorities());
        
        resp.setStatus(HttpServletResponse.SC_OK);
        
        String roles = authUser.getAuthorities().toString().replaceFirst("\\[", "").replaceFirst("\\]", "");
        
        System.out.println("[auth] authUser.username=" + authUser.getUsername());
        System.out.println("[auth] authentication.getAuthorities():" + authentication.getAuthorities());
        List<User> users = userRepository.findByLogin(authUser.getUsername(), new PageRequest(0, 100)).getContent();
        System.out.println("[auth] users.size=" + users.size());
        User user = new User();
        
        String id = "-1";
        if(!users.isEmpty()) {
          user = users.get(0);
          id = user.getId();
        }
        
        String theme = session.getAttribute("theme").toString();
        String str = String.format(
                "{\"name\":\"%s\",\"id\":\"%s\",\"login\":\"%s\",\"roles\":\"%s\",\"root\":%s,\"theme\":\"%s\"}",
                user.getName(), id, authUser.getUsername(), roles,
                roles.contains(SecurityPermission.ROLE_ADMIN_NAME), theme);
        System.out.println(str);
        resp.getWriter().print(str);
        
        //resp.getOutputStream().print(str);
        resp.setHeader("Content-Type", "application/json");
        
      }
      
    };
  }
  
  /**
   * Handler para falha de autorização
   */
  private AuthenticationFailureHandler failureHandler() {
    return new AuthenticationFailureHandler() {
      @Override
      public void onAuthenticationFailure(HttpServletRequest hsr, HttpServletResponse hsr1, AuthenticationException ae)
              throws IOException, ServletException {
        hsr1.setStatus(HttpStatus.UNAUTHORIZED.value());
      }
    };
  }
  
}
