package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela RESPONSAVEL
 * @generated
 */
@Entity
@Table(name = "\"RESPONSAVEL\"")
@NamedQueries({
        @NamedQuery(name = "responsavelList", query = "select r from Responsavel r"),
        @NamedQuery(name = "responsavelListByUser", query = "select r from Responsavel r where r.user LIKE CONCAT('%', COALESCE(:user, r.user),'%')")
})
@XmlRootElement
public class Responsavel implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -779641406l;
	
	/**
	 * @generated
	 */
	@Id
    
	
	@Column(name = "id", insertable=true, updatable=true)
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	
	@Column(name = "nome", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String nome;
	
	/**
	 * @generated
	 */
	
	@Column(name = "user", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String user;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Responsavel(){
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
	 * Obtém nome
	 * @param nome nome
	 * return nome
	 * @generated
	 */
	public java.lang.String getNome(){
		return this.nome;
	}
	
	/**
	 * Define nome
	 * @param nome nome
	 * @generated
	 */
	public void setNome(java.lang.String nome){
		this.nome = nome;
	}
	
	/**
	 * Obtém user
	 * @param user user
	 * return user
	 * @generated
	 */
	public java.lang.String getUser(){
		return this.user;
	}
	
	/**
	 * Define user
	 * @param user user
	 * @generated
	 */
	public void setUser(java.lang.String user){
		this.user = user;
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
	    
	    if(!(obj instanceof Responsavel))
	      return false;
	    
	    Responsavel other = (Responsavel)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}