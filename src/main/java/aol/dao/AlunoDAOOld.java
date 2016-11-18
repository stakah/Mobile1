package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class AlunoDAOOld extends BasicDAO<String, Aluno> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 63364293l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public AlunoDAOOld(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Aluno utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Aluno entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Aluno utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Aluno findById(java.lang.String id){
      TypedQuery<Aluno> query = this.entityManager.createQuery("SELECT entity FROM Aluno entity WHERE entity.id = :id", Aluno.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  public Aluno findByUserId(java.lang.String userId){
      TypedQuery<Aluno> query = this.entityManager.createQuery("SELECT entity FROM Aluno entity WHERE entity.user = :id", Aluno.class);
      query.setParameter("id", userId);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<AlunoResponsavel> findAlunoResponsavel(java.lang.String id, int limit, int offset) {
      TypedQuery<AlunoResponsavel> query = this.entityManager.createQuery("SELECT entity FROM AlunoResponsavel entity WHERE entity.aluno.id = :id", AlunoResponsavel.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<AlunoAviso> findAlunoAviso(java.lang.String id, int limit, int offset) {
      TypedQuery<AlunoAviso> query = this.entityManager.createQuery("SELECT entity FROM AlunoAviso entity WHERE entity.aluno.id = :id", AlunoAviso.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Responsavel> listResponsavel(java.lang.String id, int limit, int offset) {
      TypedQuery<Responsavel> query = this.entityManager.createQuery("SELECT entity.responsavel FROM AlunoResponsavel entity WHERE entity.aluno.id = :id", Responsavel.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteResponsavel(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM AlunoResponsavel entity WHERE entity.aluno.id = :instanceId AND entity.responsavel.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  
  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Aviso> listAviso(java.lang.String id, int limit, int offset) {
      TypedQuery<Aviso> query = this.entityManager.createQuery("SELECT entity.aviso FROM AlunoAviso entity WHERE entity.aluno.id = :id", Aviso.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteAviso(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM AlunoAviso entity WHERE entity.aluno.id = :instanceId AND entity.aviso.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<Aluno> list(int limit, int offset){
      return this.entityManager.createNamedQuery("alunoList", Aluno.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}