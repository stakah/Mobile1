package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela AVISO
 * @generated
 */
@Entity
@Table(name = "\"AVISO\"")
@NamedQueries({
        @NamedQuery(name = "avisoList", query = "select a from Aviso a")
})
@XmlRootElement
public class Aviso implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 63650824l;
	
	/**
	 * @generated
	 */
	@Id
    
	
	@Column(name = "id", insertable=true, updatable=true)
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	
	@Column(name = "title", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String title;
	
	/**
	 * @generated
	 */
	
	@Column(name = "content", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String content;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Aviso(){
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
	 * Obtém title
	 * @param title title
	 * return title
	 * @generated
	 */
	public java.lang.String getTitle(){
		return this.title;
	}
	
	/**
	 * Define title
	 * @param title title
	 * @generated
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	
	/**
	 * Obtém content
	 * @param content content
	 * return content
	 * @generated
	 */
	public java.lang.String getContent(){
		return this.content;
	}
	
	/**
	 * Define content
	 * @param content content
	 * @generated
	 */
	public void setContent(java.lang.String content){
		this.content = content;
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
	    
	    if(!(obj instanceof Aviso))
	      return false;
	    
	    Aviso other = (Aviso)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}