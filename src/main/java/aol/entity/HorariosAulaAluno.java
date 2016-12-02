package aol.entity;

/**
 * Created by sergiot on 29/11/16.
 */
public class HorariosAulaAluno {
    private TurmaDisciplina turmaDisciplina;
    private HorarioAula horarioAula;
    private Disciplina disciplina;
    private Calendario calendario;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Calendario getCalendario() {
        return calendario;
    }

    public void setCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    public HorariosAulaAluno(TurmaDisciplina turmaDisciplina, HorarioAula horarioAula, Disciplina disciplina, Calendario calendario) {
        this.turmaDisciplina = turmaDisciplina;
        this.horarioAula = horarioAula;
        this.disciplina = disciplina;
        this.calendario = calendario;
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
