package metadata.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela MENUITEMS
 * @generated
 */
@Entity
@Table(name = "\"MENUITEMS\""


)
@XmlRootElement
public class MenuItems implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = 456887670l;
  
  /**
   * @generated
   */
  @Id
    
  @Column(name = "id", insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_menu", referencedColumnName = "id", insertable=true, updatable=true)
  private Menu menu;
  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_menuItem", referencedColumnName = "id", insertable=true, updatable=true)
  private MenuItem menuItem;
  
  /**
   * Construtor
   * @generated
   */
  public MenuItems(){
  }

  
  /**
   * Obtém id
   * @param id id
   * return id
   * @generated
   */
  public java.lang.String getId(){
    return this.id;
  }
  
  /**
   * Define id
   * @param id id
   * @generated
   */
  public MenuItems setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém menu
   * @param menu menu
   * return menu
   * @generated
   */
  public Menu getMenu(){
    return this.menu;
  }
  
  /**
   * Define menu
   * @param menu menu
   * @generated
   */
  public MenuItems setMenu(Menu menu){
    this.menu = menu;
    return this;
  }
  
  /**
   * Obtém menuItem
   * @param menuItem menuItem
   * return menuItem
   * @generated
   */
  public MenuItem getMenuItem(){
    return this.menuItem;
  }
  
  /**
   * Define menuItem
   * @param menuItem menuItem
   * @generated
   */
  public MenuItems setMenuItem(MenuItem menuItem){
    this.menuItem = menuItem;
    return this;
  }
  
  /**
   * @generated
   */
  @Override
  public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }
  
  /**
   * @generated
   */ 
  @Override
    public boolean equals(Object obj) {
    
      if(this == obj)
        return true;
      
      if(obj == null)
        return false;
      
      if(!(obj instanceof MenuItems))
        return false;
      
      MenuItems other = (MenuItems)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
