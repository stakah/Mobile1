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
 * Controller para expor serviços REST de TurmaDisciplina
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/TurmaDisciplina")
public class TurmaDisciplinaREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
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
    public TurmaDisciplina post(@Validated @RequestBody final TurmaDisciplina entity) throws Exception {
        return turmaDisciplinaBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public TurmaDisciplina put(@Validated @RequestBody final TurmaDisciplina entity) throws Exception {
        return turmaDisciplinaBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public TurmaDisciplina put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final TurmaDisciplina entity) throws Exception {
        return turmaDisciplinaBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        turmaDisciplinaBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<TurmaDisciplina>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(turmaDisciplinaBusiness.list(pageable   )), HttpStatus.OK);    
  }



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TurmaDisciplina get(@PathVariable("id") java.lang.String id) throws Exception {
        return turmaDisciplinaBusiness.get(id);
    }
}
