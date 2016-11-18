package aol.business;

import aol.dao.*;
import aol.entity.*;

import java.util.*;

/**
 * Classe que representa a camada de negócios de Turma
 * @generated
 **/
public class TurmaBusiness {

  /**
   * Instância da classe TurmaDAO que faz o acesso ao banco de dados
   * @generated
   */
  private TurmaDAO dao;
  
  /**
   * Singleton de sessão usado para abrir e fechar conexão com o banco de dados
   * @generated
   */
  protected SessionManager sessionManager;
	
  /**
   * Copia referência da sessão e instancia DAO relacionada à essa classe para manipular o banco de dados
   * 
   * @param sessionmanager
   *          Singleton de sessão
   * @generated modifiable
   */
  public TurmaBusiness(final SessionManager sessionmanager) {
    // begin-user-code
    // end-user-code
    this.sessionManager = sessionmanager;
    this.dao = new TurmaDAO(sessionmanager.getEntityManager());
    // begin-user-code
    // end-user-code
  }
  
  /**
   * Construtor padrão, inicializa singleton de sessão
   * @generated modifiable   
   */
  public TurmaBusiness() {
    // begin-user-code
    // end-user-code  
    this(SessionManager.getInstance());
    // begin-user-code
    // end-user-code    
  }	

  /**
   * Grava valor no banco
   * 
   * @param entity Linha da tabela a ser persistida no banco de dados
   * @generated modifiable   
   */
  public void save(final Turma entity) {
    // begin-user-code
    // end-user-code  
    dao.save(entity);
    // begin-user-code
    // end-user-code    
  }
  
  /**
   * Dá um refresh na entidade com valores valor no banco
   * 
   * @param entity Entidade
   * @generated modifiable
   */
  public void refresh(final Turma entity) {
    // begin-user-code
    // end-user-code  
    dao.refresh(entity);
    // begin-user-code
    // end-user-code  
  }  
  
  /**
   * Atualiza valor do banco
   * 
   * @param entity Linha da tabela a ser atualizada
   * @generated modifiable   
   */
  public Turma update(final Turma entity) {
    // begin-user-code
    // end-user-code  
	Turma updatedEntity = dao.update(entity);
    // begin-user-code
    // end-user-code	
    return updatedEntity;
  }
  
  /**
   * Apaga valor do banco
   * 
   * @param entity Linha da tabela a ser excluída
   * @generated modifiable   
   */
  public void delete(final Turma entity){
    // begin-user-code
    // end-user-code    
	dao.delete(entity);
    // begin-user-code
    // end-user-code  	
  }
  
  /**
   * Remove a instância de Turma utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated modifiable   
   */  
  public int deleteById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    int result = dao.deleteById(id);
    // begin-user-code
    // end-user-code    
    return result;    
  }  
  
  /**
   * Obtém a instância de Turma utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated modifiable
   */  
  public Turma findById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    Turma entity = dao.findById(id);
    // begin-user-code
    // end-user-code      
    return entity;  
  }   
  
  /**
   * @generated modifiable
   */  
  public List<Aluno> findAluno(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<Aluno> result = dao.findAluno(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }

  /**
   * @generated modifiable
   */  
  public List<TurmaDisciplina> findTurmaDisciplina(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<TurmaDisciplina> result = dao.findTurmaDisciplina(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }


  /**
   * @generated modifiable
   */  
  public List<Disciplina> listDisciplina(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<Disciplina> result = dao.listDisciplina(id, limit, offset);
      // begin-user-code
      // end-user-code
      return result;        	  
  }
  
  /**
   * @generated modifiable
   */    
  public int deleteDisciplina(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = dao.deleteDisciplina(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
    
  
  /**
   * @generated modifiable
   */  	
  public List<Turma> list(int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<Turma> result = dao.list(limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
}
