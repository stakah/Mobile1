package aol.business;

import aol.dao.AlunoDAO;
import aol.entity.Aluno;
import aol.entity.AlunoResponsavel;
import aol.entity.AlunoAviso;
import aol.entity.Boletim;
import aol.entity.Disciplina;
import aol.entity.Calendario;
import aol.entity.Responsavel;
import aol.entity.Aviso;
import aol.entity.HorariosAulaAluno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aol.bean.HorarioAula;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa a camada de negócios de AlunoBusiness
 * 
 * @generated
 **/
@Service("AlunoBusiness")
public class AlunoBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoBusiness.class);
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
  public Page<Boletim> findBoletim(java.lang.String id, Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<Boletim> result = repository.findBoletim(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;    
  }

    public Page<Disciplina> getBoletimId(java.lang.String id, Pageable pageable) {
        // begin-user-code
        // end-user-code
        Page<Disciplina> result = repository.getBoletimId(id,  pageable );
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

    public Page<HorariosAulaAluno> listHorariosAulaAluno(java.lang.String alunoId, Pageable pageable) {
        // begin-user-code
        // end-user-code
        Page<HorariosAulaAluno> result = repository.listHorariosAulaAluno(alunoId, pageable);
        // begin-user-code
        // end-user-code
        return result;
    }

    public Page<HorarioAula> listHorariosAula(String alunoId, Pageable pageable) {
        LOGGER.info("alunoId: " + alunoId);
        ArrayList<HorarioAula> arr = new ArrayList<HorarioAula>();
        Page<HorariosAulaAluno> pg = repository.listHorariosAulaAluno(alunoId, pageable);
        List<HorariosAulaAluno> list = pg.getContent();
        for (HorariosAulaAluno h : list) {
            HorarioAula ha = new HorarioAula(
                    h.getCalendario().getAno(),
                    h.getCalendario().getSemestre(),
                    h.getHorarioAula().getDiaSemana(),
                    h.getDisciplina().getNome(),
                    h.getHorarioAula().getHoraIni(),
                    h.getDisciplina().getIcone()
            );
            LOGGER.info("horarioAula:" + ha.toString());

            arr.add(ha);
        }

        Page<HorarioAula> horariosPage = new PageImpl<HorarioAula>(arr, pageable, arr.size());
        return horariosPage;
    }
}