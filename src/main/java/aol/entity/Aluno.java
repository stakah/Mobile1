package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela ALUNO
 * @generated
 */
@Entity
@Table(name = "\"ALUNO\"")
@NamedQueries({
        @NamedQuery(name = "alunoList", query = "select a from Aluno a")
})
@XmlRootElement
public class Aluno implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 63364293l;
	
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
	
	@Column(name = "matricula", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String matricula;
	
	/**
	 * @generated
	 */
	
	@Column(name = "user", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String user;
	
	/**
	 * @generated
	 */
	
	@Column(name = "turma", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String turma;
	
	/**
	 * @generated
	 */
	
	@Column(name = "periodo", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String periodo;
	
	/**
	 * @generated
	 */
	
	@Column(name = "sala", nullable = false, unique = false, insertable=true, updatable=true)
	private java.lang.String sala;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Aluno(){
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
	 * Obtém matricula
	 * @param matricula matricula
	 * return matricula
	 * @generated
	 */
	public java.lang.String getMatricula(){
		return this.matricula;
	}
	
	/**
	 * Define matricula
	 * @param matricula matricula
	 * @generated
	 */
	public void setMatricula(java.lang.String matricula){
		this.matricula = matricula;
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
	 * Obtém periodo
	 * @param periodo periodo
	 * return periodo
	 * @generated
	 */
	public java.lang.String getPeriodo(){
		return this.periodo;
	}
	
	/**
	 * Define periodo
	 * @param periodo periodo
	 * @generated
	 */
	public void setPeriodo(java.lang.String periodo){
		this.periodo = periodo;
	}
	
	/**
	 * Obtém sala
	 * @param sala sala
	 * return sala
	 * @generated
	 */
	public java.lang.String getSala(){
		return this.sala;
	}
	
	/**
	 * Define sala
	 * @param sala sala
	 * @generated
	 */
	public void setSala(java.lang.String sala){
		this.sala = sala;
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
	    
	    if(!(obj instanceof Aluno))
	      return false;
	    
	    Aluno other = (Aluno)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}