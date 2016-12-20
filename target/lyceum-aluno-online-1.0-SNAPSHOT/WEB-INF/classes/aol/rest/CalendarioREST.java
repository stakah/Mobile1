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
 * Controller para expor serviços REST de Calendario
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Calendario")
public class CalendarioREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("CalendarioBusiness")
    private CalendarioBusiness calendarioBusiness;

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
      @Qualifier("HorarioAulaBusiness")
      private HorarioAulaBusiness horarioAulaBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Calendario post(@Validated @RequestBody final Calendario entity) throws Exception {
        return calendarioBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Calendario put(@Validated @RequestBody final Calendario entity) throws Exception {
        return calendarioBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Calendario put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Calendario entity) throws Exception {
        return calendarioBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        calendarioBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Calendario>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(calendarioBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/HorarioAula")    
  public HttpEntity<PagedResources<HorarioAula>> findHorarioAula(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(calendarioBusiness.findHorarioAula(instanceId,  pageable )), HttpStatus.OK);
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
	Calendario calendario = this.calendarioBusiness.get(instanceId);
	entity.setCalendario(calendario);
	return this.horarioAulaBusiness.post(entity);
  }   


  /**
   * ManyToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  ,value="/{instanceId}/Disciplina")
  public HttpEntity<PagedResources<Disciplina>> listDisciplina(@PathVariable("instanceId") java.lang.String instanceId,  Pageable pageable, PagedResourcesAssembler assembler ) {
    return new ResponseEntity<>(assembler.toResource(calendarioBusiness.listDisciplina(instanceId,  pageable )), HttpStatus.OK); 
  }

  /**
   * ManyToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  ,value="/{instanceId}/Disciplina")
  public Calendario postDisciplina(@Validated @RequestBody final Disciplina entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
      HorarioAula newHorarioAula = new HorarioAula();

      Calendario instance = this.calendarioBusiness.get(instanceId);

      newHorarioAula.setDisciplina(entity);
      newHorarioAula.setCalendario(instance);
      
      this.horarioAulaBusiness.post(newHorarioAula);

      return newHorarioAula.getCalendario();
  }   

  /**
   * ManyToMany Relationship DELETE
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  ,value="/{instanceId}/Disciplina/{relationId}")
  public void deleteDisciplina(@PathVariable("instanceId") java.lang.String instanceId, @PathVariable("relationId") java.lang.String relationId) {
	  this.calendarioBusiness.deleteDisciplina(instanceId, relationId);
  }  



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Calendario get(@PathVariable("id") java.lang.String id) throws Exception {
        return calendarioBusiness.get(id);
    }
}
