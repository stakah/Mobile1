package aol.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * Classe que representa a tabela HORARIOAULA
 * @generated
 */
@Entity
@Table(name = "\"HORARIOAULA\""


)
@XmlRootElement
public class HorarioAula implements Serializable {

  /**
   * UID da classe, necessário na serialização 
   * @generated
   */
  private static final long serialVersionUID = 1994688408l;
  
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
  @JoinColumn(name="fk_calendario", referencedColumnName = "id", insertable=true, updatable=true)
  private Calendario calendario;
  /**
   * @generated
   */
  @ManyToOne
  @JoinColumn(name="fk_disciplina", referencedColumnName = "id", insertable=true, updatable=true)
  private Disciplina disciplina;
  /**
   * @generated
   */
  @Column(name = "diaSemana", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.Integer diaSemana;
  /**
   * @generated
   */
  @Column(name = "horaIni", nullable = false, unique = false, insertable=true, updatable=true)
  private java.lang.String horaIni;
  
  /**
   * Construtor
   * @generated
   */
  public HorarioAula(){
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
  public HorarioAula setId(java.lang.String id){
    this.id = id;
    return this;
  }
  
  /**
   * Obtém calendario
   * return calendario
   * @generated
   */
  public Calendario getCalendario(){
    return this.calendario;
  }
  
  /**
   * Define calendario
   * @param calendario calendario
   * @generated
   */
  public HorarioAula setCalendario(Calendario calendario){
    this.calendario = calendario;
    return this;
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
  public HorarioAula setDisciplina(Disciplina disciplina){
    this.disciplina = disciplina;
    return this;
  }
  
  /**
   * Obtém diaSemana
   * return diaSemana
   * @generated
   */
  public java.lang.Integer getDiaSemana(){
    return this.diaSemana;
  }
  
  /**
   * Define diaSemana
   * @param diaSemana diaSemana
   * @generated
   */
  public HorarioAula setDiaSemana(java.lang.Integer diaSemana){
    this.diaSemana = diaSemana;
    return this;
  }
  
  /**
   * Obtém horaIni
   * return horaIni
   * @generated
   */
  public java.lang.String getHoraIni(){
    return this.horaIni;
  }
  
  /**
   * Define horaIni
   * @param horaIni horaIni
   * @generated
   */
  public HorarioAula setHoraIni(java.lang.String horaIni){
    this.horaIni = horaIni;
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
      
      if(!(obj instanceof HorarioAula))
        return false;
      
      HorarioAula other = (HorarioAula)obj;
      
    if(this.id == null && other.id != null)
        return false;
      else if(!this.id.equals(other.id))
        return false;
  

      return true;
      
  }
}
