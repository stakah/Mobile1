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
 * Controller para expor serviços REST de AlunoAviso
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/AlunoAviso")
public class AlunoAvisoREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AlunoAvisoBusiness")
    private AlunoAvisoBusiness alunoAvisoBusiness;


    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public AlunoAviso post(@Validated @RequestBody final AlunoAviso entity) throws Exception {
        return alunoAvisoBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public AlunoAviso put(@Validated @RequestBody final AlunoAviso entity) throws Exception {
        return alunoAvisoBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public AlunoAviso put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final AlunoAviso entity) throws Exception {
        return alunoAvisoBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        alunoAvisoBusiness.delete(id);
    }


  /**
   * NamedQuery list
   * @generated
   */
  @RequestMapping(method = RequestMethod.GET
  )    
  public  HttpEntity<PagedResources<AlunoAviso>> listParams (Pageable pageable, PagedResourcesAssembler assembler){
      return new ResponseEntity<>(assembler.toResource(alunoAvisoBusiness.list(pageable   )), HttpStatus.OK);    
  }



    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AlunoAviso get(@PathVariable("id") java.lang.String id) throws Exception {
        return alunoAvisoBusiness.get(id);
    }
}
