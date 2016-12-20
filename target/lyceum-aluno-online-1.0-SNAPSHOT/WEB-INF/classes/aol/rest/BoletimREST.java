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
 * Controller para expor serviços REST de Boletim
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/Boletim")
public class BoletimREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("BoletimBusiness")
    private BoletimBusiness boletimBusiness;

    /**
     * @generated
     */
      @Autowired
      @Qualifier("DisciplinaBusiness")
      private DisciplinaBusiness disciplinaBusiness;

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public Boletim post(@Validated @RequestBody final Boletim entity) throws Exception {
        return boletimBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Boletim put(@Validated @RequestBody final Boletim entity) throws Exception {
        return boletimBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Boletim put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final Boletim entity) throws Exception {
        return boletimBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        boletimBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<Boletim>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(boletimBusiness.list(pageable   )), HttpStatus.OK);    
  }

  /**
   * OneToMany Relationship GET
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  , value="/{instanceId}/Disciplina")    
  public HttpEntity<PagedResources<Disciplina>> findDisciplina(@PathVariable("instanceId") java.lang.String instanceId, Pageable pageable, PagedResourcesAssembler assembler) {
    return new ResponseEntity<>(assembler.toResource(boletimBusiness.findDisciplina(instanceId,  pageable )), HttpStatus.OK);
  }

  /**
   * OneToMany Relationship DELETE 
   * @generated
   */  
  @RequestMapping(method = RequestMethod.DELETE
  , value="/{instanceId}/Disciplina/{relationId}")    
  public void deleteDisciplina(@PathVariable("relationId") java.lang.String relationId) throws Exception {
    this.disciplinaBusiness.delete(relationId);
  }
  
  /**
   * OneToMany Relationship PUT
   * @generated
   */  
  @RequestMapping(method = RequestMethod.PUT
  , value="/{instanceId}/Disciplina/{relationId}")
  public Disciplina putDisciplina(@Validated @RequestBody final Disciplina entity, @PathVariable("relationId") java.lang.String relationId) throws Exception {
	return this.disciplinaBusiness.put(entity);
  }  
  
  /**
   * OneToMany Relationship POST
   * @generated
   */  
  @RequestMapping(method = RequestMethod.POST
  , value="/{instanceId}/Disciplina")
  public Disciplina postDisciplina(@Validated @RequestBody final Disciplina entity, @PathVariable("instanceId") java.lang.String instanceId) throws Exception {
	Boletim boletim = this.boletimBusiness.get(instanceId);
	entity.setBoletim(boletim);
	return this.disciplinaBusiness.post(entity);
  }   



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Boletim get(@PathVariable("id") java.lang.String id) throws Exception {
        return boletimBusiness.get(id);
    }
}
