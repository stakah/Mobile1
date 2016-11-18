package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class DisciplinaDAO extends BasicDAO<String, Disciplina> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1941078204l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public DisciplinaDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Disciplina utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Disciplina entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Disciplina utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Disciplina findById(java.lang.String id){
      TypedQuery<Disciplina> query = this.entityManager.createQuery("SELECT entity FROM Disciplina entity WHERE entity.id = :id", Disciplina.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<TurmaDisciplina> findTurmaDisciplina(java.lang.String id, int limit, int offset) {
      TypedQuery<TurmaDisciplina> query = this.entityManager.createQuery("SELECT entity FROM TurmaDisciplina entity WHERE entity.disciplina.id = :id", TurmaDisciplina.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Turma> listTurma(java.lang.String id, int limit, int offset) {
      TypedQuery<Turma> query = this.entityManager.createQuery("SELECT entity.turma FROM TurmaDisciplina entity WHERE entity.disciplina.id = :id", Turma.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteTurma(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM TurmaDisciplina entity WHERE entity.disciplina.id = :instanceId AND entity.turma.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<Disciplina> list(int limit, int offset){
      return this.entityManager.createNamedQuery("disciplinaList", Disciplina.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}