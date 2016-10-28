package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela ALUNORESPONSAVEL
 * @generated
 */
@Entity
@Table(name = "\"ALUNORESPONSAVEL\"")
@NamedQueries({
})
@XmlRootElement
public class AlunoResponsavel implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 215116927l;
	
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
	@JoinColumn(name="fk_aluno", referencedColumnName = "id", insertable=true, updatable=true)
	private Aluno aluno;
	
	/**
	 * @generated
	 */
	
	@ManyToOne
	@JoinColumn(name="fk_responsavel", referencedColumnName = "id", insertable=true, updatable=true)
	private Responsavel responsavel;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public AlunoResponsavel(){
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
	 * Obtém aluno
	 * @param aluno aluno
	 * return aluno
	 * @generated
	 */
	public Aluno getAluno(){
		return this.aluno;
	}
	
	/**
	 * Define aluno
	 * @param aluno aluno
	 * @generated
	 */
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}
	
	/**
	 * Obtém responsavel
	 * @param responsavel responsavel
	 * return responsavel
	 * @generated
	 */
	public Responsavel getResponsavel(){
		return this.responsavel;
	}
	
	/**
	 * Define responsavel
	 * @param responsavel responsavel
	 * @generated
	 */
	public void setResponsavel(Responsavel responsavel){
		this.responsavel = responsavel;
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
	    
	    if(!(obj instanceof AlunoResponsavel))
	      return false;
	    
	    AlunoResponsavel other = (AlunoResponsavel)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}