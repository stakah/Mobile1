package metadata.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import metadata.dao.*;
import metadata.entity.*;



/**
 * Classe que representa a camada de negócios de MenuItemBusiness
 * 
 * @generated
 **/
@Service("MenuItemBusiness")
public class MenuItemBusiness {


    /**
     * Instância da classe MenuItemDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("MenuItemDAO")
    protected MenuItemDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public MenuItem post(final MenuItem entity) throws Exception {
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
    public MenuItem get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       MenuItem result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public MenuItem put(final MenuItem entity) throws Exception {
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
  public Page<MenuItem> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<MenuItem> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<SubmenuItems> findSubmenuItems(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<SubmenuItems> result = repository.findSubmenuItems(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<SubmenuItems> findSubmenuItems_2(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<SubmenuItems> result = repository.findSubmenuItems_2(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<SubmenuItems> findSubmenuItems_3(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<SubmenuItems> result = repository.findSubmenuItems_3(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<SubmenuItems> findSubmenuItems_4(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<SubmenuItems> result = repository.findSubmenuItems_4(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<MenuItems> findMenuItems(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<MenuItems> result = repository.findMenuItems(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }



  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Menu> listMenu(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Menu> result = repository.listMenu(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteMenu(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteMenu(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
}