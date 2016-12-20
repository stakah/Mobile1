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
@Repository("MenuItemDAO")
@Transactional(transactionManager="metadata-TransactionManager")
public interface MenuItemDAO extends JpaRepository<MenuItem, java.lang.String> {

  /**
   * Obtém a instância de MenuItem utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM MenuItem entity WHERE entity.id = :id")
  public MenuItem findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de MenuItem utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM MenuItem entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select m from MenuItem m")
  public Page<MenuItem> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemParent.id = :id")
  public Page<SubmenuItems> findSubmenuItems(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemChild.id = :id")
  public Page<SubmenuItems> findSubmenuItems_2(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemParent.id = :id")
  public Page<SubmenuItems> findSubmenuItems_3(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM SubmenuItems entity WHERE entity.menuItemChild.id = :id")
  public Page<SubmenuItems> findSubmenuItems_4(@Param(value="id") java.lang.String id,  Pageable pageable );
  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM MenuItems entity WHERE entity.menuItem.id = :id")
  public Page<MenuItems> findMenuItems(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.menu FROM MenuItems entity WHERE entity.menuItem.id = :id")
  public Page<Menu> listMenu(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM MenuItems entity WHERE entity.menuItem.id = :instanceId AND entity.menu.id = :relationId")
    public int deleteMenu(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}