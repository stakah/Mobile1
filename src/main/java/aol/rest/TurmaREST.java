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
@Path("/Turma")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TurmaREST implements RESTService<Turma> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private TurmaBusiness business;
  /**
   * @generated
   */
  private DisciplinaBusiness disciplinaBusiness;
  /**
   * @generated
   */
  private AlunoBusiness alunoBusiness;
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
  public TurmaREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new TurmaBusiness(session);
    this.disciplinaBusiness = new DisciplinaBusiness(session);
    this.alunoBusiness = new AlunoBusiness(session);
    this.turmaDisciplinaBusiness = new TurmaDisciplinaBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Turma entity) {
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
  public Response put(Turma entity) {
    try {
	    session.begin();
	    Turma updatedEntity = business.update(entity);
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
  public Response putWithId(Turma entity) {
    try {
	    session.begin();
	    Turma updatedEntity = business.update(entity);
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
  public Response delete(Turma entity) {  
		try {
			session.begin();
			Turma updatedEntity = business.update(entity);
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
  @Path("/{instanceId}/Aluno")
  public GenericEntity<List<Aluno>> findAluno(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Aluno>>(this.business.findAluno(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/Aluno/{relationId}")
  public Response deleteAluno(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.alunoBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/Aluno/{relationId}")
  public Response putAluno(Aluno entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			Aluno updatedEntity = this.alunoBusiness.update(entity);
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
  @Path("/{instanceId}/Aluno")
  public Response postAluno(Aluno entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Turma turma_1 = this.business.findById(instanceId);
			entity.setTurma_1(turma_1);
			this.alunoBusiness.save(entity);
			session.commit();
			this.alunoBusiness.refresh(entity);
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
			Turma turma = this.business.findById(instanceId);
			entity.setTurma(turma);
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
  @Path("/{instanceId}/Disciplina")
  public GenericEntity<List<Disciplina>> listDisciplina(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Disciplina>>(this.business.listDisciplina(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Disciplina")
  public Response postDisciplina(Disciplina entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			TurmaDisciplina newTurmaDisciplina = new TurmaDisciplina();

			Turma instance = this.business.findById(instanceId);


			newTurmaDisciplina.setDisciplina(entity);
			newTurmaDisciplina.setTurma(instance);
			
			this.turmaDisciplinaBusiness.save(newTurmaDisciplina);
			session.commit();
			this.turmaDisciplinaBusiness.refresh(newTurmaDisciplina);
			return Response.ok(newTurmaDisciplina.getTurma()).build();
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
  @Path("/{instanceId}/Disciplina/{relationId}")
  public Response deleteDisciplina(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteDisciplina(instanceId, relationId) > 0) {
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
  	
  public GenericEntity<List<Turma>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Turma>>(business.list(limit, offset)){};

  }
	
}
