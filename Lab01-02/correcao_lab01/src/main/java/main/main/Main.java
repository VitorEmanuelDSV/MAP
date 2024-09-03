package main;

import academicControl.ControleAcademico;

public class Main {

    public static void main(String[] args) throws Exception {
        ControleAcademico ca = new ControleAcademico();

        ca.alunoDisciplina.addAluno("Vitor", 1, "qualquercoisa@gmail.com");
        ca.professorDisciplina.addProfessor("Daniel", 1, "naosei@gmail.com");
        ca.professorDisciplina.addDisciplina("Paradigmas", 1, 3);
        ca.addHorario(1, "2M12/3M56", ca.professorDisciplina.getDisciplinaByCodigo(1));

        ca.professorDisciplina.associarProfessorADisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(1)
        );
        ca.alunoDisciplina.associarAlunoADisciplina(
                ca.alunoDisciplina.getAlunoByMatricula(1),
                ca.alunoDisciplina.getDisciplinaByCodigo(1)
        );

        // a. Quais disciplinas um professor está ministrando;
        System.out.println("Disciplinas que o professor " + ca.professorDisciplina.getProfessorByMatricula(1).getNome() + " está ministrando:");
        ca.professorDisciplina.printDisciplinasProfessor(1);

        // b. Qual o horário de um professor;
        System.out.println("Horarios do professor " + ca.professorDisciplina.getProfessorByMatricula(1).getNome() + ":");
        ca.printHorariosProfessor(1);

        // c. Quais os alunos de uma dada disciplina;
        System.out.println("Alunos matriculados na disciplina " + ca.professorDisciplina.getDisciplinaByCodigo(1).getNome() + ":");
        ca.alunoDisciplina.printAlunosDisciplina(1);

        // d. Quais as disciplinas de um aluno;
        System.out.println("Disciplinas que o aluno " + ca.alunoDisciplina.getAlunoByMatricula(1).getNome() + " está matriculado:");
        ca.alunoDisciplina.printDisciplinasAluno(1);

        // e. Qual o horário de um aluno;
        System.out.println("Horario do aluno " + ca.alunoDisciplina.getAlunoByMatricula(1).getNome() + " :");
        ca.printHorariosAluno(1);

        // f. Qual o número de alunos de uma disciplina.
        System.out.println("O número de alunos na disciplina "
                + ca.alunoDisciplina.getDisciplinaByCodigo(1).getNome() + " é "
                + ca.alunoDisciplina.numeroDeAlunosNaDisciplina(1)
        );

    }
    
}
