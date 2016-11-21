package aol.rest;

import aol.business.BoletimBusiness;
import aol.business.TurmaBusiness;
import aol.entity.*;
import aol.business.AlunoBusiness;
import aol.business.AvisoBusiness;
import aol.dao.SessionManager;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AlunoController {

    private AlunoBusiness alunoBusiness;
    private AvisoBusiness avisoBusiness;
    private BoletimBusiness boletimBusiness;
    private TurmaBusiness turmaBusiness;

    private SessionManager session;
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoController.class);

    public AlunoController() {
        this.session = SessionManager.getInstance();
        this.session.getEntityManager().clear();
        this.alunoBusiness = new AlunoBusiness(session);
        this.avisoBusiness = new AvisoBusiness(session);
        this.boletimBusiness = new BoletimBusiness(session);
        this.turmaBusiness = new TurmaBusiness(session);
    }
    
    @RequestMapping("/api/rest/alunos")
    public List<Aluno> list(@RequestParam(value="limit", defaultValue = "100") int limit,
                            @RequestParam(value="offset", defaultValue = "0") int offset) {
        return this.alunoBusiness.list(limit, offset);
    }
    
    @RequestMapping("/api/rest/alunos/{id}")
    public Aluno get(@PathVariable(value="id") String id) {
      return this.alunoBusiness.findById(id);
    }

    @RequestMapping("/api/rest/alunos/user/{userid}")
    public Aluno getByUserId(@PathVariable(value="userid") String userid) {
        return this.alunoBusiness.findByUserId(userid);
    }

    @RequestMapping("/api/rest/alunos/{id}/boletim")
    public List<Boletim> getBoletim(@PathVariable(value="id") String id,
                              @RequestParam(value="limit", defaultValue = "100") int limit,
                              @RequestParam(value="offset", defaultValue = "0") int offset) {
                                
        return this.alunoBusiness.findBoletim(id, limit, offset);
    }

    @RequestMapping("/api/rest/alunos/{id}/boletim/{boletimId}/disciplinas")
    public List<Disciplina> getBoletimDisciplinas(@PathVariable(value="id") String id,
                                                  @PathVariable(value="boletimId") String boletimId,
                                                  @RequestParam(value="limit", defaultValue = "100") int limit,
                                                  @RequestParam(value="offset", defaultValue = "0") int offset) {

        LOGGER.info("alunoId:" + id + " boletimId:" + boletimId);

        List<Boletim> boletins = this.alunoBusiness.findBoletim(id, limit, offset);
        for (Boletim b : boletins) {
            LOGGER.info("b.id:" + b.getId() + "boletimId:" + boletimId + "b:" + b.toString());
            if (b.getId().equals(boletimId)) {
                return this.boletimBusiness.findDisciplina(boletimId, limit, offset);
            }
        }
        return new ArrayList<Disciplina>();
    }

    @RequestMapping("/api/rest/alunos/{id}/turmas/{turmaId}/turmaDisciplinas")
    public List<TurmaDisciplina> getTurmasDisciplinas(@PathVariable(value="id") String id,
                                                      @PathVariable(value="turmaId") String turmaId,
                                                      @RequestParam(value="limit", defaultValue = "100") int limit,
                                                      @RequestParam(value="offset", defaultValue = "0") int offset) {
        LOGGER.info("alunoId:" + id + " turmaId:" + turmaId);
        return this.turmaBusiness.findTurmaDisciplina(turmaId, limit, offset);
    }
}
