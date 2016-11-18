package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class BoletimDAO extends BasicDAO<String, Boletim> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 1726402542l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public BoletimDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Boletim utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Boletim entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Boletim utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Boletim findById(java.lang.String id){
      TypedQuery<Boletim> query = this.entityManager.createQuery("SELECT entity FROM Boletim entity WHERE entity.id = :id", Boletim.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<Disciplina> findDisciplina(java.lang.String id, int limit, int offset) {
      TypedQuery<Disciplina> query = this.entityManager.createQuery("SELECT entity FROM Disciplina entity WHERE entity.boletim.id = :id", Disciplina.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }


  /**
   * NamedQuery list
   * @generated
   */
  public List<Boletim> list(int limit, int offset){
      return this.entityManager.createNamedQuery("boletimList", Boletim.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}