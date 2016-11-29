package aol.entity;

/**
 * Created by sergiot on 29/11/16.
 */
public class HorariosAulaAluno {
    private Aluno aluno;
    private TurmaDisciplina turmaDisciplina;
    private HorarioAula horarioAula;

    public HorariosAulaAluno(Aluno aluno, TurmaDisciplina turmaDisciplina, HorarioAula horarioAula) {
        this.aluno = aluno;
        this.turmaDisciplina = turmaDisciplina;
        this.horarioAula = horarioAula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public TurmaDisciplina getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }

    public HorarioAula getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(HorarioAula horarioAula) {
        this.horarioAula = horarioAula;
    }
}
