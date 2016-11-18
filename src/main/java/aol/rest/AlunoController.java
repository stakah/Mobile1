package aol.rest;

import aol.entity.Aluno;
import aol.business.AlunoBusiness;
import aol.business.AvisoBusiness;
import aol.dao.SessionManager;

import java.util.concurrent.atomic.AtomicLong;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class AlunoController {

    private AlunoBusiness alunoBusiness;
    private AvisoBusiness avisoBusiness;
    private SessionManager session;
    
    public AlunoController() {
      this.session = SessionManager.getInstance();
      this.session.getEntityManager().clear();
      this.alunoBusiness = new AlunoBusiness(session);
      this.avisoBusiness = new AvisoBusiness(session);    
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
    public Boletim getBoletim(@PathVariable(value="id") String id) {
        return this.alunoBusiness.findById(id);
    }

}
