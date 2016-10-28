package aol.dao;

import javax.persistence.*;
import aol.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class AvisoDAO extends BasicDAO<String, Aviso> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 63650824l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public AvisoDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Aviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Aviso entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Aviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Aviso findById(java.lang.String id){
      TypedQuery<Aviso> query = this.entityManager.createQuery("SELECT entity FROM Aviso entity WHERE entity.id = :id", Aviso.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<AlunoAviso> findAlunoAviso(java.lang.String id, int limit, int offset) {
      TypedQuery<AlunoAviso> query = this.entityManager.createQuery("SELECT entity FROM AlunoAviso entity WHERE entity.aviso.id = :id", AlunoAviso.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  /**
   * OneToMany Relation
   * @generated
   */
  public List<ResponsavelAviso> findResponsavelAviso(java.lang.String id, int limit, int offset) {
      TypedQuery<ResponsavelAviso> query = this.entityManager.createQuery("SELECT entity FROM ResponsavelAviso entity WHERE entity.aviso.id = :id", ResponsavelAviso.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }

  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Aluno> listAluno(java.lang.String id, int limit, int offset) {
      TypedQuery<Aluno> query = this.entityManager.createQuery("SELECT entity.aluno FROM AlunoAviso entity WHERE entity.aviso.id = :id", Aluno.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteAluno(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM AlunoAviso entity WHERE entity.aviso.id = :instanceId AND entity.aluno.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  
  /**
   * ManyToOne Relation
   * @generated
   */
  public List<Responsavel> listResponsavel(java.lang.String id, int limit, int offset) {
      TypedQuery<Responsavel> query = this.entityManager.createQuery("SELECT entity.responsavel FROM ResponsavelAviso entity WHERE entity.aviso.id = :id", Responsavel.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }
  
    /**
     * ManyToOne Relation Delete
     * @generated
     */
    public int deleteResponsavel(java.lang.String instanceId, java.lang.String relationId) {
      Query query = this.entityManager.createQuery("DELETE FROM ResponsavelAviso entity WHERE entity.aviso.id = :instanceId AND entity.responsavel.id = :relationId");
      query.setParameter("instanceId", instanceId);
      query.setParameter("relationId", relationId);

      return query.executeUpdate();	  
  }
  

  /**
   * NamedQuery list
   * @generated
   */
  public List<Aviso> list(int limit, int offset){
      return this.entityManager.createNamedQuery("avisoList", Aviso.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}