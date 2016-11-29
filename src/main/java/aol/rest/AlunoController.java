package aol.rest;

import aol.business.BoletimBusiness;
import aol.business.TurmaBusiness;
import aol.entity.*;
import aol.business.AlunoBusiness;
import aol.business.AvisoBusiness;
import aol.business.CalendarioBusiness;
import aol.dao.SessionManager;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;

@RestController
@RequestMapping(value = "${rest.baseUrl}/alunos")
public class AlunoController {

    /**
     * Classe de negócio para manipulação de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("AlunoBusiness")
    private AlunoBusiness alunoBusiness;
    @Autowired
    @Qualifier("AvisoBusiness")
    private AvisoBusiness avisoBusiness;
    @Autowired
    @Qualifier("BoletimBusiness")
    private BoletimBusiness boletimBusiness;
    @Autowired
    @Qualifier("TurmaBusiness")
    private TurmaBusiness turmaBusiness;
    @Autowired
    @Qualifier("CalendarioBusiness")
    private CalendarioBusiness calendarioBusiness;

    private SessionManager session;
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoController.class);

    public AlunoController() {
        this.session = SessionManager.getInstance();
        this.session.getEntityManager().clear();

    }

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<PagedResources<Aluno>>  list(Pageable pageable, PagedResourcesAssembler assembler) {
      return new ResponseEntity<>(assembler.toResource(alunoBusiness.list(pageable   )), HttpStatus.OK);    
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public HttpEntity<Aluno> get(@PathVariable(value="id") String id) {
      
      try {
        Aluno response = this.alunoBusiness.get(id);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
        
      }
      catch (Exception e) {
        LOGGER.debug(String.format("[GET]\tid=%s %s", id, e.getMessage()));
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }

    @RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
    public Aluno getByUserId(@PathVariable(value="userid") String userid) {
        return this.alunoBusiness.findByUserId(userid);
    }

    @RequestMapping(value = "/{id}/boletim", method = RequestMethod.GET)
    public HttpEntity<PagedResources<Boletim>> getBoletim(@PathVariable(value="id") String id,
                              Pageable pageable, PagedResourcesAssembler assembler) {
                                
      return new ResponseEntity<>(assembler.toResource(alunoBusiness.findBoletim(id, pageable)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET
            , value="/{alunoId}/BoletimDisciplinas")
    public HttpEntity<PagedResources<BoletimDisciplinas>> findBoletimDisciplinasByAlunoId(@PathVariable("alunoId") java.lang.String alunoId, Pageable pageable, PagedResourcesAssembler assembler) {
        return new ResponseEntity<>(assembler.toResource(boletimBusiness.findBoletimDisciplinasByAlunoId(alunoId,  pageable )), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/boletim/id", method = RequestMethod.GET)
    public HttpEntity<PagedResources<java.lang.Integer>> getBoletimId(@PathVariable(value="id") String id,
                                                          Pageable pageable, PagedResourcesAssembler assembler) {

        return new ResponseEntity<>(assembler.toResource(alunoBusiness.getBoletimId(id, pageable)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/boletim/{boletimId}/disciplinas", method = RequestMethod.GET)
    public HttpEntity<PagedResources<Disciplina>> getBoletimDisciplinas(@PathVariable(value="id") String id,
                                                  @PathVariable(value="boletimId") String boletimId,
                                                  Pageable pageable, PagedResourcesAssembler assembler) {

        Page<Boletim> boletins = this.alunoBusiness.findBoletim(id, pageable);
        for (Boletim b : boletins) {
            LOGGER.info("b.id:" + b.getId() + "boletimId:" + boletimId + "b:" + b.toString());
            if (b.getId().equals(boletimId)) {
                return new ResponseEntity<>(assembler.toResource(boletimBusiness.findDisciplina(boletimId, pageable)), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/turmas/{turmaId}/turmaDisciplinas", method = RequestMethod.GET)
    public HttpEntity<PagedResources<TurmaDisciplina>> getTurmasDisciplinas(@PathVariable(value="id") String id,
                                                      @PathVariable(value="turmaId") String turmaId,
                                                      Pageable pageable, PagedResourcesAssembler assembler) {

        LOGGER.info("alunoId:" + id + " turmaId:" + turmaId);
        return new ResponseEntity<>(assembler.toResource(turmaBusiness.findTurmaDisciplina(turmaId, pageable)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET
            , value="/{alunoId}/HorariosAula")
    public HttpEntity<PagedResources<HorariosAulaAluno>> findBoletimHorariosAulaByAlunoId(@PathVariable("alunoId") java.lang.String alunoId, Pageable pageable, PagedResourcesAssembler assembler) {
        return new ResponseEntity<>(assembler.toResource(alunoBusiness.listHorariosAulaAluno(alunoId,  pageable )), HttpStatus.OK);
    }
}

