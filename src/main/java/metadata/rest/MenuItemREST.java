package metadata.rest;


import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.persistence.*;

import metadata.rest.util.*;

import metadata.dao.*;
import metadata.entity.*;
import metadata.business.*;
import metadata.rest.exceptions.*;
import javax.servlet.http.HttpServletRequest;


/**
 * Publicando metodos de negocio via REST
 * @generated
 **/
@Path("/MenuItem")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MenuItemREST implements RESTService<MenuItem> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private MenuItemBusiness business;
  /**
   * @generated
   */
  private MenuBusiness menuBusiness;
  /**
   * @generated
   */
  private SubmenuItemsBusiness submenuItemsBusiness;
  /**
   * @generated
   */
  private MenuItemsBusiness menuItemsBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public MenuItemREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new MenuItemBusiness(session);
    this.menuBusiness = new MenuBusiness(session);
    this.submenuItemsBusiness = new SubmenuItemsBusiness(session);
    this.menuItemsBusiness = new MenuItemsBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(MenuItem entity) {
    try {
	    session.begin();
	    business.save(entity);
	    session.commit();
	    business.refresh(entity);
	    return Response.ok(entity).build();
    }
    
    catch(Exception exception){
	    session.rollBack();
        throw new CustomWebApplicationException(exception);
    }
  }

  /**
   * @generated
   */
  @PUT
  public Response put(MenuItem entity) {
    try {
	    session.begin();
	    MenuItem updatedEntity = business.update(entity);
	    session.commit();
	    return Response.ok(updatedEntity).build();
    }
    
    catch(Exception exception){
	    session.rollBack();
        throw new CustomWebApplicationException(exception);
    }  
  }
  
  /**
   * @generated
   */  
  @PUT
  @Path("/{id}")
  public Response putWithId(MenuItem entity) {
    try {
	    session.begin();
	    MenuItem updatedEntity = business.update(entity);
	    session.commit();
	    return Response.ok(updatedEntity).build();
    }
    
    catch(Exception exception){
	    session.rollBack();
        throw new CustomWebApplicationException(exception);
    }  
  }
  
  /**
   * @generated
   */  
  @DELETE
  public Response delete(MenuItem entity) {  
		try {
			session.begin();
			MenuItem updatedEntity = business.update(entity);
			business.delete(updatedEntity);
			session.commit();
			return Response.ok().build();
		}

		catch (Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);
		}    
  } 
   
  /**
   * @generated
   */    
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") java.lang.String id) {  
		try {
			session.begin();
			if (business.deleteById(id) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				return Response.status(404).build();
			}
		}

		catch (Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);
		}    
  }
  
  
  
  /**
   * OneToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/SubmenuItems")
  public GenericEntity<List<SubmenuItems>> findSubmenuItems(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<SubmenuItems>>(this.business.findSubmenuItems(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/SubmenuItems/{relationId}")
  public Response deleteSubmenuItems(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.submenuItemsBusiness.deleteById(relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @PUT
  @Path("/{instanceId}/SubmenuItems/{relationId}")
  public Response putSubmenuItems(SubmenuItems entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			SubmenuItems updatedEntity = this.submenuItemsBusiness.update(entity);
			session.commit();
			return Response.ok(updatedEntity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/SubmenuItems")
  public Response postSubmenuItems(SubmenuItems entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItem menuItemParent = this.business.findById(instanceId);
			entity.setMenuItemParent(menuItemParent);
			this.submenuItemsBusiness.save(entity);
			session.commit();
			this.submenuItemsBusiness.refresh(entity);
			return Response.ok(entity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  
  /**
   * OneToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/SubmenuItems_2")
  public GenericEntity<List<SubmenuItems>> findSubmenuItems_2(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<SubmenuItems>>(this.business.findSubmenuItems_2(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/SubmenuItems_2/{relationId}")
  public Response deleteSubmenuItems_2(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.submenuItemsBusiness.deleteById(relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @PUT
  @Path("/{instanceId}/SubmenuItems_2/{relationId}")
  public Response putSubmenuItems_2(SubmenuItems entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			SubmenuItems updatedEntity = this.submenuItemsBusiness.update(entity);
			session.commit();
			return Response.ok(updatedEntity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/SubmenuItems_2")
  public Response postSubmenuItems_2(SubmenuItems entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItem menuItemChild = this.business.findById(instanceId);
			entity.setMenuItemChild(menuItemChild);
			this.submenuItemsBusiness.save(entity);
			session.commit();
			this.submenuItemsBusiness.refresh(entity);
			return Response.ok(entity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  
  /**
   * OneToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/SubmenuItems_3")
  public GenericEntity<List<SubmenuItems>> findSubmenuItems_3(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<SubmenuItems>>(this.business.findSubmenuItems_3(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/SubmenuItems_3/{relationId}")
  public Response deleteSubmenuItems_3(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.submenuItemsBusiness.deleteById(relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @PUT
  @Path("/{instanceId}/SubmenuItems_3/{relationId}")
  public Response putSubmenuItems_3(SubmenuItems entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			SubmenuItems updatedEntity = this.submenuItemsBusiness.update(entity);
			session.commit();
			return Response.ok(updatedEntity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/SubmenuItems_3")
  public Response postSubmenuItems_3(SubmenuItems entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItem menuItemParent = this.business.findById(instanceId);
			entity.setMenuItemParent(menuItemParent);
			this.submenuItemsBusiness.save(entity);
			session.commit();
			this.submenuItemsBusiness.refresh(entity);
			return Response.ok(entity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  
  /**
   * OneToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/SubmenuItems_4")
  public GenericEntity<List<SubmenuItems>> findSubmenuItems_4(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<SubmenuItems>>(this.business.findSubmenuItems_4(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/SubmenuItems_4/{relationId}")
  public Response deleteSubmenuItems_4(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.submenuItemsBusiness.deleteById(relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @PUT
  @Path("/{instanceId}/SubmenuItems_4/{relationId}")
  public Response putSubmenuItems_4(SubmenuItems entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			SubmenuItems updatedEntity = this.submenuItemsBusiness.update(entity);
			session.commit();
			return Response.ok(updatedEntity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/SubmenuItems_4")
  public Response postSubmenuItems_4(SubmenuItems entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItem menuItemChild = this.business.findById(instanceId);
			entity.setMenuItemChild(menuItemChild);
			this.submenuItemsBusiness.save(entity);
			session.commit();
			this.submenuItemsBusiness.refresh(entity);
			return Response.ok(entity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  
  /**
   * OneToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/MenuItems")
  public GenericEntity<List<MenuItems>> findMenuItems(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<MenuItems>>(this.business.findMenuItems(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/MenuItems/{relationId}")
  public Response deleteMenuItems(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.menuItemsBusiness.deleteById(relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @PUT
  @Path("/{instanceId}/MenuItems/{relationId}")
  public Response putMenuItems(MenuItems entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			MenuItems updatedEntity = this.menuItemsBusiness.update(entity);
			session.commit();
			return Response.ok(updatedEntity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/MenuItems")
  public Response postMenuItems(MenuItems entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItem menuItem = this.business.findById(instanceId);
			entity.setMenuItem(menuItem);
			this.menuItemsBusiness.save(entity);
			session.commit();
			this.menuItemsBusiness.refresh(entity);
			return Response.ok(entity).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/Menu")
  public GenericEntity<List<Menu>> listMenu(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Menu>>(this.business.listMenu(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Menu")
  public Response postMenu(Menu entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItems newMenuItems = new MenuItems();

			MenuItem instance = this.business.findById(instanceId);


			newMenuItems.setMenu(entity);
			newMenuItems.setMenuItem(instance);
			
			this.menuItemsBusiness.save(newMenuItems);
			session.commit();
			this.menuItemsBusiness.refresh(newMenuItems);
			return Response.ok(newMenuItems.getMenuItem()).build();
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }   
  
  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/Menu/{relationId}")
  public Response deleteMenu(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteMenu(instanceId, relationId) > 0) {
				session.commit();
				return Response.ok().build();
			} else {
				session.rollBack();
				return Response.status(404).build();
			}
		} catch(Exception exception) {
			session.rollBack();
			throw new CustomWebApplicationException(exception);	
		}
  }  
  
  
  /**
   * NamedQuery list
   * @generated
   */
  @GET
  	
  public GenericEntity<List<MenuItem>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<MenuItem>>(business.list(limit, offset)){};

  }
	
}
