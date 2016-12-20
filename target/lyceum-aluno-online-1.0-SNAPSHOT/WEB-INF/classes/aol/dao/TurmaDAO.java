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
@Repository("TurmaDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface TurmaDAO extends JpaRepository<Turma, java.lang.String> {

  /**
   * Obtém a instância de Turma utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Turma entity WHERE entity.id = :id")
  public Turma findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Turma utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Turma entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select t from Turma t")
  public Page<Turma> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Aluno entity WHERE entity.turma_1.id = :id")
  public Page<Aluno> findAluno(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM TurmaDisciplina entity WHERE entity.turma.id = :id")
  public Page<TurmaDisciplina> findTurmaDisciplina(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.disciplina FROM TurmaDisciplina entity WHERE entity.turma.id = :id")
  public Page<Disciplina> listDisciplina(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM TurmaDisciplina entity WHERE entity.turma.id = :instanceId AND entity.disciplina.id = :relationId")
    public int deleteDisciplina(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}