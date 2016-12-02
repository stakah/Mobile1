package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela DISCIPLINA
 * @generated
 */
@Entity
@Table(name = "\"DISCIPLINA\""


)
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
  @Column(name = "icone", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.String icone;


  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_boletim", referencedColumnName = "id", insertable=true, updatable=true)
  private Boletim boletim;
  /**
   * @generated
   */
  @Column(name = "aulas_previstas", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer aulas_previstas;
  /**
   * @generated
   */
  @Column(name = "aulas_ministradas", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer aulas_ministradas;
  /**
   * @generated
   */
  @Column(name = "faltas", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer faltas;
  /**
   * @generated
   */
  @Column(name = "aprovado", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.String aprovado;
  
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
  public Disciplina setId(java.lang.String id){
    this.id = id;
    return this;
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
  public Disciplina setNome(java.lang.String nome){
    this.nome = nome;
    return this;
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
  public Disciplina setNota(java.lang.Double nota){
    this.nota = nota;
    return this;
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
  public Disciplina setBoletim(Boletim boletim){
    this.boletim = boletim;
    return this;
  }
  
  /**
   * Obtém aulas_previstas
   * @param aulas_previstas aulas_previstas
   * return aulas_previstas
   * @generated
   */
  public java.lang.Integer getAulas_previstas(){
    return this.aulas_previstas;
  }
  
  /**
   * Define aulas_previstas
   * @param aulas_previstas aulas_previstas
   * @generated
   */
  public Disciplina setAulas_previstas(java.lang.Integer aulas_previstas){
    this.aulas_previstas = aulas_previstas;
    return this;
  }
  
  /**
   * Obtém aulas_ministradas
   * @param aulas_ministradas aulas_ministradas
   * return aulas_ministradas
   * @generated
   */
  public java.lang.Integer getAulas_ministradas(){
    return this.aulas_ministradas;
  }
  
  /**
   * Define aulas_ministradas
   * @param aulas_ministradas aulas_ministradas
   * @generated
   */
  public Disciplina setAulas_ministradas(java.lang.Integer aulas_ministradas){
    this.aulas_ministradas = aulas_ministradas;
    return this;
  }
  
  /**
   * Obtém faltas
   * @param faltas faltas
   * return faltas
   * @generated
   */
  public java.lang.Integer getFaltas(){
    return this.faltas;
  }
  
  /**
   * Define faltas
   * @param faltas faltas
   * @generated
   */
  public Disciplina setFaltas(java.lang.Integer faltas){
    this.faltas = faltas;
    return this;
  }
  
  /**
   * Obtém aprovado
   * @param aprovado aprovado
   * return aprovado
   * @generated
   */
  public java.lang.String getAprovado(){
    return this.aprovado;
  }
  
  /**
   * Define aprovado
   * @param aprovado aprovado
   * @generated
   */
  public Disciplina setAprovado(java.lang.String aprovado){
    this.aprovado = aprovado;
    return this;
  }

  public String getIcone() {
    return icone;
  }

  public void setIcone(String icone) {
    this.icone = icone;
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
