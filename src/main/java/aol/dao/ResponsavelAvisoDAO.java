package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class ResponsavelAvisoDAO extends BasicDAO<String, ResponsavelAviso> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 1009547742l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public ResponsavelAvisoDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de ResponsavelAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM ResponsavelAviso entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de ResponsavelAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public ResponsavelAviso findById(java.lang.String id){
      TypedQuery<ResponsavelAviso> query = this.entityManager.createQuery("SELECT entity FROM ResponsavelAviso entity WHERE entity.id = :id", ResponsavelAviso.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



  /**
   * NamedQuery list
   * @generated
   */
  public List<ResponsavelAviso> list(int limit, int offset){
      return this.entityManager.createNamedQuery("responsavelAvisoList", ResponsavelAviso.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}