package metadata.dao;

import javax.persistence.*;
import metadata.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class MenuDAO extends BasicDAO<String, Menu> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 2396540l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public MenuDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Menu utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Menu entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Menu utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Menu findById(java.lang.String id){
      TypedQuery<Menu> query = this.entityManager.createQuery("SELECT entity FROM Menu entity WHERE entity.id = :id", Menu.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<MenuItems> findMenuItems(java.lang.String id, int limit, int offset) {
      TypedQuery<MenuItems> query = this.entityManager.createQuery("SELECT entity FROM MenuItems entity WHERE entity.menu.id = :id", MenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<MenuItem> listMenuItem(java.lang.String id, int limit, int offset) {
      TypedQuery<MenuItem> query = this.entityManager.createQuery("SELECT entity.menuItem FROM MenuItems entity WHERE entity.menu.id = :id", MenuItem.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteMenuItem(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM MenuItems entity WHERE entity.menu.id = :instanceId AND entity.menuItem.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<Menu> list(int limit, int offset){
      return this.entityManager.createNamedQuery("menuList", Menu.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}