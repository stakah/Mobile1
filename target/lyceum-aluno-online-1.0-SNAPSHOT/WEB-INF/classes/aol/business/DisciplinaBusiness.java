package aol.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.dao.*;
import aol.entity.*;



/**
 * Classe que representa a camada de negócios de DisciplinaBusiness
 * 
 * @generated
 **/
@Service("DisciplinaBusiness")
public class DisciplinaBusiness {


    /**
     * Instância da classe DisciplinaDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("DisciplinaDAO")
    protected DisciplinaDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Disciplina post(final Disciplina entity) throws Exception {
      // begin-user-code  
      // end-user-code  
        repository.save(entity);
      // begin-user-code  
      // end-user-code  
      return entity;
    }

    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public Disciplina get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Disciplina result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Disciplina put(final Disciplina entity) throws Exception {
      // begin-user-code  
      // end-user-code
        repository.saveAndFlush(entity);
      // begin-user-code  
      // end-user-code        
      return entity;
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public void delete( java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
      repository.delete(id);
      // begin-user-code  
      // end-user-code        
    }

    // CRUD
    
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Disciplina> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Disciplina> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<TurmaDisciplina> findTurmaDisciplina(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<TurmaDisciplina> result = repository.findTurmaDisciplina(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<HorarioAula> findHorarioAula(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<HorarioAula> result = repository.findHorarioAula(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }



  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Turma> listTurma(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Turma> result = repository.listTurma(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteTurma(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteTurma(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Calendario> listCalendario(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Calendario> result = repository.listCalendario(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteCalendario(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteCalendario(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
}