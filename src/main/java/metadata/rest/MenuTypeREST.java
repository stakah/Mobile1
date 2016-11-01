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
@Path("/MenuType")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MenuTypeREST implements RESTService<MenuType> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private MenuTypeBusiness business;
  /**
   * @generated
   */
  private MenuBusiness menuBusiness;
  /**
   * @generated
   */
  private MenuItemBusiness menuItemBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public MenuTypeREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new MenuTypeBusiness(session);
    this.menuBusiness = new MenuBusiness(session);
    this.menuItemBusiness = new MenuItemBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(MenuType entity) {
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
  public Response put(MenuType entity) {
    try {
	    session.begin();
	    MenuType updatedEntity = business.update(entity);
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
  public Response putWithId(MenuType entity) {
    try {
	    session.begin();
	    MenuType updatedEntity = business.update(entity);
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
  public Response delete(MenuType entity) {  
		try {
			session.begin();
			MenuType updatedEntity = business.update(entity);
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
  @Path("/{instanceId}/Menu")
  public GenericEntity<List<Menu>> findMenu(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Menu>>(this.business.findMenu(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/Menu/{relationId}")
  public Response deleteMenu(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.menuBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/Menu/{relationId}")
  public Response putMenu(Menu entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			Menu updatedEntity = this.menuBusiness.update(entity);
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
  @Path("/{instanceId}/Menu")
  public Response postMenu(Menu entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuType menuType = this.business.findById(instanceId);
			entity.setMenuType(menuType);
			this.menuBusiness.save(entity);
			session.commit();
			this.menuBusiness.refresh(entity);
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
  @Path("/{instanceId}/MenuItem")
  public GenericEntity<List<MenuItem>> findMenuItem(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<MenuItem>>(this.business.findMenuItem(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/MenuItem/{relationId}")
  public Response deleteMenuItem(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.menuItemBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/MenuItem/{relationId}")
  public Response putMenuItem(MenuItem entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			MenuItem updatedEntity = this.menuItemBusiness.update(entity);
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
  @Path("/{instanceId}/MenuItem")
  public Response postMenuItem(MenuItem entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			MenuType menuType = this.business.findById(instanceId);
			entity.setMenuType(menuType);
			this.menuItemBusiness.save(entity);
			session.commit();
			this.menuItemBusiness.refresh(entity);
			return Response.ok(entity).build();
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
  	
  public GenericEntity<List<MenuType>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<MenuType>>(business.list(limit, offset)){};

  }
	
}
