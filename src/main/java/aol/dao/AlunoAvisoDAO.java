package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class AlunoAvisoDAO extends BasicDAO<String, AlunoAviso> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1987006935l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public AlunoAvisoDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de AlunoAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM AlunoAviso entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de AlunoAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public AlunoAviso findById(java.lang.String id){
      TypedQuery<AlunoAviso> query = this.entityManager.createQuery("SELECT entity FROM AlunoAviso entity WHERE entity.id = :id", AlunoAviso.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



  /**
   * NamedQuery list
   * @generated
   */
  public List<AlunoAviso> list(int limit, int offset){
      return this.entityManager.createNamedQuery("alunoAvisoList", AlunoAviso.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}