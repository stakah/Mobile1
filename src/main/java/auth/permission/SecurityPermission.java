package auth.permission;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

/**
 * Classe que configura as permissões de acesso
 * 
 * @author Techne
 *
 */
@Component
public class SecurityPermission {
  
  public static final String ROLE_ADMIN_NAME = "Administrators";
  
  public void loadSecurityPermission(HttpSecurity http) throws Exception {
    
    // public
    http.authorizeRequests().antMatchers("/index.html").permitAll();
    http.authorizeRequests().antMatchers("/favicon.ico").permitAll();
    http.authorizeRequests().antMatchers("/public/**").permitAll();
    http.authorizeRequests().antMatchers("/plugins/**").permitAll();
    http.authorizeRequests().antMatchers("/components/**").permitAll();
    http.authorizeRequests().antMatchers("/js/**").permitAll();
    http.authorizeRequests().antMatchers("/lib/**").permitAll();
    http.authorizeRequests().antMatchers("/css/**").permitAll();
    http.authorizeRequests().antMatchers("/img/**").permitAll();
    http.authorizeRequests().antMatchers("/i18n/**").permitAll();
    http.authorizeRequests().antMatchers("/views/login.view.html").permitAll();
    http.authorizeRequests().antMatchers("/views/error/**").permitAll();
    
    // role admin permission
    http.authorizeRequests().antMatchers("/views/admin/**").hasAuthority(ROLE_ADMIN_NAME);
    http.authorizeRequests().antMatchers("/api/security/**").hasAuthority(ROLE_ADMIN_NAME);
    
    // role logged permission
    http.authorizeRequests().antMatchers("/views/logged/**").authenticated();
    http.authorizeRequests().antMatchers("/api/rest/**").authenticated();
    http.authorizeRequests().antMatchers("POST", "/changePassword").authenticated();
    http.authorizeRequests().antMatchers("POST", "/changeTheme").authenticated();
    
    // deny all
    http.authorizeRequests().antMatchers("/**").denyAll();
    
  }
  
}
