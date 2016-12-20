package auth.permission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.business.UserBusiness;
import app.entity.User;

/**
 * Controller responsável por gerir a troca de
 * senha do usuário através de serviço REST
 * 
 * @author Techne
 *
 */
@RestController
@RequestMapping(value = "/changeTheme")
public class ChangeTheme {
  
  @Autowired
  @Qualifier("UserBusiness")
  private UserBusiness userBusiness;
  
  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public User post(final String theme) throws Exception {
    
    org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User)SecurityContextHolder
            .getContext().getAuthentication().getPrincipal();
    
    List<User> users = userBusiness.findByLogin(userDetails.getUsername(), new PageRequest(0, 100)).getContent();
    if(users.size() > 0) {
      User user = users.get(0);
      
      user.setTheme(theme);
      userBusiness.put(user);
      return user;
    }
    
    throw new RuntimeException("Usuario não encontrado!");
  }
}
