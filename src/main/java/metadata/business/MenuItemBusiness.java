package metadata.business;

import metadata.dao.*;
import metadata.entity.*;

import java.util.*;

/**
 * Classe que representa a camada de negócios de MenuItem
 * @generated
 **/
public class MenuItemBusiness {

  /**
   * Instância da classe MenuItemDAO que faz o acesso ao banco de dados
   * @generated
   */
  private MenuItemDAO dao;
  
  /**
   * Singleton de sessão usado para abrir e fechar conexão com o banco de dados
   * @generated
   */
  protected SessionManager sessionManager;
	
  /**
   * Copia referência da sessão e instancia DAO relacionada à essa classe para manipular o banco de dados
   * 
   * @param sessionmanager
   *          Singleton de sessão
   * @generated modifiable
   */
  public MenuItemBusiness(final SessionManager sessionmanager) {
    // begin-user-code
    // end-user-code
    this.sessionManager = sessionmanager;
    this.dao = new MenuItemDAO(sessionmanager.getEntityManager());
    // begin-user-code
    // end-user-code
  }
  
  /**
   * Construtor padrão, inicializa singleton de sessão
   * @generated modifiable   
   */
  public MenuItemBusiness() {
    // begin-user-code
    // end-user-code  
    this(SessionManager.getInstance());
    // begin-user-code
    // end-user-code    
  }	

  /**
   * Grava valor no banco
   * 
   * @param entity Linha da tabela a ser persistida no banco de dados
   * @generated modifiable   
   */
  public void save(final MenuItem entity) {
    // begin-user-code
    // end-user-code  
    dao.save(entity);
    // begin-user-code
    // end-user-code    
  }
  
  /**
   * Dá um refresh na entidade com valores valor no banco
   * 
   * @param entity Entidade
   * @generated modifiable
   */
  public void refresh(final MenuItem entity) {
    // begin-user-code
    // end-user-code  
    dao.refresh(entity);
    // begin-user-code
    // end-user-code  
  }  
  
  /**
   * Atualiza valor do banco
   * 
   * @param entity Linha da tabela a ser atualizada
   * @generated modifiable   
   */
  public MenuItem update(final MenuItem entity) {
    // begin-user-code
    // end-user-code  
	MenuItem updatedEntity = dao.update(entity);
    // begin-user-code
    // end-user-code	
    return updatedEntity;
  }
  
  /**
   * Apaga valor do banco
   * 
   * @param entity Linha da tabela a ser excluída
   * @generated modifiable   
   */
  public void delete(final MenuItem entity){
    // begin-user-code
    // end-user-code    
	dao.delete(entity);
    // begin-user-code
    // end-user-code  	
  }
  
  /**
   * Remove a instância de MenuItem utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated modifiable   
   */  
  public int deleteById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    int result = dao.deleteById(id);
    // begin-user-code
    // end-user-code    
    return result;    
  }  
  
  /**
   * Obtém a instância de MenuItem utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated modifiable
   */  
  public MenuItem findById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    MenuItem entity = dao.findById(id);
    // begin-user-code
    // end-user-code      
    return entity;  
  }   
  
  /**
   * @generated modifiable
   */  
  public List<SubmenuItems> findSubmenuItems(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<SubmenuItems> result = dao.findSubmenuItems(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }

  /**
   * @generated modifiable
   */  
  public List<SubmenuItems> findSubmenuItems_2(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<SubmenuItems> result = dao.findSubmenuItems_2(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }

  /**
   * @generated modifiable
   */  
  public List<SubmenuItems> findSubmenuItems_3(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<SubmenuItems> result = dao.findSubmenuItems_3(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }

  /**
   * @generated modifiable
   */  
  public List<SubmenuItems> findSubmenuItems_4(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<SubmenuItems> result = dao.findSubmenuItems_4(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }

  /**
   * @generated modifiable
   */  
  public List<MenuItems> findMenuItems(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<MenuItems> result = dao.findMenuItems(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }


  /**
   * @generated modifiable
   */  
  public List<Menu> listMenu(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<Menu> result = dao.listMenu(id, limit, offset);
      // begin-user-code
      // end-user-code
      return result;        	  
  }
  
  /**
   * @generated modifiable
   */    
  public int deleteMenu(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = dao.deleteMenu(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
    
  
  /**
   * @generated modifiable
   */  	
  public List<MenuItem> list(int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<MenuItem> result = dao.list(limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
}
