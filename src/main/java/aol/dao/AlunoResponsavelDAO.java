package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class AlunoResponsavelDAO extends BasicDAO<String, AlunoResponsavel> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 215116927l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public AlunoResponsavelDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de AlunoResponsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM AlunoResponsavel entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de AlunoResponsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public AlunoResponsavel findById(java.lang.String id){
      TypedQuery<AlunoResponsavel> query = this.entityManager.createQuery("SELECT entity FROM AlunoResponsavel entity WHERE entity.id = :id", AlunoResponsavel.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



}