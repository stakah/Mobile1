package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela USERROLE
 * @generated
 */
@Entity
@Table(name = "\"USERROLE\""


)
@XmlRootElement
public class UserRole implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = -201887997l;
  
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
  @JoinColumn(name="fk_user", referencedColumnName = "id", insertable=true, updatable=true)
  private User user;
  
  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_role", referencedColumnName = "id", insertable=true, updatable=true)
  private Role role;
  
  
  /**
   * Construtor
   * @generated
   */
  public UserRole(){
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
  public UserRole setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém user
   * @param user user
   * return user
   * @generated
   */
  public User getUser(){
    return this.user;
  }
  
  /**
   * Define user
   * @param user user
   * @generated
   */
  public UserRole setUser(User user){
    this.user = user;
    return this;
  }
  
  /**
   * Obtém role
   * @param role role
   * return role
   * @generated
   */
  public Role getRole(){
    return this.role;
  }
  
  /**
   * Define role
   * @param role role
   * @generated
   */
  public UserRole setRole(Role role){
    this.role = role;
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
      
      if(!(obj instanceof UserRole))
        return false;
      
      UserRole other = (UserRole)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
