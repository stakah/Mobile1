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
 * Controller para expor serviços REST de MenuItem
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/metadata/MenuItem")
public class MenuItemREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("MenuItemBusiness")
    private MenuItemBusiness menuItemBusiness;

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
      @Qualifier("SubmenuItemsBusiness")
      private SubmenuItemsBusiness submenuItemsBusiness;
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
    public MenuItem post(@Validated @RequestBody final MenuItem entity) throws Exception {
        return menuItemBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public MenuItem put(@Validated @RequestBody final MenuItem entity) throws Exception {
        return menuItemBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public MenuItem put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final MenuItem entity) throws Exception {
        return menuItemBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        menuItemBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<MenuItem>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(menuItemBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SubmenuItems")    
  public HttpEntity<PagedResources<SubmenuItems>> findSubmenuItems(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuItemBusiness.findSubmenuItems(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/SubmenuItems/{relationId}")    
  public void deleteSubmenuItems(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.submenuItemsBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/SubmenuItems/{relationId}")
  public SubmenuItems putSubmenuItems(@Validated @RequestBody final SubmenuItems entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.submenuItemsBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/SubmenuItems")
  public SubmenuItems postSubmenuItems(@Validated @RequestBody final SubmenuItems entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	MenuItem menuItemParent = this.menuItemBusiness.get(instanceId);
	entity.setMenuItemParent(menuItemParent);
	return this.submenuItemsBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SubmenuItems_2")    
  public HttpEntity<PagedResources<SubmenuItems>> findSubmenuItems_2(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuItemBusiness.findSubmenuItems_2(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/SubmenuItems_2/{relationId}")    
  public void deleteSubmenuItems_2(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.submenuItemsBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/SubmenuItems_2/{relationId}")
  public SubmenuItems putSubmenuItems_2(@Validated @RequestBody final SubmenuItems entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.submenuItemsBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/SubmenuItems_2")
  public SubmenuItems postSubmenuItems_2(@Validated @RequestBody final SubmenuItems entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	MenuItem menuItemChild = this.menuItemBusiness.get(instanceId);
	entity.setMenuItemChild(menuItemChild);
	return this.submenuItemsBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SubmenuItems_3")    
  public HttpEntity<PagedResources<SubmenuItems>> findSubmenuItems_3(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuItemBusiness.findSubmenuItems_3(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/SubmenuItems_3/{relationId}")    
  public void deleteSubmenuItems_3(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.submenuItemsBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/SubmenuItems_3/{relationId}")
  public SubmenuItems putSubmenuItems_3(@Validated @RequestBody final SubmenuItems entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.submenuItemsBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/SubmenuItems_3")
  public SubmenuItems postSubmenuItems_3(@Validated @RequestBody final SubmenuItems entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	MenuItem menuItemParent = this.menuItemBusiness.get(instanceId);
	entity.setMenuItemParent(menuItemParent);
	return this.submenuItemsBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/SubmenuItems_4")    
  public HttpEntity<PagedResources<SubmenuItems>> findSubmenuItems_4(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuItemBusiness.findSubmenuItems_4(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/SubmenuItems_4/{relationId}")    
  public void deleteSubmenuItems_4(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.submenuItemsBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/SubmenuItems_4/{relationId}")
  public SubmenuItems putSubmenuItems_4(@Validated @RequestBody final SubmenuItems entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.submenuItemsBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/SubmenuItems_4")
  public SubmenuItems postSubmenuItems_4(@Validated @RequestBody final SubmenuItems entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	MenuItem menuItemChild = this.menuItemBusiness.get(instanceId);
	entity.setMenuItemChild(menuItemChild);
	return this.submenuItemsBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/MenuItems")    
  public HttpEntity<PagedResources<MenuItems>> findMenuItems(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(menuItemBusiness.findMenuItems(instanceId,  pageable )), HttpStatus.OK);
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
	MenuItem menuItem = this.menuItemBusiness.get(instanceId);
	entity.setMenuItem(menuItem);
	return this.menuItemsBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Menu")
  public HttpEntity<PagedResources<Menu>> listMenu(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(menuItemBusiness.listMenu(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Menu")
  public MenuItem postMenu(@Validated @RequestBody final Menu entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      MenuItems newMenuItems = new MenuItems();

      MenuItem instance = this.menuItemBusiness.get(instanceId);

      newMenuItems.setMenu(entity);
      newMenuItems.setMenuItem(instance);
      
      this.menuItemsBusiness.post(newMenuItems);

      return newMenuItems.getMenuItem();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Menu/{relationId}")
  public void deleteMenu(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.menuItemBusiness.deleteMenu(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public MenuItem get(@PathVariable("id") java.lang.String id) throws Exception {
        return menuItemBusiness.get(id);
    }
}
