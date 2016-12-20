package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela ALUNOAVISO
 * @generated
 */
@Entity
@Table(name = "\"ALUNOAVISO\""


)
@XmlRootElement
public class AlunoAviso implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = -1987006935l;
  
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
  public AlunoAviso(){
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
  public AlunoAviso setId(java.lang.String id){
    this.id = id;
    return this;
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
  public AlunoAviso setAluno(Aluno aluno){
    this.aluno = aluno;
    return this;
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
  public AlunoAviso setAviso(Aviso aviso){
    this.aviso = aviso;
    return this;
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
  public AlunoAviso setEnviado(boolean enviado){
    this.enviado = enviado;
    return this;
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
  public AlunoAviso setLido(boolean lido){
    this.lido = lido;
    return this;
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
      
      if(!(obj instanceof AlunoAviso))
        return false;
      
      AlunoAviso other = (AlunoAviso)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
