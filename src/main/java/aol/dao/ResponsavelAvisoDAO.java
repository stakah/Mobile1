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
@Repository("ResponsavelAvisoDAO")
@Transactional(transactionManager="aol-TransactionManager")
public interface ResponsavelAvisoDAO extends JpaRepository<ResponsavelAviso, java.lang.String> {

  /**
   * Obtém a instância de ResponsavelAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM ResponsavelAviso entity WHERE entity.id = :id")
  public ResponsavelAviso findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de ResponsavelAviso utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM ResponsavelAviso entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select r from ResponsavelAviso r")
  public Page<ResponsavelAviso> list ( Pageable pageable );
  







}