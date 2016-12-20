package metadata.rest;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

import metadata.entity.*;
import metadata.business.*;



/**
 * Controller para expor serviços REST de MenuItems
 * 
 * @author sergiot
 * @version 1.0
 * @generated
 **/
@RestController
@RequestMapping(value = "/api/rest/metadata/MenuItems")
public class MenuItemsREST {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("MenuItemsBusiness")
    private MenuItemsBusiness menuItemsBusiness;


    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.POST)
    public MenuItems post(@Validated @RequestBody final MenuItems entity) throws Exception {
        return menuItemsBusiness.post(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT)
    public MenuItems put(@Validated @RequestBody final MenuItems entity) throws Exception {
        return menuItemsBusiness.put(entity);
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade e id fornecidos
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public MenuItems put(@PathVariable("id") final java.lang.String id, @Validated @RequestBody final MenuItems entity) throws Exception {
        return menuItemsBusiness.put(entity);
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") java.lang.String id) throws Exception {
        menuItemsBusiness.delete(id);
    }




    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public MenuItems get(@PathVariable("id") java.lang.String id) throws Exception {
        return menuItemsBusiness.get(id);
    }
}
