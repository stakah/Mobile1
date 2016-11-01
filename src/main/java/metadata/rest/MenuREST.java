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
import javax.servlet.http.HttpSession;

/**
 * Publicando metodos de negocio via REST
 * @generated
 **/
@Path("/Menu")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MenuREST implements RESTService<Menu> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private MenuBusiness business;
  /**
   * @generated
   */
  private MenuItemBusiness menuItemBusiness;
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
  public MenuREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new MenuBusiness(session);
    this.menuItemBusiness = new MenuItemBusiness(session);
    this.menuItemsBusiness = new MenuItemsBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Menu entity) {
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
  public Response put(Menu entity) {
    try {
	    session.begin();
	    Menu updatedEntity = business.update(entity);
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
  public Response putWithId(Menu entity) {
    try {
	    session.begin();
	    Menu updatedEntity = business.update(entity);
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
  public Response delete(Menu entity) {  
		try {
			session.begin();
			Menu updatedEntity = business.update(entity);
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
			Menu menu = this.business.findById(instanceId);
			entity.setMenu(menu);
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
  @Path("/{instanceId}/MenuItem")
  public GenericEntity<List<MenuItem>> listMenuItem(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<MenuItem>>(this.business.listMenuItem(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/MenuItem")
  public Response postMenuItem(MenuItem entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuItems newMenuItems = new MenuItems();

			Menu instance = this.business.findById(instanceId);


			newMenuItems.setMenuItem(entity);
			newMenuItems.setMenu(instance);
			
			this.menuItemsBusiness.save(newMenuItems);
			session.commit();
			this.menuItemsBusiness.refresh(newMenuItems);
			return Response.ok(newMenuItems.getMenu()).build();
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
  @Path("/{instanceId}/MenuItem/{relationId}")
  public Response deleteMenuItem(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteMenuItem(instanceId, relationId) > 0) {
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
  	
  public GenericEntity<List<Menu>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Menu>>(business.list(limit, offset)){};

  }
	
	@GET
	@Path("/tree")
	public GenericEntity<List<MenuItems>> listTree() {
	  HttpSession session = request.getSession();
	  return new GenericEntity<List<MenuItems>>(business.listMenuItemsTree(session)){};
	}
}
