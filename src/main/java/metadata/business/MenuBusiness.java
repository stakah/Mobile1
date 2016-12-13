package metadata.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import metadata.dao.*;
import metadata.entity.*;



/**
 * Classe que representa a camada de negócios de MenuBusiness
 * 
 * @generated
 **/
@Service("MenuBusiness")
public class MenuBusiness {


    /**
     * Instância da classe MenuDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("MenuDAO")
    protected MenuDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Menu post(final Menu entity) throws Exception {
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
    public Menu get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Menu result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Menu put(final Menu entity) throws Exception {
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
  public Page<Menu> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Menu> result = repository.list (  pageable );
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
  public Page<MenuItem> listMenuItem(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<MenuItem> result = repository.listMenuItem(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteMenuItem(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteMenuItem(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
}