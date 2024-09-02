
import main.academicControl.ControleAcademico;


public class BaseTest {
    public ControleAcademico ca = new ControleAcademico();

    public BaseTest() {
        ca.alunoDisciplina.addAluno("Vitor", 1, "qualquercoisa@gmail.com");
        ca.alunoDisciplina.addAluno("Calebe", 2, "qualquercoisa@gmail.com");

        ca.professorDisciplina.addProfessor("Daniel", 1, "naosei@gmail.com");
        ca.professorDisciplina.addProfessor("Sabrina", 2, "naosei@gmail.com");

        ca.professorDisciplina.addDisciplina("PARADIGMAS DE PROGRAMAÇÃO", 1, 1);
        ca.addHorario(1, "3V23/5V23", ca.professorDisciplina.getDisciplinaByCodigo(1));

        ca.professorDisciplina.addDisciplina("TÉCNICAS DE ANÁLISE DE ALGORITMO", 2, 1);
        ca.addHorario(2, "2M56/3M56", ca.professorDisciplina.getDisciplinaByCodigo(2));
    }


}
