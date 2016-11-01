package metadata.dao;

import javax.persistence.*;
import metadata.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class MenuItemDAO extends BasicDAO<String, MenuItem> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -539449030l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public MenuItemDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de MenuItem utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM MenuItem entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de MenuItem utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public MenuItem findById(java.lang.String id){
      TypedQuery<MenuItem> query = this.entityManager.createQuery("SELECT entity FROM MenuItem entity WHERE entity.id = :id", MenuItem.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<SubmenuItems> findSubmenuItems(java.lang.String id, int limit, int offset) {
      TypedQuery<SubmenuItems> query = this.entityManager.createQuery("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemParent.id = :id", SubmenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<SubmenuItems> findSubmenuItems_2(java.lang.String id, int limit, int offset) {
      TypedQuery<SubmenuItems> query = this.entityManager.createQuery("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemChild.id = :id", SubmenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<SubmenuItems> findSubmenuItems_3(java.lang.String id, int limit, int offset) {
      TypedQuery<SubmenuItems> query = this.entityManager.createQuery("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemParent.id = :id", SubmenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<SubmenuItems> findSubmenuItems_4(java.lang.String id, int limit, int offset) {
      TypedQuery<SubmenuItems> query = this.entityManager.createQuery("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemChild.id = :id", SubmenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<MenuItems> findMenuItems(java.lang.String id, int limit, int offset) {
      TypedQuery<MenuItems> query = this.entityManager.createQuery("SELECT entity FROM MenuItems entity WHERE entity.menuItem.id = :id", MenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Menu> listMenu(java.lang.String id, int limit, int offset) {
      TypedQuery<Menu> query = this.entityManager.createQuery("SELECT entity.menu FROM MenuItems entity WHERE entity.menuItem.id = :id", Menu.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteMenu(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM MenuItems entity WHERE entity.menuItem.id = :instanceId AND entity.menu.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<MenuItem> list(int limit, int offset){
      return this.entityManager.createNamedQuery("menuItemList", MenuItem.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}