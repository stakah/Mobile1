package aol.bean;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by sergiot on 30/11/16.
 */
@XmlRootElement
public class HorarioAula implements Serializable {
    private static final long serialVersionUID = 63364333L;

    private Integer ano;
    private Integer semestre;
    private Integer diaSemana;
    private String  nomeDisciplina;
    private String  horaIni;
    private String  icone;

    public HorarioAula(Integer ano, Integer semestre, Integer diaSemana, String nomeDisciplina, String horaIni, String icone) {
        this.ano = ano;
        this.semestre = semestre;
        this.diaSemana = diaSemana;
        this.nomeDisciplina = nomeDisciplina;
        this.horaIni = horaIni;
        this.icone = icone;
    }

    @Override
    public String toString() {
        return "HorarioAula{" +
                "ano=" + ano +
                ", semestre=" + semestre +
                ", diaSemana=" + diaSemana +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", horaIni='" + horaIni + '\'' +
                '}';
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HorarioAula that = (HorarioAula) o;

        if (ano != null ? !ano.equals(that.ano) : that.ano != null) return false;
        if (semestre != null ? !semestre.equals(that.semestre) : that.semestre != null) return false;
        if (diaSemana != null ? !diaSemana.equals(that.diaSemana) : that.diaSemana != null) return false;
        if (nomeDisciplina != null ? !nomeDisciplina.equals(that.nomeDisciplina) : that.nomeDisciplina != null)
            return false;
        return horaIni != null ? horaIni.equals(that.horaIni) : that.horaIni == null;
    }

    @Override
    public int hashCode() {
        int result = ano != null ? ano.hashCode() : 0;
        result = 31 * result + (semestre != null ? semestre.hashCode() : 0);
        result = 31 * result + (diaSemana != null ? diaSemana.hashCode() : 0);
        result = 31 * result + (nomeDisciplina != null ? nomeDisciplina.hashCode() : 0);
        result = 31 * result + (horaIni != null ? horaIni.hashCode() : 0);
        return result;
    }
}
