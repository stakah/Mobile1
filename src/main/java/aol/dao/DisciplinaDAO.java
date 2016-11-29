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
@Repository("DisciplinaDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface DisciplinaDAO extends JpaRepository<Disciplina, java.lang.String> {

  /**
   * Obtém a instância de Disciplina utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Disciplina entity WHERE entity.id = :id")
  public Disciplina findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Disciplina utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Disciplina entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select d from Disciplina d")
  public Page<Disciplina> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM TurmaDisciplina entity WHERE entity.disciplina.id = :id")
  public Page<TurmaDisciplina> findTurmaDisciplina(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM HorarioAula entity WHERE entity.disciplina.id = :id")
  public Page<HorarioAula> findHorarioAula(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.turma FROM TurmaDisciplina entity WHERE entity.disciplina.id = :id")
  public Page<Turma> listTurma(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM TurmaDisciplina entity WHERE entity.disciplina.id = :instanceId AND entity.turma.id = :relationId")
    public int deleteTurma(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.calendario FROM HorarioAula entity WHERE entity.disciplina.id = :id")
  public Page<Calendario> listCalendario(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM HorarioAula entity WHERE entity.disciplina.id = :instanceId AND entity.calendario.id = :relationId")
    public int deleteCalendario(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}