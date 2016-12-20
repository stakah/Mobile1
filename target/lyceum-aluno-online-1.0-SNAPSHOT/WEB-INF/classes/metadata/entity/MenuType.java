package metadata.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela MENUTYPE
 * @generated
 */
@Entity
@Table(name = "\"MENUTYPE\""


)
@XmlRootElement
public class MenuType implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = -539116183l;
  
  /**
   * @generated
   */
  @Id
    
  @Column(name = "id", insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  /**
   * @generated
   */
  @Column(name = "type", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.String type;
  
  /**
   * Construtor
   * @generated
   */
  public MenuType(){
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
  public MenuType setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém type
   * @param type type
   * return type
   * @generated
   */
  public java.lang.String getType(){
    return this.type;
  }
  
  /**
   * Define type
   * @param type type
   * @generated
   */
  public MenuType setType(java.lang.String type){
    this.type = type;
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
      
      if(!(obj instanceof MenuType))
        return false;
      
      MenuType other = (MenuType)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
