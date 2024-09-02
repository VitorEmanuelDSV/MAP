import main.Aluno;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class testesDisciplina extends baseTestes{

    private final ArrayList<Aluno> alunosToTest = new ArrayList<Aluno>();

    @Before
    public void setUp(){
        disciplina1.matriculaAluno(aluno1);
        alunosToTest.add(aluno1);

        disciplina1.matriculaAluno(aluno2);
        alunosToTest.add(aluno2);

        disciplina1.matriculaAluno(aluno3);
        alunosToTest.add(aluno3);
    }

    @Test
    public void alunosMatriculadosTest() throws Exception{
        assertEquals(alunosToTest, disciplina1.getAlunosMatriculados());
    }

    @Test
    public void numAlunosMatriculadosTest() throws Exception{
        assertEquals(alunosToTest.size(), disciplina1.numAlunosMatriculados());
    }

}
