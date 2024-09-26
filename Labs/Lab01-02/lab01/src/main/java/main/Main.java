package main;

public class Main {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Sabrina de Figueirêdo", 111);
        Professor professor2 = new Professor("Daniel Marques", 222);

        Disciplina disciplina1 = new Disciplina("Métodos avançados de programação", 21292, "2M12/6M12", 30);
        Disciplina disciplina2 = new Disciplina("Paradigmas de Programação", 21279, "3V23/5V23", 30);
        Disciplina disciplina3 = new Disciplina("Técnicas de Análise de Algoritmo", 21293, "2M56/3M56", 30);

        Aluno aluno1 = new Aluno(333, "Vitor Emanuel");
        Aluno aluno2 = new Aluno(444, "Luiz Manoel");
        Aluno aluno3 = new Aluno(555, "Gabriel Calebe");


        // a. Quais disciplinas um professor está ministrando;
        System.out.println("[Item A: ]");
        disciplina1.setProfessorResponsavel(professor1);
        disciplina2.setProfessorResponsavel(professor1);

        System.out.print("Disciplinas que " + professor1.getNome() + " ministra: \n");
        System.out.println(professor1.disciplinasMinistradas());

        // b. Qual o horário de um professor;
        System.out.println("[Item B: ]");
        System.out.print("Horarios das disciplinas que " + professor1.getNome() + " ministra: \n");
        System.out.println(professor1.horarioDisciplinasMinistradas());

        // c. Quais os alunos de uma dada disciplina;
        System.out.println("[Item C: ]");
        disciplina1.matriculaAluno(aluno1);
        disciplina1.matriculaAluno(aluno2);
        disciplina1.matriculaAluno(aluno3);

        System.out.print("Alunos matriculados na disciplina " + disciplina1.getNome() + ":\n");
        System.out.println(disciplina1.alunosMatriculados());

        // d. Quais as disciplinas de um aluno;
        System.out.println("[Item D: ]");
        disciplina2.matriculaAluno(aluno1);

        System.out.print("Disciplinas que " + aluno1.getNome() + " está matriculado: \n");
        System.out.println(aluno1.disciplinasMatriculadas());

        // e. Qual o horário de um aluno;
        System.out.println("[Item E: ]");
        System.out.print("Horários das disciplinas que " + aluno1.getNome() + " está matriculado: \n");
        System.out.println(aluno1.horarioDisciplinasMatriculadas());

        // f. Qual o número de alunos de uma disciplina.
        System.out.println("[Item F: ]");

        System.out.println(disciplina1.getNome() + " tem " + disciplina1.numAlunosMatriculados() + " alunos matriculados.");
    }
}
