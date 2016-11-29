package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela ALUNO
 * @generated
 */
@Entity
@Table(name = "\"ALUNO\""


)
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
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_turma_1", referencedColumnName = "id", insertable=true, updatable=true)
  private Turma turma_1;
  
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
  public Aluno setId(java.lang.String id){
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
  public Aluno setNome(java.lang.String nome){
    this.nome = nome;
    return this;
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
  public Aluno setMatricula(java.lang.String matricula){
    this.matricula = matricula;
    return this;
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
  public Aluno setUser(java.lang.String user){
    this.user = user;
    return this;
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
  public Aluno setTurma(java.lang.String turma){
    this.turma = turma;
    return this;
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
  public Aluno setPeriodo(java.lang.String periodo){
    this.periodo = periodo;
    return this;
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
  public Aluno setSala(java.lang.String sala){
    this.sala = sala;
    return this;
  }
  
  /**
   * Obtém turma_1
   * @param turma_1 turma_1
   * return turma_1
   * @generated
   */
  public Turma getTurma_1(){
    return this.turma_1;
  }
  
  /**
   * Define turma_1
   * @param turma_1 turma_1
   * @generated
   */
  public Aluno setTurma_1(Turma turma_1){
    this.turma_1 = turma_1;
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
