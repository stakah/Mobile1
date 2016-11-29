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
@Repository("AlunoResponsavelDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface AlunoResponsavelDAO extends JpaRepository<AlunoResponsavel, java.lang.String> {

  /**
   * Obtém a instância de AlunoResponsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM AlunoResponsavel entity WHERE entity.id = :id")
  public AlunoResponsavel findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de AlunoResponsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM AlunoResponsavel entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);








}