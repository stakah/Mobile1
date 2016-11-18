package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela TURMA
 * @generated
 */
@Entity
@Table(name = "\"TURMA\"")
@NamedQueries({
        @NamedQuery(name = "turmaList", query = "select t from Turma t")
})
@XmlRootElement
public class Turma implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 81176345l;
	
	/**
	 * @generated
	 */
	@Id
    
	
	@Column(name = "id", insertable=true, updatable=true)
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	
	@Column(name = "turma", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String turma;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Turma(){
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
	 * Obtém turma
	 * @param turma turma
	 * return turma
	 * @generated
	 */
	public java.lang.String getTurma(){
		return this.turma;
	}
	
	/**
	 * Define turma
	 * @param turma turma
	 * @generated
	 */
	public void setTurma(java.lang.String turma){
		this.turma = turma;
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
	    
	    if(!(obj instanceof Turma))
	      return false;
	    
	    Turma other = (Turma)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}