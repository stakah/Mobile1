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
@Repository("MenuTypeDAO")
@Transactional(transactionManager="metadata-TransactionManager")
public interface MenuTypeDAO extends JpaRepository<MenuType, java.lang.String> {

  /**
   * Obtém a instância de MenuType utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM MenuType entity WHERE entity.id = :id")
  public MenuType findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de MenuType utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM MenuType entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select m from MenuType m")
  public Page<MenuType> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Menu entity WHERE entity.menuType.id = :id")
  public Page<Menu> findMenu(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM MenuItem entity WHERE entity.menuType.id = :id")
  public Page<MenuItem> findMenuItem(@Param(value="id") java.lang.String id,  Pageable pageable );






}