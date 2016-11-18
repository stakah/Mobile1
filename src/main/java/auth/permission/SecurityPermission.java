package auth.permission;

import org.springframework.beans.factory.annotation.Autowired;
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
  public static final String AUTHORITIES_ATTRIBUTE = "authorities";
  //private static final String APP_BASE = "/Mobile1-1.0-SNAPSHOT";
  private static final String APP_BASE = "";


  public void loadSecurityPermission(HttpSecurity http) throws Exception {


    // public
    http.authorizeRequests().antMatchers(APP_BASE + "/index.html").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/favicon.ico").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/public/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/plugins/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/components/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/js/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/lib/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/css/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/img/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/i18n/**").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/views/login.view.html").permitAll();
    http.authorizeRequests().antMatchers(APP_BASE + "/views/error/**").permitAll();
    
    // role admin permission
    //http.authorizeRequests().antMatchers("/views/admin/**").hasAuthority(ROLE_ADMIN_NAME);
    http.authorizeRequests().antMatchers(APP_BASE + "/api/security/**").hasAuthority(ROLE_ADMIN_NAME);

    // role logged permission
    http.authorizeRequests().antMatchers(APP_BASE + "/views/admin/**").hasAuthority(ROLE_ADMIN_NAME);
    http.authorizeRequests().antMatchers(APP_BASE + "/views/logged/**").authenticated();
    http.authorizeRequests().antMatchers(APP_BASE + "/api/rest/**").authenticated();
    http.authorizeRequests().antMatchers(APP_BASE + "POST", "/changePassword").authenticated();
    http.authorizeRequests().antMatchers(APP_BASE + "POST", "/changeTheme").authenticated();
    http.authorizeRequests().antMatchers(APP_BASE + "/resources/**").authenticated();
    http.authorizeRequests().antMatchers(APP_BASE + "/api/rest/aol/**").authenticated();

    // deny all
    //http.authorizeRequests().antMatchers(APP_BASE + "/**").denyAll();

    http.authorizeRequests().antMatchers(APP_BASE + "/**").authenticated();
  }
  
}
