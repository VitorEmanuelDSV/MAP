package alt_main.main;

import alt_main.bd.AlunosBD;
import alt_main.bd.DisciplinasBD;
import alt_main.bd.ProfessoresBD;
import alt_main.controllers.Coordenacao;
import alt_main.entities.AltAluno;
import alt_main.entities.AltDisciplina;
import alt_main.entities.AltProfessor;

public class AltMain {

    public static void main(String[] args) {

        // Existem mais de um registro no banco, mas para fins de eficiência será usado apenas o necessário para validação dos itens.
        // Professor : Sabrina(Matricula: 1, Nome: "Sabrina", Area: Areas.COMPUTACAO)
        // Aluno : Gabriel(Matricula: 1, Nome: "Gabriel", Area: Areas.COMPUTACAO)

        DisciplinasBD disciplinas = new DisciplinasBD();
        ProfessoresBD professores = new ProfessoresBD();
        AlunosBD alunos = new AlunosBD();

        Coordenacao coordenacao = new Coordenacao();

        AltProfessor sabrina = ProfessoresBD.getProfessorByMatricula(1);
        AltAluno gabriel = AlunosBD.getAlunoByMatricula(1);
        AltDisciplina map = DisciplinasBD.getDisciplinaById(1);

        coordenacao.vinculaProfessorADisciplina(1, 1);
        coordenacao.vinculaProfessorADisciplina(2, 1);
        coordenacao.vinculaProfessorADisciplina(3, 1);

        coordenacao.matriculaAlunoADisciplina(1, 1);
        coordenacao.matriculaAlunoADisciplina(2, 1);

        System.out.println("PROFESSOR: SABRINA");
        System.out.println("ALUNO: GABRIEL");
        System.out.println("DISCIPLINA: MAP\n");


        System.out.println("ITEM A");
        System.out.println(sabrina.getDisciplinasMinistradas());

        System.out.println("ITEM B");
        System.out.println(sabrina.getHorarios());

        System.out.println("ITEM C");
        System.out.println(map.getAlunos());

        System.out.println("ITEM D");
        System.out.println(gabriel.getDisciplinas());

        System.out.println("ITEM E");
        System.out.println(gabriel.getHorarios());

        System.out.println("ITEM F");
        System.out.println("Número de alunos em " + map.getNome() + " : " + map.getNumeroDeAlunos());


    }

}
