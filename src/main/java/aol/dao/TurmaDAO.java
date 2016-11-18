package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class TurmaDAO extends BasicDAO<String, Turma> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 81176345l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public TurmaDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Turma utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Turma entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Turma utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Turma findById(java.lang.String id){
      TypedQuery<Turma> query = this.entityManager.createQuery("SELECT entity FROM Turma entity WHERE entity.id = :id", Turma.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<Aluno> findAluno(java.lang.String id, int limit, int offset) {
      TypedQuery<Aluno> query = this.entityManager.createQuery("SELECT entity FROM Aluno entity WHERE entity.turma_1.id = :id", Aluno.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<TurmaDisciplina> findTurmaDisciplina(java.lang.String id, int limit, int offset) {
      TypedQuery<TurmaDisciplina> query = this.entityManager.createQuery("SELECT entity FROM TurmaDisciplina entity WHERE entity.turma.id = :id", TurmaDisciplina.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Disciplina> listDisciplina(java.lang.String id, int limit, int offset) {
      TypedQuery<Disciplina> query = this.entityManager.createQuery("SELECT entity.disciplina FROM TurmaDisciplina entity WHERE entity.turma.id = :id", Disciplina.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteDisciplina(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM TurmaDisciplina entity WHERE entity.turma.id = :instanceId AND entity.disciplina.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<Turma> list(int limit, int offset){
      return this.entityManager.createNamedQuery("turmaList", Turma.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}