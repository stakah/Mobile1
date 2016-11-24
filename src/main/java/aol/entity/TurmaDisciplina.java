package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela TURMADISCIPLINA
 * @generated
 */
@Entity
@Table(name = "\"TURMADISCIPLINA\"")
@NamedQueries({
        @NamedQuery(name = "turmaDisciplinaList", query = "select t from TurmaDisciplina t")
})
@XmlRootElement
public class TurmaDisciplina implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 709725239l;
	
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
	@JoinColumn(name="fk_turma", referencedColumnName = "id", insertable=true, updatable=true)
	private Turma turma;
	
	/**
	 * @generated
	 */
	
	@ManyToOne
	@JoinColumn(name="fk_disciplina", referencedColumnName = "id", insertable=true, updatable=true)
	private Disciplina disciplina;
	
	/**
	 * @generated
	 */
	
	@Column(name = "media", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.Double media;

	/**
	 * Construtor
	 * @generated
	 */
	public TurmaDisciplina(){
	}

	
	/**
	 * Obtém id
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
	 * return turma
	 * @generated
	 */
	public Turma getTurma(){
		return this.turma;
	}
	
	/**
	 * Define turma
	 * @param turma turma
	 * @generated
	 */
	public void setTurma(Turma turma){
		this.turma = turma;
	}
	
	/**
	 * Obtém disciplina
	 * return disciplina
	 * @generated
	 */
	public Disciplina getDisciplina(){
		return this.disciplina;
	}
	
	/**
	 * Define disciplina
	 * @param disciplina disciplina
	 * @generated
	 */
	public void setDisciplina(Disciplina disciplina){
		this.disciplina = disciplina;
	}
	
	/**
	 * Obtém media
	 * return media
	 * @generated
	 */
	public java.lang.Double getMedia(){
		return this.media;
	}
	
	/**
	 * Define media
	 * @param media media
	 * @generated
	 */
	public void setMedia(java.lang.Double media){
		this.media = media;
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
	    
	    if(!(obj instanceof TurmaDisciplina))
	      return false;
	    
	    TurmaDisciplina other = (TurmaDisciplina)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}