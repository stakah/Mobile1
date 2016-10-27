package app.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import app.entity.*;
import app.business.*;



/**
 * Controller para expor serviços REST de Role
 * 
 * @author Usuário de Teste
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/security/Role")
public class RoleREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("RoleBusiness")
    private RoleBusiness roleBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("UserBusiness")
      private UserBusiness userBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("UserRoleBusiness")
      private UserRoleBusiness userRoleBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Role post(@Validated @RequestBody final Role entity) throws Exception {
        return roleBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Role put(@Validated @RequestBody final Role entity) throws Exception {
        return roleBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Role put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Role entity) throws Exception {
        return roleBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        roleBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Role>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(roleBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/UserRole")    
  public HttpEntity<PagedResources<UserRole>> findUserRole(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(roleBusiness.findUserRole(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/UserRole/{relationId}")    
  public void deleteUserRole(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.userRoleBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/UserRole/{relationId}")
  public UserRole putUserRole(@Validated @RequestBody final UserRole entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.userRoleBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/UserRole")
  public UserRole postUserRole(@Validated @RequestBody final UserRole entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Role role = this.roleBusiness.get(instanceId);
	entity.setRole(role);
	return this.userRoleBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/User")
  public HttpEntity<PagedResources<User>> listUser(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(roleBusiness.listUser(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/User")
  public Role postUser(@Validated @RequestBody final User entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      UserRole newUserRole = new UserRole();

      Role instance = this.roleBusiness.get(instanceId);

      newUserRole.setUser(entity);
      newUserRole.setRole(instance);
      
      this.userRoleBusiness.post(newUserRole);

      return newUserRole.getRole();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/User/{relationId}")
  public void deleteUser(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.roleBusiness.deleteUser(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Role get(@PathVariable("id") java.lang.String id) throws Exception {
        return roleBusiness.get(id);
    }
}
