package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela ROLE
 * @generated
 */
@Entity
@Table(name = "\"ROLE\""


)
@XmlRootElement
public class Role implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = 2555048l;
  
  /**
   * @generated
   */
  @Column(name = "name", nullable = true, unique = false, insertable=true, updatable=true)
  private java.lang.String name;
  
  /**
   * @generated
   */
  @Id
    
  @Column(name = "id", insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
  
  
  /**
   * Construtor
   * @generated
   */
  public Role(){
  }

  
  /**
   * Obtém name
   * @param name name
   * return name
   * @generated
   */
  public java.lang.String getName(){
    return this.name;
  }
  
  /**
   * Define name
   * @param name name
   * @generated
   */
  public Role setName(java.lang.String name){
    this.name = name;
    return this;
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
  public Role setId(java.lang.String id){
    this.id = id;
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
      
      if(!(obj instanceof Role))
        return false;
      
      Role other = (Role)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
