package aol.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import aol.entity.*;
import aol.business.*;



/**
 * Controller para expor serviços REST de Responsavel
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Responsavel")
public class ResponsavelREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("ResponsavelBusiness")
    private ResponsavelBusiness responsavelBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("AlunoBusiness")
      private AlunoBusiness alunoBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("AvisoBusiness")
      private AvisoBusiness avisoBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("AlunoResponsavelBusiness")
      private AlunoResponsavelBusiness alunoResponsavelBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("ResponsavelAvisoBusiness")
      private ResponsavelAvisoBusiness responsavelAvisoBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Responsavel post(@Validated @RequestBody final Responsavel entity) throws Exception {
        return responsavelBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Responsavel put(@Validated @RequestBody final Responsavel entity) throws Exception {
        return responsavelBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Responsavel put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Responsavel entity) throws Exception {
        return responsavelBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        responsavelBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Responsavel>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(responsavelBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * NamedQuery listByUser
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/listByUser/{user}")    
  public  HttpEntity<PagedResources<Responsavel>> listByUserParams (@PathVariable("user") java.lang.String user, Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(responsavelBusiness.listByUser(user, pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/AlunoResponsavel")    
  public HttpEntity<PagedResources<AlunoResponsavel>> findAlunoResponsavel(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(responsavelBusiness.findAlunoResponsavel(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/AlunoResponsavel/{relationId}")    
  public void deleteAlunoResponsavel(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.alunoResponsavelBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/AlunoResponsavel/{relationId}")
  public AlunoResponsavel putAlunoResponsavel(@Validated @RequestBody final AlunoResponsavel entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.alunoResponsavelBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/AlunoResponsavel")
  public AlunoResponsavel postAlunoResponsavel(@Validated @RequestBody final AlunoResponsavel entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Responsavel responsavel = this.responsavelBusiness.get(instanceId);
	entity.setResponsavel(responsavel);
	return this.alunoResponsavelBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/ResponsavelAviso")    
  public HttpEntity<PagedResources<ResponsavelAviso>> findResponsavelAviso(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(responsavelBusiness.findResponsavelAviso(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/ResponsavelAviso/{relationId}")    
  public void deleteResponsavelAviso(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.responsavelAvisoBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/ResponsavelAviso/{relationId}")
  public ResponsavelAviso putResponsavelAviso(@Validated @RequestBody final ResponsavelAviso entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.responsavelAvisoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/ResponsavelAviso")
  public ResponsavelAviso postResponsavelAviso(@Validated @RequestBody final ResponsavelAviso entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Responsavel responsavel = this.responsavelBusiness.get(instanceId);
	entity.setResponsavel(responsavel);
	return this.responsavelAvisoBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Aluno")
  public HttpEntity<PagedResources<Aluno>> listAluno(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(responsavelBusiness.listAluno(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Aluno")
  public Responsavel postAluno(@Validated @RequestBody final Aluno entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      AlunoResponsavel newAlunoResponsavel = new AlunoResponsavel();

      Responsavel instance = this.responsavelBusiness.get(instanceId);

      newAlunoResponsavel.setAluno(entity);
      newAlunoResponsavel.setResponsavel(instance);
      
      this.alunoResponsavelBusiness.post(newAlunoResponsavel);

      return newAlunoResponsavel.getResponsavel();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Aluno/{relationId}")
  public void deleteAluno(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.responsavelBusiness.deleteAluno(instanceId, relationId);
  }  


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Aviso")
  public HttpEntity<PagedResources<Aviso>> listAviso(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(responsavelBusiness.listAviso(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Aviso")
  public Responsavel postAviso(@Validated @RequestBody final Aviso entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      ResponsavelAviso newResponsavelAviso = new ResponsavelAviso();

      Responsavel instance = this.responsavelBusiness.get(instanceId);

      newResponsavelAviso.setAviso(entity);
      newResponsavelAviso.setResponsavel(instance);
      
      this.responsavelAvisoBusiness.post(newResponsavelAviso);

      return newResponsavelAviso.getResponsavel();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Aviso/{relationId}")
  public void deleteAviso(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.responsavelBusiness.deleteAviso(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Responsavel get(@PathVariable("id") java.lang.String id) throws Exception {
        return responsavelBusiness.get(id);
    }
}
