package metadata.dao;

import javax.persistence.*;
import metadata.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class MenuItemsDAO extends BasicDAO<String, MenuItems> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 456887670l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public MenuItemsDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de MenuItems utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM MenuItems entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de MenuItems utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public MenuItems findById(java.lang.String id){
      TypedQuery<MenuItems> query = this.entityManager.createQuery("SELECT entity FROM MenuItems entity WHERE entity.id = :id", MenuItems.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

 public List<MenuItems> listMenuItems(java.lang.String id, int limit, int offset) {
      TypedQuery<MenuItems> query = this.entityManager.createQuery("SELECT entity FROM MenuItems entity WHERE entity.menu.id = :id", MenuItems.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
}