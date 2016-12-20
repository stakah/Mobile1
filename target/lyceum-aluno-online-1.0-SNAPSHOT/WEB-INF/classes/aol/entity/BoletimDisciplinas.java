package aol.entity;

/**
 * Created by sergiot on 29/11/16.
 */
public class BoletimDisciplinas {
    private Boletim boletim;
    private Disciplina disciplina;
    private TurmaDisciplina turmaDisciplina;

    public BoletimDisciplinas(Boletim boletim, Disciplina disciplina, TurmaDisciplina turmaDisciplina) {
        this.boletim = boletim;
        this.disciplina = disciplina;
        this.turmaDisciplina = turmaDisciplina;
    }

    public Boletim getBoletim() {
        return boletim;
    }

    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public TurmaDisciplina getTurmaDisciplina() {
        return turmaDisciplina;
    }

    public void setTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
        this.turmaDisciplina = turmaDisciplina;
    }
}
