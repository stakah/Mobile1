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
@Path("/Aluno")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AlunoREST implements RESTService<Aluno> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private AlunoBusiness business;
  /**
   * @generated
   */
  private ResponsavelBusiness responsavelBusiness;
  /**
   * @generated
   */
  private AvisoBusiness avisoBusiness;
  /**
   * @generated
   */
  private AlunoResponsavelBusiness alunoResponsavelBusiness;
  /**
   * @generated
   */
  private AlunoAvisoBusiness alunoAvisoBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public AlunoREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new AlunoBusiness(session);
    this.responsavelBusiness = new ResponsavelBusiness(session);
    this.avisoBusiness = new AvisoBusiness(session);
    this.alunoResponsavelBusiness = new AlunoResponsavelBusiness(session);
    this.alunoAvisoBusiness = new AlunoAvisoBusiness(session);
  }
  
  @GET
  @Path("/{alunoId}")
  public Aluno findById(@PathParam("alunoId") java.lang.String alunoId) {
    return this.business.findById(alunoId);
  }

  @GET
  @Path("/user/{userId}")
  public Aluno findByUserId(@PathParam("userId") java.lang.String userId) {
    return this.business.findById(userId);
  }

  /**
   * @generated
   */  
  @POST
  public Response post(Aluno entity) {
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
  public Response put(Aluno entity) {
    try {
	    session.begin();
	    Aluno updatedEntity = business.update(entity);
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
  public Response putWithId(Aluno entity) {
    try {
	    session.begin();
	    Aluno updatedEntity = business.update(entity);
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
  public Response delete(Aluno entity) {  
		try {
			session.begin();
			Aluno updatedEntity = business.update(entity);
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
  @Path("/{instanceId}/AlunoResponsavel")
  public GenericEntity<List<AlunoResponsavel>> findAlunoResponsavel(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<AlunoResponsavel>>(this.business.findAlunoResponsavel(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/AlunoResponsavel/{relationId}")
  public Response deleteAlunoResponsavel(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.alunoResponsavelBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/AlunoResponsavel/{relationId}")
  public Response putAlunoResponsavel(AlunoResponsavel entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			AlunoResponsavel updatedEntity = this.alunoResponsavelBusiness.update(entity);
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
  @Path("/{instanceId}/AlunoResponsavel")
  public Response postAlunoResponsavel(AlunoResponsavel entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Aluno aluno = this.business.findById(instanceId);
			entity.setAluno(aluno);
			this.alunoResponsavelBusiness.save(entity);
			session.commit();
			this.alunoResponsavelBusiness.refresh(entity);
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
  @Path("/{instanceId}/AlunoAviso")
  public GenericEntity<List<AlunoAviso>> findAlunoAviso(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<AlunoAviso>>(this.business.findAlunoAviso(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/AlunoAviso/{relationId}")
  public Response deleteAlunoAviso(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.alunoAvisoBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/AlunoAviso/{relationId}")
  public Response putAlunoAviso(AlunoAviso entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			AlunoAviso updatedEntity = this.alunoAvisoBusiness.update(entity);
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
  @Path("/{instanceId}/AlunoAviso")
  public Response postAlunoAviso(AlunoAviso entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Aluno aluno = this.business.findById(instanceId);
			entity.setAluno(aluno);
			this.alunoAvisoBusiness.save(entity);
			session.commit();
			this.alunoAvisoBusiness.refresh(entity);
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
  @Path("/{instanceId}/Responsavel")
  public GenericEntity<List<Responsavel>> listResponsavel(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Responsavel>>(this.business.listResponsavel(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Responsavel")
  public Response postResponsavel(Responsavel entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			AlunoResponsavel newAlunoResponsavel = new AlunoResponsavel();

			Aluno instance = this.business.findById(instanceId);


			newAlunoResponsavel.setResponsavel(entity);
			newAlunoResponsavel.setAluno(instance);
			
			this.alunoResponsavelBusiness.save(newAlunoResponsavel);
			session.commit();
			this.alunoResponsavelBusiness.refresh(newAlunoResponsavel);
			return Response.ok(newAlunoResponsavel.getAluno()).build();
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
  @Path("/{instanceId}/Responsavel/{relationId}")
  public Response deleteResponsavel(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteResponsavel(instanceId, relationId) > 0) {
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
   * ManyToMany Relationship GET
   * @generated
   */
  @GET
  @Path("/{instanceId}/Aviso")
  public GenericEntity<List<Aviso>> listAviso(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Aviso>>(this.business.listAviso(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Aviso")
  public Response postAviso(Aviso entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			AlunoAviso newAlunoAviso = new AlunoAviso();

			Aluno instance = this.business.findById(instanceId);


			newAlunoAviso.setAviso(entity);
			newAlunoAviso.setAluno(instance);
			
			this.alunoAvisoBusiness.save(newAlunoAviso);
			session.commit();
			this.alunoAvisoBusiness.refresh(newAlunoAviso);
			return Response.ok(newAlunoAviso.getAluno()).build();
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
  @Path("/{instanceId}/Aviso/{relationId}")
  public Response deleteAviso(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteAviso(instanceId, relationId) > 0) {
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
  	
  public GenericEntity<List<Aluno>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Aluno>>(business.list(limit, offset)){};

  }
	
}
