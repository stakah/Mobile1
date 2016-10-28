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
@Path("/Aviso")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AvisoREST implements RESTService<Aviso> {
  /**
   * @generated
   */
  private SessionManager session;
  /**
   * @generated
   */  
  private AvisoBusiness business;
  /**
   * @generated
   */
  private AlunoBusiness alunoBusiness;
  /**
   * @generated
   */
  private ResponsavelBusiness responsavelBusiness;
  /**
   * @generated
   */
  private AlunoAvisoBusiness alunoAvisoBusiness;
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
  public AvisoREST() {
    this.session = SessionManager.getInstance();
    this.session.getEntityManager().clear();
    this.business = new AvisoBusiness(session);
    this.alunoBusiness = new AlunoBusiness(session);
    this.responsavelBusiness = new ResponsavelBusiness(session);
    this.alunoAvisoBusiness = new AlunoAvisoBusiness(session);
    this.responsavelAvisoBusiness = new ResponsavelAvisoBusiness(session);
  }
  
  /**
   * @generated
   */  
  @POST
  public Response post(Aviso entity) {
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
  public Response put(Aviso entity) {
    try {
	    session.begin();
	    Aviso updatedEntity = business.update(entity);
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
  public Response putWithId(Aviso entity) {
    try {
	    session.begin();
	    Aviso updatedEntity = business.update(entity);
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
  public Response delete(Aviso entity) {  
		try {
			session.begin();
			Aviso updatedEntity = business.update(entity);
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
			Aviso aviso = this.business.findById(instanceId);
			entity.setAviso(aviso);
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
			Aviso aviso = this.business.findById(instanceId);
			entity.setAviso(aviso);
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
			AlunoAviso newAlunoAviso = new AlunoAviso();

			Aviso instance = this.business.findById(instanceId);


			newAlunoAviso.setAluno(entity);
			newAlunoAviso.setAviso(instance);
			
			this.alunoAvisoBusiness.save(newAlunoAviso);
			session.commit();
			this.alunoAvisoBusiness.refresh(newAlunoAviso);
			return Response.ok(newAlunoAviso.getAviso()).build();
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
			ResponsavelAviso newResponsavelAviso = new ResponsavelAviso();

			Aviso instance = this.business.findById(instanceId);


			newResponsavelAviso.setResponsavel(entity);
			newResponsavelAviso.setAviso(instance);
			
			this.responsavelAvisoBusiness.save(newResponsavelAviso);
			session.commit();
			this.responsavelAvisoBusiness.refresh(newResponsavelAviso);
			return Response.ok(newResponsavelAviso.getAviso()).build();
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
   * NamedQuery list
   * @generated
   */
  @GET
  	
  public GenericEntity<List<Aviso>> list(@DefaultValue("100") @QueryParam("limit") int limit, @DefaultValue("0") @QueryParam("offset") int offset){
      return new GenericEntity<List<Aviso>>(business.list(limit, offset)){};

  }
	
}
