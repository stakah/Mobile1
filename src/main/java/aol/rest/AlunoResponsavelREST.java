package aol.rest;


import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.persistence.*;

import aol.rest.util.*;

import aol.dao.*;
import aol.entity.*;
import aol.business.*;
import aol.rest.exceptions.*;
import javax.servlet.http.HttpServletRequest;


/**
 * Publicando metodos de negocio via REST
 * @generated
 **/
@Path("/AlunoResponsavel")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AlunoResponsavelREST implements RESTService<AlunoResponsavel> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private AlunoResponsavelBusiness business;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public AlunoResponsavelREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new AlunoResponsavelBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(AlunoResponsavel entity) {
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
  public Response put(AlunoResponsavel entity) {
    try {
	    session.begin();
	    AlunoResponsavel updatedEntity = business.update(entity);
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
  public Response putWithId(AlunoResponsavel entity) {
    try {
	    session.begin();
	    AlunoResponsavel updatedEntity = business.update(entity);
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
  public Response delete(AlunoResponsavel entity) {  
		try {
			session.begin();
			AlunoResponsavel updatedEntity = business.update(entity);
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
  
  
  


  
	
}
