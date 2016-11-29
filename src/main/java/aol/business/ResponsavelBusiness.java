package aol.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.dao.*;
import aol.entity.*;



/**
 * Classe que representa a camada de negócios de ResponsavelBusiness
 * 
 * @generated
 **/
@Service("ResponsavelBusiness")
public class ResponsavelBusiness {


    /**
     * Instância da classe ResponsavelDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("ResponsavelDAO")
    protected ResponsavelDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Responsavel post(final Responsavel entity) throws Exception {
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
    public Responsavel get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Responsavel result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Responsavel put(final Responsavel entity) throws Exception {
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
  public Page<Responsavel> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Responsavel> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<Responsavel> listByUser ( java.lang.String user , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Responsavel> result = repository.listByUser ( user ,  pageable );
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
  public Page<ResponsavelAviso> findResponsavelAviso(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<ResponsavelAviso> result = repository.findResponsavelAviso(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }



  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Aluno> listAluno(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Aluno> result = repository.listAluno(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;            
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteAluno(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteAluno(instanceId, relationId);
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
}