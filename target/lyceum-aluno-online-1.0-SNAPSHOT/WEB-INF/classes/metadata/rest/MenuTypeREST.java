package metadata.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import metadata.entity.*;
import metadata.business.*;



/**
 * Controller para expor serviços REST de MenuType
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/metadata/MenuType")
public class MenuTypeREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("MenuTypeBusiness")
    private MenuTypeBusiness menuTypeBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("MenuBusiness")
      private MenuBusiness menuBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("MenuItemBusiness")
      private MenuItemBusiness menuItemBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public MenuType post(@Validated @RequestBody final MenuType entity) throws Exception {
        return menuTypeBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public MenuType put(@Validated @RequestBody final MenuType entity) throws Exception {
        return menuTypeBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public MenuType put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final MenuType entity) throws Exception {
        return menuTypeBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        menuTypeBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<MenuType>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(menuTypeBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Menu")    
  public HttpEntity<PagedResources<Menu>> findMenu(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuTypeBusiness.findMenu(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Menu/{relationId}")    
  public void deleteMenu(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.menuBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Menu/{relationId}")
  public Menu putMenu(@Validated @RequestBody final Menu entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.menuBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Menu")
  public Menu postMenu(@Validated @RequestBody final Menu entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	MenuType menuType = this.menuTypeBusiness.get(instanceId);
	entity.setMenuType(menuType);
	return this.menuBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/MenuItem")    
  public HttpEntity<PagedResources<MenuItem>> findMenuItem(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuTypeBusiness.findMenuItem(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/MenuItem/{relationId}")    
  public void deleteMenuItem(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.menuItemBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/MenuItem/{relationId}")
  public MenuItem putMenuItem(@Validated @RequestBody final MenuItem entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.menuItemBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/MenuItem")
  public MenuItem postMenuItem(@Validated @RequestBody final MenuItem entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	MenuType menuType = this.menuTypeBusiness.get(instanceId);
	entity.setMenuType(menuType);
	return this.menuItemBusiness.post(entity);
  }   



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public MenuType get(@PathVariable("id") java.lang.String id) throws Exception {
        return menuTypeBusiness.get(id);
    }
}
