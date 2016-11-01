package metadata.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela SUBMENUITEMS
 * @generated
 */
@Entity
@Table(name = "\"SUBMENUITEMS\"")
@NamedQueries({
        @NamedQuery(name = "submenuItemsList", query = "select m from SubmenuItems m")
})
@XmlRootElement
public class SubmenuItems implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1291515072l;
	
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
	@JoinColumn(name="menuItemParent", referencedColumnName = "id", insertable=true, updatable=true)
	private MenuItem menuItemParent;
	
	/**
	 * @generated
	 */
	
	@ManyToOne
	@JoinColumn(name="menuItemChild", referencedColumnName = "id", insertable=true, updatable=true)
	private MenuItem menuItemChild;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public SubmenuItems(){
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
	 * Obtém menuItemParent
	 * @param menuItemParent menuItemParent
	 * return menuItemParent
	 * @generated
	 */
	public MenuItem getMenuItemParent(){
		return this.menuItemParent;
	}
	
	/**
	 * Define menuItemParent
	 * @param menuItemParent menuItemParent
	 * @generated
	 */
	public void setMenuItemParent(MenuItem menuItemParent){
		this.menuItemParent = menuItemParent;
	}
	
	/**
	 * Obtém menuItemChild
	 * @param menuItemChild menuItemChild
	 * return menuItemChild
	 * @generated
	 */
	public MenuItem getMenuItemChild(){
		return this.menuItemChild;
	}
	
	/**
	 * Define menuItemChild
	 * @param menuItemChild menuItemChild
	 * @generated
	 */
	public void setMenuItemChild(MenuItem menuItemChild){
		this.menuItemChild = menuItemChild;
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
	    
	    if(!(obj instanceof SubmenuItems))
	      return false;
	    
	    SubmenuItems other = (SubmenuItems)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}