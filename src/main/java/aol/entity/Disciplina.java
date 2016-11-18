package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela DISCIPLINA
 * @generated
 */
@Entity
@Table(name = "\"DISCIPLINA\"")
@NamedQueries({
        @NamedQuery(name = "disciplinaList", query = "select d from Disciplina d")
})
@XmlRootElement
public class Disciplina implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -1941078204l;
	
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
	
	@Column(name = "nota", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.Double nota;
	
	/**
	 * @generated
	 */
	
	@ManyToOne
	@JoinColumn(name="fk_boletim", referencedColumnName = "id", insertable=true, updatable=true)
	private Boletim boletim;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Disciplina(){
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
	 * Obtém nota
	 * @param nota nota
	 * return nota
	 * @generated
	 */
	public java.lang.Double getNota(){
		return this.nota;
	}
	
	/**
	 * Define nota
	 * @param nota nota
	 * @generated
	 */
	public void setNota(java.lang.Double nota){
		this.nota = nota;
	}
	
	/**
	 * Obtém boletim
	 * @param boletim boletim
	 * return boletim
	 * @generated
	 */
	public Boletim getBoletim(){
		return this.boletim;
	}
	
	/**
	 * Define boletim
	 * @param boletim boletim
	 * @generated
	 */
	public void setBoletim(Boletim boletim){
		this.boletim = boletim;
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
	    
	    if(!(obj instanceof Disciplina))
	      return false;
	    
	    Disciplina other = (Disciplina)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}