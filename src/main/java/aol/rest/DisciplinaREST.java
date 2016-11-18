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
@Path("/Disciplina")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class DisciplinaREST implements RESTService<Disciplina> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private DisciplinaBusiness business;
  /**
   * @generated
   */
  private TurmaBusiness turmaBusiness;
  /**
   * @generated
   */
  private TurmaDisciplinaBusiness turmaDisciplinaBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public DisciplinaREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new DisciplinaBusiness(session);
    this.turmaBusiness = new TurmaBusiness(session);
    this.turmaDisciplinaBusiness = new TurmaDisciplinaBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Disciplina entity) {
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
  public Response put(Disciplina entity) {
    try {
	    session.begin();
	    Disciplina updatedEntity = business.update(entity);
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
  public Response putWithId(Disciplina entity) {
    try {
	    session.begin();
	    Disciplina updatedEntity = business.update(entity);
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
  public Response delete(Disciplina entity) {  
		try {
			session.begin();
			Disciplina updatedEntity = business.update(entity);
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
  @Path("/{instanceId}/TurmaDisciplina")
  public GenericEntity<List<TurmaDisciplina>> findTurmaDisciplina(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<TurmaDisciplina>>(this.business.findTurmaDisciplina(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/TurmaDisciplina/{relationId}")
  public Response deleteTurmaDisciplina(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.turmaDisciplinaBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/TurmaDisciplina/{relationId}")
  public Response putTurmaDisciplina(TurmaDisciplina entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			TurmaDisciplina updatedEntity = this.turmaDisciplinaBusiness.update(entity);
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
  @Path("/{instanceId}/TurmaDisciplina")
  public Response postTurmaDisciplina(TurmaDisciplina entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Disciplina disciplina = this.business.findById(instanceId);
			entity.setDisciplina(disciplina);
			this.turmaDisciplinaBusiness.save(entity);
			session.commit();
			this.turmaDisciplinaBusiness.refresh(entity);
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
  @Path("/{instanceId}/Turma")
  public GenericEntity<List<Turma>> listTurma(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Turma>>(this.business.listTurma(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Turma")
  public Response postTurma(Turma entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			TurmaDisciplina newTurmaDisciplina = new TurmaDisciplina();

			Disciplina instance = this.business.findById(instanceId);


			newTurmaDisciplina.setTurma(entity);
			newTurmaDisciplina.setDisciplina(instance);
			
			this.turmaDisciplinaBusiness.save(newTurmaDisciplina);
			session.commit();
			this.turmaDisciplinaBusiness.refresh(newTurmaDisciplina);
			return Response.ok(newTurmaDisciplina.getDisciplina()).build();
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
  @Path("/{instanceId}/Turma/{relationId}")
  public Response deleteTurma(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteTurma(instanceId, relationId) > 0) {
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
  	
  public GenericEntity<List<Disciplina>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Disciplina>>(business.list(limit, offset)){};

  }
	
}
