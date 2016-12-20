package metadata.dao;

import metadata.entity.*;


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
@Repository("SubmenuItemsDAO")
@Transactional(transactionManager="metadata-TransactionManager")
public interface SubmenuItemsDAO extends JpaRepository<SubmenuItems, java.lang.String> {

  /**
   * Obtém a instância de SubmenuItems utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM SubmenuItems entity WHERE entity.id = :id")
  public SubmenuItems findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de SubmenuItems utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM SubmenuItems entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select m from SubmenuItems m")
  public Page<SubmenuItems> list ( Pageable pageable );
  







}