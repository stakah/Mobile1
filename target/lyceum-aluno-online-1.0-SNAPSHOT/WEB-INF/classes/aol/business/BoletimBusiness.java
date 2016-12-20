package aol.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.dao.*;
import aol.entity.*;



/**
 * Classe que representa a camada de negócios de BoletimBusiness
 * 
 * @generated
 **/
@Service("BoletimBusiness")
public class BoletimBusiness {


    /**
     * Instância da classe BoletimDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("BoletimDAO")
    protected BoletimDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Boletim post(final Boletim entity) throws Exception {
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
    public Boletim get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       Boletim result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public Boletim put(final Boletim entity) throws Exception {
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
  public Page<Boletim> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<Boletim> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<Disciplina> findDisciplina(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Disciplina> result = repository.findDisciplina(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

    public Page<BoletimDisciplinas> findBoletimDisciplinasByAlunoId(java.lang.String alunoId,  Pageable pageable) {
        // begin-user-code
        // end-user-code
        Page<BoletimDisciplinas> result = repository.findBoletimDisciplinasByAlunoId(alunoId,  pageable );
        // begin-user-code
        // end-user-code
        return result;
    }


}