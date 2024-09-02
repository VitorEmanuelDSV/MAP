package alt_main.entities;

import alt_main.bd.DisciplinasBD;
import alt_main.models.Areas;

public class AltAluno {

    public int matricula;
    public String nome;
    public Areas area;
    public int periodo = 1;

    public AltAluno(int matricula, String nome, Areas area) {
        this.matricula = matricula;
        this.nome = nome;
        this.area = area;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getDisciplinas() {
        return DisciplinasBD.getAlunoDisicplinas(this.matricula);
    }

    public String getHorarios() {
        return DisciplinasBD.getAlunoHorarios(this.matricula);
    }

    public String getNome() {
        return this.nome;
    }


}
