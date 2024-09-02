package main.intermediateClasses;

import main.entities.Disciplina;
import main.entities.Professor;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProfessorDisciplina extends Disciplinas {
    private Professor professor;
    private Disciplina disciplina;
    private final ArrayList<Professor> professores = new ArrayList<>();
    public final ArrayList<ProfessorDisciplina> matriculas = new ArrayList<>();

    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public void addProfessor(String nome, int matricula, String email) {
        this.professores.add(new Professor(nome, matricula, email));
    }

    public void removeProfessor(int matricula) {
        this.professores.remove(this.getProfessorByMatricula(matricula));
    }

    public void associarProfessorADisciplina(Professor professor, Disciplina disciplina) throws Exception {
        for (ProfessorDisciplina matricula : matriculas){
            if (matricula.getDisciplina().equals(disciplina) && matricula.getProfessor().equals(professor)){
                throw new Exception(
                        "O professor " + professor.getNome()
                        + " já está matriculado na disciplina " + disciplina.getNome()
                );
            }
        }

        matriculas.add(new ProfessorDisciplina(professor, disciplina));
    }

    // A
    public ArrayList<Disciplina> disciplinasDoProfessor(int id) {
        for(ProfessorDisciplina matricula : matriculas) {
            if(matricula.professor.equals(this.getProfessorByMatricula(id))) continue;
            else throw new NoSuchElementException("Professor não encontrado! ID: " + id);
        }

        ArrayList<Disciplina> disciplinasDoProfessor = new ArrayList<>();

        for (ProfessorDisciplina matricula : matriculas) {
            if (matricula.getProfessor().equals(this.getProfessorByMatricula(id))) {
                disciplinasDoProfessor.add(matricula.getDisciplina());
            }
        }

        return disciplinasDoProfessor;
    }

    // Utils

    public Professor getProfessorByMatricula(int matricula) {
        for(Professor professor : professores) {
            if(professor.getMatricula() == matricula) return professor;
        }
        throw new NoSuchElementException("Professor não encontrado!");
    }

    public void printDisciplinasProfessor(int matricula){
        for (Disciplina disciplina : this.disciplinasDoProfessor(matricula)) {
            System.out.println(disciplina.getNome());
        }
    }

    // Getters and Setters

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
