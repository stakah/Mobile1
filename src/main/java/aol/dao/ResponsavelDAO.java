package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class ResponsavelDAO extends BasicDAO<String, Responsavel> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -779641406l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public ResponsavelDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Responsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Responsavel entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Responsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Responsavel findById(java.lang.String id){
      TypedQuery<Responsavel> query = this.entityManager.createQuery("SELECT entity FROM Responsavel entity WHERE entity.id = :id", Responsavel.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<AlunoResponsavel> findAlunoResponsavel(java.lang.String id, int limit, int offset) {
      TypedQuery<AlunoResponsavel> query = this.entityManager.createQuery("SELECT entity FROM AlunoResponsavel entity WHERE entity.responsavel.id = :id", AlunoResponsavel.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<ResponsavelAviso> findResponsavelAviso(java.lang.String id, int limit, int offset) {
      TypedQuery<ResponsavelAviso> query = this.entityManager.createQuery("SELECT entity FROM ResponsavelAviso entity WHERE entity.responsavel.id = :id", ResponsavelAviso.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Aluno> listAluno(java.lang.String id, int limit, int offset) {
      TypedQuery<Aluno> query = this.entityManager.createQuery("SELECT entity.aluno FROM AlunoResponsavel entity WHERE entity.responsavel.id = :id", Aluno.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteAluno(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM AlunoResponsavel entity WHERE entity.responsavel.id = :instanceId AND entity.aluno.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  
  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Aviso> listAviso(java.lang.String id, int limit, int offset) {
      TypedQuery<Aviso> query = this.entityManager.createQuery("SELECT entity.aviso FROM ResponsavelAviso entity WHERE entity.responsavel.id = :id", Aviso.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteAviso(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM ResponsavelAviso entity WHERE entity.responsavel.id = :instanceId AND entity.aviso.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<Responsavel> list(int limit, int offset){
      return this.entityManager.createNamedQuery("responsavelList", Responsavel.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
  /**
   * NamedQuery listByUser
   * @generated
   */
  public List<Responsavel> listByUser(java.lang.String user, int limit, int offset){
      return this.entityManager.createNamedQuery("responsavelListByUser", Responsavel.class).setParameter("user", user).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}