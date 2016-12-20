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
 * Controller para expor serviços REST de Aluno
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Aluno")
public class AlunoREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AlunoBusiness")
    private AlunoBusiness alunoBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("ResponsavelBusiness")
      private ResponsavelBusiness responsavelBusiness;
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
      @Qualifier("AlunoAvisoBusiness")
      private AlunoAvisoBusiness alunoAvisoBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("BoletimBusiness")
      private BoletimBusiness boletimBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("CalendarioBusiness")
      private CalendarioBusiness calendarioBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Aluno post(@Validated @RequestBody final Aluno entity) throws Exception {
        return alunoBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Aluno put(@Validated @RequestBody final Aluno entity) throws Exception {
        return alunoBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Aluno put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Aluno entity) throws Exception {
        return alunoBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        alunoBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Aluno>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(alunoBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/AlunoResponsavel")    
  public HttpEntity<PagedResources<AlunoResponsavel>> findAlunoResponsavel(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.findAlunoResponsavel(instanceId,  pageable )), HttpStatus.OK);
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
	Aluno aluno = this.alunoBusiness.get(instanceId);
	entity.setAluno(aluno);
	return this.alunoResponsavelBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/AlunoAviso")    
  public HttpEntity<PagedResources<AlunoAviso>> findAlunoAviso(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.findAlunoAviso(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/AlunoAviso/{relationId}")    
  public void deleteAlunoAviso(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.alunoAvisoBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/AlunoAviso/{relationId}")
  public AlunoAviso putAlunoAviso(@Validated @RequestBody final AlunoAviso entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.alunoAvisoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/AlunoAviso")
  public AlunoAviso postAlunoAviso(@Validated @RequestBody final AlunoAviso entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Aluno aluno = this.alunoBusiness.get(instanceId);
	entity.setAluno(aluno);
	return this.alunoAvisoBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Boletim")    
  public HttpEntity<PagedResources<Boletim>> findBoletim(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.findBoletim(instanceId,  pageable )), HttpStatus.OK);
  }
    @RequestMapping(method = RequestMethod.GET
            , value="/{instanceId}/Boletim/Id")
    public HttpEntity<PagedResources<java.lang.Integer>> getBoletimId(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
        return new ResponseEntity<>(assembler.toResource(alunoBusiness.getBoletimId(instanceId,  pageable )), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET
            , value="/{alunoId}/BoletimDisciplinas")
    public HttpEntity<PagedResources<BoletimDisciplinas>> findBoletimDisciplinasByAlunoId(@PathVariable("alunoId") java.lang.String alunoId, Pageable pageable, PagedResourcesAssembler assembler) {
        return new ResponseEntity<>(assembler.toResource(boletimBusiness.findBoletimDisciplinasByAlunoId(alunoId,  pageable )), HttpStatus.OK);
    }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Boletim/{relationId}")    
  public void deleteBoletim(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.boletimBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Boletim/{relationId}")
  public Boletim putBoletim(@Validated @RequestBody final Boletim entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.boletimBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Boletim")
  public Boletim postBoletim(@Validated @RequestBody final Boletim entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Aluno aluno = this.alunoBusiness.get(instanceId);
	entity.setAluno(aluno);
	return this.boletimBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Calendario")    
  public HttpEntity<PagedResources<Calendario>> findCalendario(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.findCalendario(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Calendario/{relationId}")    
  public void deleteCalendario(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.calendarioBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Calendario/{relationId}")
  public Calendario putCalendario(@Validated @RequestBody final Calendario entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.calendarioBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Calendario")
  public Calendario postCalendario(@Validated @RequestBody final Calendario entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Aluno aluno = this.alunoBusiness.get(instanceId);
	entity.setAluno(aluno);
	return this.calendarioBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Responsavel")
  public HttpEntity<PagedResources<Responsavel>> listResponsavel(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.listResponsavel(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Responsavel")
  public Aluno postResponsavel(@Validated @RequestBody final Responsavel entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      AlunoResponsavel newAlunoResponsavel = new AlunoResponsavel();

      Aluno instance = this.alunoBusiness.get(instanceId);

      newAlunoResponsavel.setResponsavel(entity);
      newAlunoResponsavel.setAluno(instance);
      
      this.alunoResponsavelBusiness.post(newAlunoResponsavel);

      return newAlunoResponsavel.getAluno();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Responsavel/{relationId}")
  public void deleteResponsavel(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.alunoBusiness.deleteResponsavel(instanceId, relationId);
  }  


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Aviso")
  public HttpEntity<PagedResources<Aviso>> listAviso(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(alunoBusiness.listAviso(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Aviso")
  public Aluno postAviso(@Validated @RequestBody final Aviso entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      AlunoAviso newAlunoAviso = new AlunoAviso();

      Aluno instance = this.alunoBusiness.get(instanceId);

      newAlunoAviso.setAviso(entity);
      newAlunoAviso.setAluno(instance);
      
      this.alunoAvisoBusiness.post(newAlunoAviso);

      return newAlunoAviso.getAluno();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Aviso/{relationId}")
  public void deleteAviso(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.alunoBusiness.deleteAviso(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Aluno get(@PathVariable("id") java.lang.String id) throws Exception {
        return alunoBusiness.get(id);
    }
}
