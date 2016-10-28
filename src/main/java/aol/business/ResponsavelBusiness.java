package aol.business;

import aol.dao.*;
import aol.entity.*;

import java.util.*;

/**
 * Classe que representa a camada de negócios de Responsavel
 * @generated
 **/
public class ResponsavelBusiness {

  /**
   * Instância da classe ResponsavelDAO que faz o acesso ao banco de dados
   * @generated
   */
  private ResponsavelDAO dao;
  
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
  public ResponsavelBusiness(final SessionManager sessionmanager) {
    // begin-user-code
    // end-user-code
    this.sessionManager = sessionmanager;
    this.dao = new ResponsavelDAO(sessionmanager.getEntityManager());
    // begin-user-code
    // end-user-code
  }
  
  /**
   * Construtor padrão, inicializa singleton de sessão
   * @generated modifiable   
   */
  public ResponsavelBusiness() {
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
  public void save(final Responsavel entity) {
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
  public void refresh(final Responsavel entity) {
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
  public Responsavel update(final Responsavel entity) {
    // begin-user-code
    // end-user-code  
	Responsavel updatedEntity = dao.update(entity);
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
  public void delete(final Responsavel entity){
    // begin-user-code
    // end-user-code    
	dao.delete(entity);
    // begin-user-code
    // end-user-code  	
  }
  
  /**
   * Remove a instância de Responsavel utilizando os identificadores
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
   * Obtém a instância de Responsavel utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated modifiable
   */  
  public Responsavel findById(java.lang.String id){
    // begin-user-code
    // end-user-code  
    Responsavel entity = dao.findById(id);
    // begin-user-code
    // end-user-code      
    return entity;  
  }   
  
  /**
   * @generated modifiable
   */  
  public List<AlunoResponsavel> findAlunoResponsavel(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<AlunoResponsavel> result = dao.findAlunoResponsavel(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }

  /**
   * @generated modifiable
   */  
  public List<ResponsavelAviso> findResponsavelAviso(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<ResponsavelAviso> result = dao.findResponsavelAviso(id, limit, offset);
      // begin-user-code  
      // end-user-code        
      return result;	  
  }


  /**
   * @generated modifiable
   */  
  public List<Aluno> listAluno(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<Aluno> result = dao.listAluno(id, limit, offset);
      // begin-user-code
      // end-user-code
      return result;        	  
  }
  
  /**
   * @generated modifiable
   */    
  public int deleteAluno(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = dao.deleteAluno(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
    
  /**
   * @generated modifiable
   */  
  public List<Aviso> listAviso(java.lang.String id, int limit, int offset) {
      // begin-user-code
      // end-user-code  
      List<Aviso> result = dao.listAviso(id, limit, offset);
      // begin-user-code
      // end-user-code
      return result;        	  
  }
  
  /**
   * @generated modifiable
   */    
  public int deleteAviso(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = dao.deleteAviso(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
    
  
  /**
   * @generated modifiable
   */  	
  public List<Responsavel> list(int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<Responsavel> result = dao.list(limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
  /**
   * @generated modifiable
   */  	
  public List<Responsavel> listByUser(java.lang.String user, int limit, int offset){
      // begin-user-code
      // end-user-code  
      List<Responsavel> result = dao.listByUser(user, limit, offset);
      // begin-user-code
      // end-user-code        
      return result;	
  }  
}
