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
@Repository("AlunoDAOOld")
@Transactional(transactionManager="aol-TransactionManager")
public interface AlunoDAOOld extends JpaRepository<Aluno, java.lang.String> {

  /**
   * Obtém a instância de Aluno utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Aluno entity WHERE entity.id = :id")
  public Aluno findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Aluno utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Aluno entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select a from Aluno a")
  public Page<Aluno> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AlunoResponsavel entity WHERE entity.aluno.id = :id")
  public Page<AlunoResponsavel> findAlunoResponsavel(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AlunoAviso entity WHERE entity.aluno.id = :id")
  public Page<AlunoAviso> findAlunoAviso(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Boletim entity WHERE entity.aluno.id = :id")
  public Page<Boletim> findBoletim(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Calendario entity WHERE entity.aluno.id = :id")
  public Page<Calendario> findCalendario(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.responsavel FROM AlunoResponsavel entity WHERE entity.aluno.id = :id")
  public Page<Responsavel> listResponsavel(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM AlunoResponsavel entity WHERE entity.aluno.id = :instanceId AND entity.responsavel.id = :relationId")
    public int deleteResponsavel(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.aviso FROM AlunoAviso entity WHERE entity.aluno.id = :id")
  public Page<Aviso> listAviso(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM AlunoAviso entity WHERE entity.aluno.id = :instanceId AND entity.aviso.id = :relationId")
    public int deleteAviso(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);



   /**
   * Obtém a instância de Aluno buscando pelo UserId
   * 
   * @param userId
   *          Identificador do usuario
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Aluno entity WHERE entity.user = :userId")
  public Aluno findOneByUserId(@Param(value="userId") java.lang.String userId);

}