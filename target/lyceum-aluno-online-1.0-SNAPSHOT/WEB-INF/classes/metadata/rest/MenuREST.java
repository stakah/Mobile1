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
 * Controller para expor serviços REST de Menu
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "meta/menu/Menu")
public class MenuREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
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
     * @generated
     */
      @Autowired
      @Qualifier("MenuItemsBusiness")
      private MenuItemsBusiness menuItemsBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Menu post(@Validated @RequestBody final Menu entity) throws Exception {
        return menuBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Menu put(@Validated @RequestBody final Menu entity) throws Exception {
        return menuBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Menu put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Menu entity) throws Exception {
        return menuBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        menuBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Menu>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(menuBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/MenuItems")    
  public HttpEntity<PagedResources<MenuItems>> findMenuItems(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuBusiness.findMenuItems(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/MenuItems/{relationId}")    
  public void deleteMenuItems(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.menuItemsBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/MenuItems/{relationId}")
  public MenuItems putMenuItems(@Validated @RequestBody final MenuItems entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.menuItemsBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/MenuItems")
  public MenuItems postMenuItems(@Validated @RequestBody final MenuItems entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Menu menu = this.menuBusiness.get(instanceId);
	entity.setMenu(menu);
	return this.menuItemsBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/MenuItem")
  public HttpEntity<PagedResources<MenuItem>> listMenuItem(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(menuBusiness.listMenuItem(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/MenuItem")
  public Menu postMenuItem(@Validated @RequestBody final MenuItem entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      MenuItems newMenuItems = new MenuItems();

      Menu instance = this.menuBusiness.get(instanceId);

      newMenuItems.setMenuItem(entity);
      newMenuItems.setMenu(instance);
      
      this.menuItemsBusiness.post(newMenuItems);

      return newMenuItems.getMenu();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/MenuItem/{relationId}")
  public void deleteMenuItem(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.menuBusiness.deleteMenuItem(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Menu get(@PathVariable("id") java.lang.String id) throws Exception {
        return menuBusiness.get(id);
    }
}
