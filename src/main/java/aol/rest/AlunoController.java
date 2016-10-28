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
    
    @RequestMapping("/alunos")
    public List<Aluno> list(@RequestParam(value="limit") int limit,
                            @RequestParam(value="offset") int offset) {
        return this.alunoBusiness.list(limit, offset);
    }
    
    @RequestMapping("alunos/{id}")
    public Aluno get(@PathVariable(value="id") String id) {
      return this.alunoBusiness.findById(id);
    }
}
