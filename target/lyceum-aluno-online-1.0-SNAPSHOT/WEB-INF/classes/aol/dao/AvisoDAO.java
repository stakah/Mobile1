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
@Repository("AvisoDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface AvisoDAO extends JpaRepository<Aviso, java.lang.String> {

  /**
   * Obtém a instância de Aviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Aviso entity WHERE entity.id = :id")
  public Aviso findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Aviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Aviso entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select a from Aviso a")
  public Page<Aviso> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM AlunoAviso entity WHERE entity.aviso.id = :id")
  public Page<AlunoAviso> findAlunoAviso(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM ResponsavelAviso entity WHERE entity.aviso.id = :id")
  public Page<ResponsavelAviso> findResponsavelAviso(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.aluno FROM AlunoAviso entity WHERE entity.aviso.id = :id")
  public Page<Aluno> listAluno(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM AlunoAviso entity WHERE entity.aviso.id = :instanceId AND entity.aluno.id = :relationId")
    public int deleteAluno(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.responsavel FROM ResponsavelAviso entity WHERE entity.aviso.id = :id")
  public Page<Responsavel> listResponsavel(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM ResponsavelAviso entity WHERE entity.aviso.id = :instanceId AND entity.responsavel.id = :relationId")
    public int deleteResponsavel(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}