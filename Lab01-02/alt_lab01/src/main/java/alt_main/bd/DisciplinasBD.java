package alt_main.bd;

import alt_main.entities.AltDisciplina;
import alt_main.models.Areas;

import java.util.ArrayList;

public class DisciplinasBD {

    public static ArrayList<AltDisciplina> disciplinas;

    public DisciplinasBD() {
        disciplinas = new ArrayList<>();

        disciplinas.add(new AltDisciplina(1, "Métodos avançados de programação", "2M12/6M12", Areas.COMPUTACAO, 5));
        disciplinas.add(new AltDisciplina(2, "Paradigmas de Programação", "3V23/5V23", Areas.COMPUTACAO, 5));
        disciplinas.add(new AltDisciplina(3, "Técnicas de Análise de Algoritmo", "2M56/3M56", Areas.COMPUTACAO, 5));

    }

    public static String getProfessorDisciplinas(int professorMatricula) {
        StringBuilder disciplinasMinistradas = new StringBuilder();

        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.professorId == professorMatricula) {
                disciplinasMinistradas.append(disciplina.getNome()).append("\n");
            }
        }

        return disciplinasMinistradas.toString();

    }

    public static String getProfessorHorarios(int professorMatricula) {
        StringBuilder disciplinaHorarios = new StringBuilder();

        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.professorId == professorMatricula) {
                disciplinaHorarios.append(disciplina.getNome()).append(" - ").append(disciplina.getHorario()).append("\n");
            }
        }

        return disciplinaHorarios.toString();
    }

    public static String getAlunoDisicplinas(int alunoMatricula) {
        StringBuilder disciplinasMatriculas = new StringBuilder();

        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.alunosIds.contains(alunoMatricula)) {
                disciplinasMatriculas.append(disciplina.getNome()).append("\n");
            }
        }

        return disciplinasMatriculas.toString();
    }

    public static String getAlunoHorarios(int alunoMatricula) {
        StringBuilder disciplinaHorarios = new StringBuilder();

        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.alunosIds.contains(alunoMatricula)) {
                disciplinaHorarios.append(disciplina.getNome()).append(" - ").append(disciplina.getHorario()).append("\n");
            }
        }

        return disciplinaHorarios.toString();
    }

    public static AltDisciplina getDisciplinaById(int disciplinaId) {
        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.id == disciplinaId) {
                return disciplina;
            }
        }

        return null;
    }

    public static void setProfessorResponsavel(int disciplinaId, int professorMatricula) {
        AltDisciplina disciplinaToUpdate = getDisciplinaById(disciplinaId);
        disciplinaToUpdate.setProfessorResponsavel(professorMatricula);
    }

    public static void matriculaAlunoADisciplina(int disciplinaId, int alunoMatricula) {
        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.id == disciplinaId) {
                disciplina.alunosIds.add(alunoMatricula);
            }
        }
    }

    public static void desvinculaAlunoDaDisciplina(int disciplinaId, int alunoMatricula) {
        for(AltDisciplina disciplina : disciplinas) {
            if(disciplina.id == disciplinaId) {
                disciplina.alunosIds.remove(alunoMatricula);
            }
        }
    }

}
