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
@Path("/Responsavel")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ResponsavelREST implements RESTService<Responsavel> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private ResponsavelBusiness business;
  /**
   * @generated
   */
  private AlunoBusiness alunoBusiness;
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
  private ResponsavelAvisoBusiness responsavelAvisoBusiness;
  /**
   * @generated
   */  
  @Context 
  private HttpServletRequest request;

  /**
   * @generated
   */
  public ResponsavelREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new ResponsavelBusiness(session);
    this.alunoBusiness = new AlunoBusiness(session);
    this.avisoBusiness = new AvisoBusiness(session);
    this.alunoResponsavelBusiness = new AlunoResponsavelBusiness(session);
    this.responsavelAvisoBusiness = new ResponsavelAvisoBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Responsavel entity) {
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
  public Response put(Responsavel entity) {
    try {
	    session.begin();
	    Responsavel updatedEntity = business.update(entity);
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
  public Response putWithId(Responsavel entity) {
    try {
	    session.begin();
	    Responsavel updatedEntity = business.update(entity);
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
  public Response delete(Responsavel entity) {  
		try {
			session.begin();
			Responsavel updatedEntity = business.update(entity);
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
			Responsavel responsavel = this.business.findById(instanceId);
			entity.setResponsavel(responsavel);
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
  @Path("/{instanceId}/ResponsavelAviso")
  public GenericEntity<List<ResponsavelAviso>> findResponsavelAviso(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<ResponsavelAviso>>(this.business.findResponsavelAviso(instanceId, limit, offset)){};
  }
  
  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @DELETE
  @Path("/{instanceId}/ResponsavelAviso/{relationId}")
  public Response deleteResponsavelAviso(@PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.responsavelAvisoBusiness.deleteById(relationId) > 0) {
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
  @Path("/{instanceId}/ResponsavelAviso/{relationId}")
  public Response putResponsavelAviso(ResponsavelAviso entity, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			ResponsavelAviso updatedEntity = this.responsavelAvisoBusiness.update(entity);
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
  @Path("/{instanceId}/ResponsavelAviso")
  public Response postResponsavelAviso(ResponsavelAviso entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			Responsavel responsavel = this.business.findById(instanceId);
			entity.setResponsavel(responsavel);
			this.responsavelAvisoBusiness.save(entity);
			session.commit();
			this.responsavelAvisoBusiness.refresh(entity);
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
  @Path("/{instanceId}/Aluno")
  public GenericEntity<List<Aluno>> listAluno(@PathParam("instanceId") java.lang.String instanceId, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset) {
    return new GenericEntity<List<Aluno>>(this.business.listAluno(instanceId, limit, offset)){};
  }
  
  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @POST
  @Path("/{instanceId}/Aluno")
  public Response postAluno(Aluno entity, @PathParam("instanceId") java.lang.String instanceId) {
		try {
			session.begin();
			AlunoResponsavel newAlunoResponsavel = new AlunoResponsavel();

			Responsavel instance = this.business.findById(instanceId);


			newAlunoResponsavel.setAluno(entity);
			newAlunoResponsavel.setResponsavel(instance);
			
			this.alunoResponsavelBusiness.save(newAlunoResponsavel);
			session.commit();
			this.alunoResponsavelBusiness.refresh(newAlunoResponsavel);
			return Response.ok(newAlunoResponsavel.getResponsavel()).build();
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
  @Path("/{instanceId}/Aluno/{relationId}")
  public Response deleteAluno(@PathParam("instanceId") java.lang.String instanceId, @PathParam("relationId") java.lang.String relationId) {
		try {
			session.begin();
			if (this.business.deleteAluno(instanceId, relationId) > 0) {
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
			ResponsavelAviso newResponsavelAviso = new ResponsavelAviso();

			Responsavel instance = this.business.findById(instanceId);


			newResponsavelAviso.setAviso(entity);
			newResponsavelAviso.setResponsavel(instance);
			
			this.responsavelAvisoBusiness.save(newResponsavelAviso);
			session.commit();
			this.responsavelAvisoBusiness.refresh(newResponsavelAviso);
			return Response.ok(newResponsavelAviso.getResponsavel()).build();
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
  	
  public GenericEntity<List<Responsavel>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Responsavel>>(business.list(limit, offset)){};

  }
  /**
   * NamedQuery listByUser
   * @generated
   */
  @GET
  @Path("/listByUser/{user}")	
  public GenericEntity<List<Responsavel>> listByUser(@PathParam("user")java.lang.String user, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Responsavel>>(business.listByUser(user, limit, offset)){};

  }
	
  /**
   * NamedQuery listByUser
   * @generated
   */
  @GET
  @Path("/listByUser")	
  public GenericEntity<List<Responsavel>> listByUserParams(@QueryParam("user")java.lang.String user, @DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Responsavel>>(business.listByUser(user, limit, offset)){};	
  }
}
