package alt_main.entities;

import alt_main.bd.DisciplinasBD;
import alt_main.models.Areas;

public class AltProfessor {

    public int matricula;
    public String nomeCompleto;
    public Areas areaDeEnsino;

    public AltProfessor(int matricula, String nomeCompleto, Areas areaDeEnsino) {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.areaDeEnsino = areaDeEnsino;
    }

    public String getDisciplinasMinistradas() {
        return DisciplinasBD.getProfessorDisciplinas(this.matricula);
    }

    public String getHorarios() {
        return DisciplinasBD.getProfessorHorarios(this.matricula);
    }

}
