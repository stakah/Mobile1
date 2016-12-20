package aol.dao;

import aol.entity.*;


import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*;



/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("ResponsavelDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface ResponsavelDAO extends JpaRepository<Responsavel, java.lang.String> {

  /**
   * Obtém a instância de Responsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Responsavel entity WHERE entity.id = :id")
  public Responsavel findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Responsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Responsavel entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select r from Responsavel r")
  public Page<Responsavel> list ( Pageable pageable );
  
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select r from Responsavel r where r.user LIKE CONCAT('%', COALESCE(:user, r.user),'%')")
  public Page<Responsavel> listByUser (@Param(value="user") java.lang.String user , Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AlunoResponsavel entity WHERE entity.responsavel.id = :id")
  public Page<AlunoResponsavel> findAlunoResponsavel(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ResponsavelAviso entity WHERE entity.responsavel.id = :id")
  public Page<ResponsavelAviso> findResponsavelAviso(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.aluno FROM AlunoResponsavel entity WHERE entity.responsavel.id = :id")
  public Page<Aluno> listAluno(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM AlunoResponsavel entity WHERE entity.responsavel.id = :instanceId AND entity.aluno.id = :relationId")
    public int deleteAluno(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.aviso FROM ResponsavelAviso entity WHERE entity.responsavel.id = :id")
  public Page<Aviso> listAviso(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM ResponsavelAviso entity WHERE entity.responsavel.id = :instanceId AND entity.aviso.id = :relationId")
    public int deleteAviso(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}