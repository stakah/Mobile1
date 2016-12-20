package metadata.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import metadata.dao.*;
import metadata.entity.*;



/**
 * Classe que representa a camada de negócios de MenuTypeBusiness
 * 
 * @generated
 **/
@Service("MenuTypeBusiness")
public class MenuTypeBusiness {


    /**
     * Instância da classe MenuTypeDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("MenuTypeDAO")
    protected MenuTypeDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public MenuType post(final MenuType entity) throws Exception {
      // begin-user-code  
      // end-user-code  
        repository.save(entity);
      // begin-user-code  
      // end-user-code  
      return entity;
    }

    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public MenuType get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       MenuType result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public MenuType put(final MenuType entity) throws Exception {
      // begin-user-code  
      // end-user-code
        repository.saveAndFlush(entity);
      // begin-user-code  
      // end-user-code        
      return entity;
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public void delete( java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
      repository.delete(id);
      // begin-user-code  
      // end-user-code        
    }

    // CRUD
    
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<MenuType> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<MenuType> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Menu> findMenu(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Menu> result = repository.findMenu(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<MenuItem> findMenuItem(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<MenuItem> result = repository.findMenuItem(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }



}