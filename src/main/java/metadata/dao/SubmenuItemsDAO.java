package metadata.dao;

import javax.persistence.*;
import metadata.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class SubmenuItemsDAO extends BasicDAO<String, SubmenuItems> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1291515072l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public SubmenuItemsDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de SubmenuItems utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM SubmenuItems entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de SubmenuItems utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public SubmenuItems findById(java.lang.String id){
      TypedQuery<SubmenuItems> query = this.entityManager.createQuery("SELECT entity FROM SubmenuItems entity WHERE entity.id = :id", SubmenuItems.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



  /**
   * NamedQuery list
   * @generated
   */
  public List<SubmenuItems> list(int limit, int offset){
      return this.entityManager.createNamedQuery("submenuItemsList", SubmenuItems.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}