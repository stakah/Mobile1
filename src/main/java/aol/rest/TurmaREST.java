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
 * Controller para expor serviços REST de Turma
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Turma")
public class TurmaREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("TurmaBusiness")
    private TurmaBusiness turmaBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("DisciplinaBusiness")
      private DisciplinaBusiness disciplinaBusiness;
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
      @Qualifier("TurmaDisciplinaBusiness")
      private TurmaDisciplinaBusiness turmaDisciplinaBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Turma post(@Validated @RequestBody final Turma entity) throws Exception {
        return turmaBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Turma put(@Validated @RequestBody final Turma entity) throws Exception {
        return turmaBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Turma put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Turma entity) throws Exception {
        return turmaBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        turmaBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Turma>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(turmaBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Aluno")    
  public HttpEntity<PagedResources<Aluno>> findAluno(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(turmaBusiness.findAluno(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Aluno/{relationId}")    
  public void deleteAluno(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.alunoBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Aluno/{relationId}")
  public Aluno putAluno(@Validated @RequestBody final Aluno entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.alunoBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Aluno")
  public Aluno postAluno(@Validated @RequestBody final Aluno entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Turma turma_1 = this.turmaBusiness.get(instanceId);
	entity.setTurma_1(turma_1);
	return this.alunoBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/TurmaDisciplina")    
  public HttpEntity<PagedResources<TurmaDisciplina>> findTurmaDisciplina(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(turmaBusiness.findTurmaDisciplina(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/TurmaDisciplina/{relationId}")    
  public void deleteTurmaDisciplina(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.turmaDisciplinaBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/TurmaDisciplina/{relationId}")
  public TurmaDisciplina putTurmaDisciplina(@Validated @RequestBody final TurmaDisciplina entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.turmaDisciplinaBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/TurmaDisciplina")
  public TurmaDisciplina postTurmaDisciplina(@Validated @RequestBody final TurmaDisciplina entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Turma turma = this.turmaBusiness.get(instanceId);
	entity.setTurma(turma);
	return this.turmaDisciplinaBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Disciplina")
  public HttpEntity<PagedResources<Disciplina>> listDisciplina(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(turmaBusiness.listDisciplina(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Disciplina")
  public Turma postDisciplina(@Validated @RequestBody final Disciplina entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      TurmaDisciplina newTurmaDisciplina = new TurmaDisciplina();

      Turma instance = this.turmaBusiness.get(instanceId);

      newTurmaDisciplina.setDisciplina(entity);
      newTurmaDisciplina.setTurma(instance);
      
      this.turmaDisciplinaBusiness.post(newTurmaDisciplina);

      return newTurmaDisciplina.getTurma();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Disciplina/{relationId}")
  public void deleteDisciplina(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.turmaBusiness.deleteDisciplina(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Turma get(@PathVariable("id") java.lang.String id) throws Exception {
        return turmaBusiness.get(id);
    }
}
