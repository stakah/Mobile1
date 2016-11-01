package metadata.dao;

import javax.persistence.*;
import metadata.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class MenuTypeDAO extends BasicDAO<String, MenuType> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -539116183l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public MenuTypeDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de MenuType utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM MenuType entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de MenuType utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public MenuType findById(java.lang.String id){
      TypedQuery<MenuType> query = this.entityManager.createQuery("SELECT entity FROM MenuType entity WHERE entity.id = :id", MenuType.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<Menu> findMenu(java.lang.String id, int limit, int offset) {
      TypedQuery<Menu> query = this.entityManager.createQuery("SELECT entity FROM Menu entity WHERE entity.menuType.id = :id", Menu.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<MenuItem> findMenuItem(java.lang.String id, int limit, int offset) {
      TypedQuery<MenuItem> query = this.entityManager.createQuery("SELECT entity FROM MenuItem entity WHERE entity.menuType.id = :id", MenuItem.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }


  /**
   * NamedQuery list
   * @generated
   */
  public List<MenuType> list(int limit, int offset){
      return this.entityManager.createNamedQuery("menuTypeList", MenuType.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}