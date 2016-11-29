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
 * Controller para expor serviços REST de Aviso
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Aviso")
public class AvisoREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AvisoBusiness")
    private AvisoBusiness avisoBusiness;

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
      @Qualifier("ResponsavelBusiness")
      private ResponsavelBusiness responsavelBusiness;
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
      @Qualifier("ResponsavelAvisoBusiness")
      private ResponsavelAvisoBusiness responsavelAvisoBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Aviso post(@Validated @RequestBody final Aviso entity) throws Exception {
        return avisoBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Aviso put(@Validated @RequestBody final Aviso entity) throws Exception {
        return avisoBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Aviso put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Aviso entity) throws Exception {
        return avisoBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        avisoBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Aviso>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(avisoBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/AlunoAviso")    
  public HttpEntity<PagedResources<AlunoAviso>> findAlunoAviso(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(avisoBusiness.findAlunoAviso(instanceId,  pageable )), HttpStatus.OK);
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
	Aviso aviso = this.avisoBusiness.get(instanceId);
	entity.setAviso(aviso);
	return this.alunoAvisoBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/ResponsavelAviso")    
  public HttpEntity<PagedResources<ResponsavelAviso>> findResponsavelAviso(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(avisoBusiness.findResponsavelAviso(instanceId,  pageable )), HttpStatus.OK);
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
	Aviso aviso = this.avisoBusiness.get(instanceId);
	entity.setAviso(aviso);
	return this.responsavelAvisoBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Aluno")
  public HttpEntity<PagedResources<Aluno>> listAluno(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(avisoBusiness.listAluno(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Aluno")
  public Aviso postAluno(@Validated @RequestBody final Aluno entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      AlunoAviso newAlunoAviso = new AlunoAviso();

      Aviso instance = this.avisoBusiness.get(instanceId);

      newAlunoAviso.setAluno(entity);
      newAlunoAviso.setAviso(instance);
      
      this.alunoAvisoBusiness.post(newAlunoAviso);

      return newAlunoAviso.getAviso();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Aluno/{relationId}")
  public void deleteAluno(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.avisoBusiness.deleteAluno(instanceId, relationId);
  }  


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Responsavel")
  public HttpEntity<PagedResources<Responsavel>> listResponsavel(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(avisoBusiness.listResponsavel(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Responsavel")
  public Aviso postResponsavel(@Validated @RequestBody final Responsavel entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      ResponsavelAviso newResponsavelAviso = new ResponsavelAviso();

      Aviso instance = this.avisoBusiness.get(instanceId);

      newResponsavelAviso.setResponsavel(entity);
      newResponsavelAviso.setAviso(instance);
      
      this.responsavelAvisoBusiness.post(newResponsavelAviso);

      return newResponsavelAviso.getAviso();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Responsavel/{relationId}")
  public void deleteResponsavel(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.avisoBusiness.deleteResponsavel(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Aviso get(@PathVariable("id") java.lang.String id) throws Exception {
        return avisoBusiness.get(id);
    }
}
