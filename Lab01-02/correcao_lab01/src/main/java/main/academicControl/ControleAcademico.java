package main.academicControl;

import main.entities.Aluno;
import main.entities.Disciplina;
import main.entities.Professor;
import main.entities.Horario;
import main.intermediateClasses.AlunoDisciplina;
import main.intermediateClasses.ProfessorDisciplina;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ControleAcademico {
    public AlunoDisciplina alunoDisciplina;
    public ProfessorDisciplina professorDisciplina;
    public final ArrayList<Horario> horarios;

    public ControleAcademico() {
        alunoDisciplina = new AlunoDisciplina(null, null);
        professorDisciplina = new ProfessorDisciplina(null, null);
        this.horarios = new ArrayList<>();
    }

    public void addHorario(int id, String horario, Disciplina disciplina) {
        horarios.add(new Horario(id, horario, disciplina));
    }

    public void removeHorario(int id) {
        this.horarios.remove(this.getHorarioById(id));
    }

    // B
    public ArrayList<Horario> horarioDoProfessor(Professor professor) {

        for(ProfessorDisciplina matricula : this.professorDisciplina.matriculas) {
            if(matricula.getProfessor() == professor)  continue;
            else
                throw new NoSuchElementException("O professor " + professor.getNome() + " não está matriculado.");
        }

        ArrayList<Horario> horariosDoProfessor = new ArrayList<>();

        for (Horario horario : horarios) {
            Disciplina disciplina = horario.getDisciplina();
            for (ProfessorDisciplina professorDisciplina : professorDisciplina.matriculas) {
                if (professorDisciplina.getProfessor().equals(professor) &&
                        professorDisciplina.getDisciplina().equals(disciplina)) {
                    horariosDoProfessor.add(horario);
                    break;
                }
            }
        }

        return horariosDoProfessor;
    }

    // E
    public ArrayList<Horario> horarioDoAluno(Aluno aluno) {

        boolean alunoExiste = false;
        for (AlunoDisciplina matricula : this.alunoDisciplina.matriculas) {
            if (matricula.getAluno().equals(aluno)) {
                alunoExiste = true;
                break;
            }
        }

        if(!alunoExiste)
            throw new IllegalStateException("O aluno " + aluno.getNome() + " não está matriculado.");


        ArrayList<Horario> horarioDoAluno = new ArrayList<>();

        for (Horario horario : horarios) {
            Disciplina disciplina = horario.getDisciplina();
            for (AlunoDisciplina alunoDisciplina : alunoDisciplina.matriculas) {
                if (alunoDisciplina.getAluno().equals(aluno) &&
                        alunoDisciplina.getDisciplina().equals(disciplina)) {
                    horarioDoAluno.add(horario);
                    break;
                }
            }
        }

        return horarioDoAluno;
    }

    // Utils

    public Horario getHorarioById(int id) {
        for(Horario horario : horarios) {
            if(horario.getId() == id) return horario;
        }
        throw new NoSuchElementException("Horario não encontrado!");
    }

    public void printHorariosProfessor(int matricula) {
        for (Horario horario : this.horarioDoProfessor(this.professorDisciplina.getProfessorByMatricula(matricula))) {
            System.out.println(horario.getHorario());
        }
    }

    public void printHorariosAluno(int matricula) throws Exception {
        for (Horario horario : this.horarioDoAluno(this.alunoDisciplina.getAlunoByMatricula(matricula))) {
            System.out.println(horario.getHorario());
        }
    }
}
