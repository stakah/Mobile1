package aol.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.dao.*;
import aol.entity.*;



/**
 * Classe que representa a camada de negócios de AvisoBusiness
 * 
 * @generated
 **/
@Service("AvisoBusiness")
public class AvisoBusiness {


    /**
     * Instância da classe AvisoDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AvisoDAO")
    protected AvisoDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Aviso post(final Aviso entity) throws Exception {
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
    public Aviso get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Aviso result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Aviso put(final Aviso entity) throws Exception {
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
  public Page<Aviso> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Aviso> result = repository.list (  pageable );
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
}