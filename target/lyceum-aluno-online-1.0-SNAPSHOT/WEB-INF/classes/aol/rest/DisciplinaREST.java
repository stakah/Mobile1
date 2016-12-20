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
 * Controller para expor serviços REST de Disciplina
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Disciplina")
public class DisciplinaREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("DisciplinaBusiness")
    private DisciplinaBusiness disciplinaBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("TurmaBusiness")
      private TurmaBusiness turmaBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("CalendarioBusiness")
      private CalendarioBusiness calendarioBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("TurmaDisciplinaBusiness")
      private TurmaDisciplinaBusiness turmaDisciplinaBusiness;
    /**
     * @generated
     */
      @Autowired
      @Qualifier("HorarioAulaBusiness")
      private HorarioAulaBusiness horarioAulaBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Disciplina post(@Validated @RequestBody final Disciplina entity) throws Exception {
        return disciplinaBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Disciplina put(@Validated @RequestBody final Disciplina entity) throws Exception {
        return disciplinaBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Disciplina put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Disciplina entity) throws Exception {
        return disciplinaBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        disciplinaBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Disciplina>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(disciplinaBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/TurmaDisciplina")    
  public HttpEntity<PagedResources<TurmaDisciplina>> findTurmaDisciplina(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(disciplinaBusiness.findTurmaDisciplina(instanceId,  pageable )), HttpStatus.OK);
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
	Disciplina disciplina = this.disciplinaBusiness.get(instanceId);
	entity.setDisciplina(disciplina);
	return this.turmaDisciplinaBusiness.post(entity);
  }   

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/HorarioAula")    
  public HttpEntity<PagedResources<HorarioAula>> findHorarioAula(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(disciplinaBusiness.findHorarioAula(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/HorarioAula/{relationId}")    
  public void deleteHorarioAula(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.horarioAulaBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/HorarioAula/{relationId}")
  public HorarioAula putHorarioAula(@Validated @RequestBody final HorarioAula entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.horarioAulaBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/HorarioAula")
  public HorarioAula postHorarioAula(@Validated @RequestBody final HorarioAula entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Disciplina disciplina = this.disciplinaBusiness.get(instanceId);
	entity.setDisciplina(disciplina);
	return this.horarioAulaBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Turma")
  public HttpEntity<PagedResources<Turma>> listTurma(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(disciplinaBusiness.listTurma(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Turma")
  public Disciplina postTurma(@Validated @RequestBody final Turma entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      TurmaDisciplina newTurmaDisciplina = new TurmaDisciplina();

      Disciplina instance = this.disciplinaBusiness.get(instanceId);

      newTurmaDisciplina.setTurma(entity);
      newTurmaDisciplina.setDisciplina(instance);
      
      this.turmaDisciplinaBusiness.post(newTurmaDisciplina);

      return newTurmaDisciplina.getDisciplina();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Turma/{relationId}")
  public void deleteTurma(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.disciplinaBusiness.deleteTurma(instanceId, relationId);
  }  


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Calendario")
  public HttpEntity<PagedResources<Calendario>> listCalendario(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(disciplinaBusiness.listCalendario(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Calendario")
  public Disciplina postCalendario(@Validated @RequestBody final Calendario entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      HorarioAula newHorarioAula = new HorarioAula();

      Disciplina instance = this.disciplinaBusiness.get(instanceId);

      newHorarioAula.setCalendario(entity);
      newHorarioAula.setDisciplina(instance);
      
      this.horarioAulaBusiness.post(newHorarioAula);

      return newHorarioAula.getDisciplina();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Calendario/{relationId}")
  public void deleteCalendario(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.disciplinaBusiness.deleteCalendario(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Disciplina get(@PathVariable("id") java.lang.String id) throws Exception {
        return disciplinaBusiness.get(id);
    }
}
