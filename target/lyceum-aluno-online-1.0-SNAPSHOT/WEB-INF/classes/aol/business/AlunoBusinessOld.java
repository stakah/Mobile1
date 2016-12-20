package aol.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.dao.*;
import aol.entity.*;



/**
 * Classe que representa a camada de negócios de AlunoBusiness
 * 
 * @generated
 **/
@Service("AlunoBusinessOld")
public class AlunoBusinessOld {


    /**
     * Instância da classe AlunoDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AlunoDAO")
    protected AlunoDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Aluno post(final Aluno entity) throws Exception {
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
    public Aluno get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Aluno result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Aluno put(final Aluno entity) throws Exception {
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
  public Page<Aluno> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Aluno> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<AlunoResponsavel> findAlunoResponsavel(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<AlunoResponsavel> result = repository.findAlunoResponsavel(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<AlunoAviso> findAlunoAviso(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<AlunoAviso> result = repository.findAlunoAviso(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Boletim> findBoletim(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Boletim> result = repository.findBoletim(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Calendario> findCalendario(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Calendario> result = repository.findCalendario(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }



  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Responsavel> listResponsavel(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Responsavel> result = repository.listResponsavel(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteResponsavel(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteResponsavel(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Aviso> listAviso(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Aviso> result = repository.listAviso(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteAviso(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteAviso(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
    public Aluno findByUserId(java.lang.String userId) {
      // begin-user-code  
      // end-user-code        
       Aluno result = repository.findOneByUserId(userId);
      // begin-user-code  
      // end-user-code        
      return result;
  }

}