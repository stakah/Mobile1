package metadata.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela MENU
 * @generated
 */
@Entity
@Table(name = "\"MENU\"")
@NamedQueries({
        @NamedQuery(name = "menuList", query = "select m from Menu m")
})
@XmlRootElement
public class Menu implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 2396540l;
	
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
	@JoinColumn(name="fk_menuType", referencedColumnName = "id", insertable=true, updatable=true)
	private MenuType menuType;
	
	/**
	 * @generated
	 */
	
	@Column(name = "role", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String role;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Menu(){
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
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 * Obtém menuType
	 * @param menuType menuType
	 * return menuType
	 * @generated
	 */
	public MenuType getMenuType(){
		return this.menuType;
	}
	
	/**
	 * Define menuType
	 * @param menuType menuType
	 * @generated
	 */
	public void setMenuType(MenuType menuType){
		this.menuType = menuType;
	}
	
	/**
	 * Obtém role
	 * @param role role
	 * return role
	 * @generated
	 */
	public java.lang.String getRole(){
		return this.role;
	}
	
	/**
	 * Define role
	 * @param role role
	 * @generated
	 */
	public void setRole(java.lang.String role){
		this.role = role;
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
	    
	    if(!(obj instanceof Menu))
	      return false;
	    
	    Menu other = (Menu)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}