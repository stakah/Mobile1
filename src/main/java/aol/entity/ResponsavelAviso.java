package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela RESPONSAVELAVISO
 * @generated
 */
@Entity
@Table(name = "\"RESPONSAVELAVISO\"")
@NamedQueries({
        @NamedQuery(name = "responsavelAvisoList", query = "select r from ResponsavelAviso r")
})
@XmlRootElement
public class ResponsavelAviso implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 1009547742l;
	
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
	@JoinColumn(name="fk_responsavel", referencedColumnName = "id", insertable=true, updatable=true)
	private Responsavel responsavel;
	
	/**
	 * @generated
	 */
	
	@ManyToOne
	@JoinColumn(name="fk_aviso", referencedColumnName = "id", insertable=true, updatable=true)
	private Aviso aviso;
	
	/**
	 * @generated
	 */
	
	@Column(name = "enviado", nullable = false, unique = false, insertable=true, updatable=true)
	private boolean enviado;
	
	/**
	 * @generated
	 */
	
	@Column(name = "lido", nullable = false, unique = false, insertable=true, updatable=true)
	private boolean lido;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public ResponsavelAviso(){
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
	 * Obtém aviso
	 * @param aviso aviso
	 * return aviso
	 * @generated
	 */
	public Aviso getAviso(){
		return this.aviso;
	}
	
	/**
	 * Define aviso
	 * @param aviso aviso
	 * @generated
	 */
	public void setAviso(Aviso aviso){
		this.aviso = aviso;
	}
	
	/**
	 * Obtém enviado
	 * @param enviado enviado
	 * return enviado
	 * @generated
	 */
	public boolean getEnviado(){
		return this.enviado;
	}
	
	/**
	 * Define enviado
	 * @param enviado enviado
	 * @generated
	 */
	public void setEnviado(boolean enviado){
		this.enviado = enviado;
	}
	
	/**
	 * Obtém lido
	 * @param lido lido
	 * return lido
	 * @generated
	 */
	public boolean getLido(){
		return this.lido;
	}
	
	/**
	 * Define lido
	 * @param lido lido
	 * @generated
	 */
	public void setLido(boolean lido){
		this.lido = lido;
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
	    
	    if(!(obj instanceof ResponsavelAviso))
	      return false;
	    
	    ResponsavelAviso other = (ResponsavelAviso)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}