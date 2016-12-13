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
@Repository("MenuDAO")
@Transactional(transactionManager="metadata-TransactionManager")
public interface MenuDAO extends JpaRepository<Menu, java.lang.String> {

  /**
   * Obtém a instância de Menu utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Menu entity WHERE entity.id = :id")
  public Menu findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Menu utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Menu entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);

  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  @Query("select m from Menu m")
  public Page<Menu> list ( Pageable pageable );
  

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM MenuItems entity WHERE entity.menu.id = :id")
  public Page<MenuItems> findMenuItems(@Param(value="id") java.lang.String id,  Pageable pageable );



  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.menuItem FROM MenuItems entity WHERE entity.menu.id = :id")
  public Page<MenuItem> listMenuItem(@Param(value="id") java.lang.String id,  Pageable pageable);

    /**
     * ManyToOne Relation Delete
     * @generated
     */
    @Modifying
    @Query("DELETE FROM MenuItems entity WHERE entity.menu.id = :instanceId AND entity.menuItem.id = :relationId")
    public int deleteMenuItem(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);




}