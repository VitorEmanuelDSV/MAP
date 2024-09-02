package alt_main.controllers;

import alt_main.bd.DisciplinasBD;

public class Coordenacao {

    public void vinculaProfessorADisciplina(int disciplinaId, int professorMatricula) {
        DisciplinasBD.setProfessorResponsavel(disciplinaId, professorMatricula);
    }

    public void matriculaAlunoADisciplina(int disciplinaId, int matricula) {
        DisciplinasBD.matriculaAlunoADisciplina(disciplinaId, matricula);
    }

    public void desvinculaAlunoADisciplina(int disciplinaId, int matricula) {
        DisciplinasBD.desvinculaAlunoDaDisciplina(disciplinaId, matricula);
    }

}
