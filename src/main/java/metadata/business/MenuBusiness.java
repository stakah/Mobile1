package metadata.business;

import metadata.dao.*;
import metadata.entity.*;

import java.util.*;

import javax.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;

import auth.permission.SecurityPermission;

/**
 * Classe que representa a camada de negócios de Menu
 * @generated
 **/
public class MenuBusiness {

  /**
   * Instância da classe MenuDAO que faz o acesso ao banco de dados
   * @generated
   */
  private MenuDAO dao;
  
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
  public MenuBusiness(final SessionManager sessionmanager) {
    // begin-user-code
    // end-user-code
    this.sessionManager = sessionmanager;
    this.dao = new MenuDAO(sessionmanager.getEntityManager());
    // begin-user-code
    // end-user-code
  }
  
  /**
   * Construtor padrão, inicializa singleton de sessão
   * @generated modifiable   
   */
  public MenuBusiness() {
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
  public void save(final Menu entity) {
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
  public void refresh(final Menu entity) {
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
  public Menu update(final Menu entity) {
    // begin-user-code
    // end-user-code  
	Menu updatedEntity = dao.update(entity);
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
  public void delete(final Menu entity){
    // begin-user-code
    // end-user-code    
	dao.delete(entity);
    // begin-user-code
    // end-user-code  	
  }
  
  /**
   * Remove a instância de Menu utilizando os identificadores
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
   * Obtém a instância de Menu utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated modifiable
   */  
  public Menu findById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    Menu entity = dao.findById(id);
    // begin-user-code
    // end-user-code      
    return entity;  
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
  public List<MenuItem> listMenuItem(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<MenuItem> result = dao.listMenuItem(id, limit, offset);
      // begin-user-code
      // end-user-code
      return result;        	  
  }
  
  /**
   * @generated modifiable
   */    
  public int deleteMenuItem(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = dao.deleteMenuItem(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
    
  
  /**
   * @generated modifiable
   */  	
  public List<Menu> list(int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<Menu> result = dao.list(limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
  
  
  public List<MenuItems> listMenuItemsTree(HttpSession httpSession) {
    ArrayList<MenuItems> list = new ArrayList<MenuItems>();
    Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)httpSession.getAttribute(SecurityPermission.AUTHORITIES_ATTRIBUTE);
    List<Menu> menus = this.list(Integer.MAX_VALUE, 0);

    for (Menu menu : menus) {
      if (menu.getRole().isEmpty() || authorities.contains(menu.getRole())) {
        list = this.buildMenuItemsTree(menu, menu.getRole());
      }
    }
    
    return list;
  }
  
  public ArrayList<MenuItems> buildMenuItemsTree(Menu menu, String role) {
    ArrayList<MenuItems> list = new ArrayList<MenuItems>();
    MenuItemsBusiness menuItemsBusiness = new MenuItemsBusiness(this.sessionManager);
    
    int limit = Integer.MAX_VALUE;
    int offset = 0;
    list.addAll(0, menuItemsBusiness.listByMenuId(menu.getId(), limit, offset));
    
    return list;
  }
}
