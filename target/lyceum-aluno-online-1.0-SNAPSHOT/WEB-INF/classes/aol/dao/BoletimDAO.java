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
@Repository("BoletimDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface BoletimDAO extends JpaRepository<Boletim, java.lang.String> {

  /**
   * Obtém a instância de Boletim utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Boletim entity WHERE entity.id = :id")
  public Boletim findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Boletim utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Boletim entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select b from Boletim b")
  public Page<Boletim> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Disciplina entity WHERE entity.boletim.id = :id")
  public Page<Disciplina> findDisciplina(@Param(value="id") java.lang.String id,  Pageable pageable );

  @Query("SELECT new aol.entity.BoletimDisciplinas(b,d,t) FROM Boletim b, Disciplina d, TurmaDisciplina t WHERE b.aluno.id = :alunoId AND b.id = d.boletim.id AND t.disciplina.id = d.id")
  public Page<BoletimDisciplinas> findBoletimDisciplinasByAlunoId(@Param(value="alunoId") java.lang.String alunoId, Pageable pageable);





}