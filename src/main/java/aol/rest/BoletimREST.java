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
@Path("/Boletim")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class BoletimREST implements RESTService<Boletim> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private BoletimBusiness business;
  /**
   * @generated
   */
  private DisciplinaBusiness disciplinaBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public BoletimREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new BoletimBusiness(session);
    this.disciplinaBusiness = new DisciplinaBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Boletim entity) {
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
  public Response put(Boletim entity) {
    try {
	    session.begin();
	    Boletim updatedEntity = business.update(entity);
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
  public Response putWithId(Boletim entity) {
    try {
	    session.begin();
	    Boletim updatedEntity = business.update(entity);
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
  public Response delete(Boletim entity) {  
		try {
			session.begin();
			Boletim updatedEntity = business.update(entity);
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
  @Path("/{instanceId}/Disciplina")
  public GenericEntity<List<Disciplina>> findDisciplina(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Disciplina>>(this.business.findDisciplina(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/Disciplina/{relationId}")
  public Response deleteDisciplina(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.disciplinaBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/Disciplina/{relationId}")
  public Response putDisciplina(Disciplina entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			Disciplina updatedEntity = this.disciplinaBusiness.update(entity);
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
  @Path("/{instanceId}/Disciplina")
  public Response postDisciplina(Disciplina entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Boletim boletim = this.business.findById(instanceId);
			entity.setBoletim(boletim);
			this.disciplinaBusiness.save(entity);
			session.commit();
			this.disciplinaBusiness.refresh(entity);
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
  	
  public GenericEntity<List<Boletim>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Boletim>>(business.list(limit, offset)){};

  }
	
}
