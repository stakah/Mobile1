package aol.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.dao.*;
import aol.entity.*;



/**
 * Classe que representa a camada de negócios de TurmaBusiness
 * 
 * @generated
 **/
@Service("TurmaBusiness")
public class TurmaBusiness {


    /**
     * Instância da classe TurmaDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("TurmaDAO")
    protected TurmaDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Turma post(final Turma entity) throws Exception {
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
    public Turma get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Turma result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Turma put(final Turma entity) throws Exception {
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
  public Page<Turma> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Turma> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Aluno> findAluno(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Aluno> result = repository.findAluno(id,  pageable );
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
   * ManyToMany Relation
   */  
  public Page<Disciplina> listDisciplina(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Disciplina> result = repository.listDisciplina(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteDisciplina(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteDisciplina(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
}