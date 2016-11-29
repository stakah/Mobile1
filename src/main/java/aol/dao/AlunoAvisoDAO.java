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
@Repository("AlunoAvisoDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface AlunoAvisoDAO extends JpaRepository<AlunoAviso, java.lang.String> {

  /**
   * Obtém a instância de AlunoAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM AlunoAviso entity WHERE entity.id = :id")
  public AlunoAviso findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de AlunoAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM AlunoAviso entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select a from AlunoAviso a")
  public Page<AlunoAviso> list ( Pageable pageable );
  







}