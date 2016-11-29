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
 * Controller para expor serviços REST de AlunoResponsavel
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/aol/AlunoResponsavel")
public class AlunoResponsavelREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AlunoResponsavelBusiness")
    private AlunoResponsavelBusiness alunoResponsavelBusiness;


    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public AlunoResponsavel post(@Validated @RequestBody final AlunoResponsavel entity) throws Exception {
        return alunoResponsavelBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public AlunoResponsavel put(@Validated @RequestBody final AlunoResponsavel entity) throws Exception {
        return alunoResponsavelBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public AlunoResponsavel put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final AlunoResponsavel entity) throws Exception {
        return alunoResponsavelBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        alunoResponsavelBusiness.delete(id);
    }




    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AlunoResponsavel get(@PathVariable("id") java.lang.String id) throws Exception {
        return alunoResponsavelBusiness.get(id);
    }
}
