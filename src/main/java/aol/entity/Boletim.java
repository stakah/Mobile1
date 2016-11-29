package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela BOLETIM
 * @generated
 */
@Entity
@Table(name = "\"BOLETIM\""


)
@XmlRootElement
public class Boletim implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = 1726402542l;
  
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
  @Column(name = "ano", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer ano;
  /**
   * @generated
   */
  @Column(name = "semestre", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer semestre;
  
  /**
   * Construtor
   * @generated
   */
  public Boletim(){
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
  public Boletim setId(java.lang.String id){
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
  public Boletim setAluno(Aluno aluno){
    this.aluno = aluno;
    return this;
  }
  
  /**
   * Obtém ano
   * @param ano ano
   * return ano
   * @generated
   */
  public java.lang.Integer getAno(){
    return this.ano;
  }
  
  /**
   * Define ano
   * @param ano ano
   * @generated
   */
  public Boletim setAno(java.lang.Integer ano){
    this.ano = ano;
    return this;
  }
  
  /**
   * Obtém semestre
   * @param semestre semestre
   * return semestre
   * @generated
   */
  public java.lang.Integer getSemestre(){
    return this.semestre;
  }
  
  /**
   * Define semestre
   * @param semestre semestre
   * @generated
   */
  public Boletim setSemestre(java.lang.Integer semestre){
    this.semestre = semestre;
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
      
      if(!(obj instanceof Boletim))
        return false;
      
      Boletim other = (Boletim)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
