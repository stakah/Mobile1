package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class TurmaDisciplinaDAO extends BasicDAO<String, TurmaDisciplina> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 709725239l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public TurmaDisciplinaDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de TurmaDisciplina utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM TurmaDisciplina entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de TurmaDisciplina utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public TurmaDisciplina findById(java.lang.String id){
      TypedQuery<TurmaDisciplina> query = this.entityManager.createQuery("SELECT entity FROM TurmaDisciplina entity WHERE entity.id = :id", TurmaDisciplina.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



  /**
   * NamedQuery list
   * @generated
   */
  public List<TurmaDisciplina> list(int limit, int offset){
      return this.entityManager.createNamedQuery("turmaDisciplinaList", TurmaDisciplina.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}