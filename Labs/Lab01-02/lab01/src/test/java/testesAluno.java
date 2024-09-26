import static org.junit.Assert.*;

import main.Disciplina;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class testesAluno extends baseTestes{

    private final ArrayList<Disciplina> disciplinasToTest = new ArrayList<Disciplina>();;
    private final ArrayList<String> horariosDisciplinasToTest = new ArrayList<String>();;

    @Before
    public void setUp(){
        disciplina1.matriculaAluno(aluno1);
        disciplinasToTest.add(disciplina1);
        horariosDisciplinasToTest.add(disciplina1.getHorario());

        disciplina2.matriculaAluno(aluno1);
        disciplinasToTest.add(disciplina2);
        horariosDisciplinasToTest.add(disciplina2.getHorario());
    }

    @Test
    public void disciplinasMatriculadasTest() throws Exception{
        assertEquals(disciplinasToTest, aluno1.getDisciplinasMatriculadas());
    }

    @Test
    public void horarioDisciplinasMatriculadasTest() throws Exception{
        assertEquals(horariosDisciplinasToTest, aluno1.getHorarioDisciplinas());
    }

    @Test
    public void tryMatriculaAlunoMatriculadoTest() throws Exception{
        assertEquals(0, disciplina1.matriculaAluno(aluno1));
    }

    @Test
    public void tryDesmatricularAlunoNaoMatriculadoTest() throws Exception{
        assertEquals(0, disciplina2.desmatriculaAluno(aluno3));
    }

    @Test
    public void tryMatriculaAlunoSemVagasTest() throws Exception{
        disciplina1.setNumeroDeVagas(1);

        assertEquals(2, disciplina1.matriculaAluno(aluno2));
    }


}
