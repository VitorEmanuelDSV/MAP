import main.entities.Aluno;
import main.entities.Disciplina;
import main.entities.Horario;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class AlunoDisciplinaTest extends BaseTest {
    private final ArrayList<Aluno> alunosDaDisciplinaToTest = new ArrayList<>();
    private final ArrayList<Disciplina> disciplinasDoAlunoToTest = new ArrayList<Disciplina>();
    private final ArrayList<Horario> horariosDoAlunoToTest = new ArrayList<Horario>();

    @Before
    public void setUp() throws Exception {
        disciplinasDoAlunoToTest.add(ca.professorDisciplina.getDisciplinaByCodigo(1));
        horariosDoAlunoToTest.add(ca.getHorarioById(1));
        alunosDaDisciplinaToTest.add(ca.alunoDisciplina.getAlunoByMatricula(1));

        ca.alunoDisciplina.associarAlunoADisciplina(
                ca.alunoDisciplina.getAlunoByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(1)
        );
    }

    @Test
    public void tryMatriculaAlunoSemVagasTest(){
        assertThrows(IllegalStateException.class, () -> {
            ca.alunoDisciplina.associarAlunoADisciplina(
                    ca.alunoDisciplina.getAlunoByMatricula(2),
                    ca.professorDisciplina.getDisciplinaByCodigo(1)
            );
        });
    }

    @Test
    public void horarioDisciplinasMatriculadasTest(){
        assertEquals(horariosDoAlunoToTest, this.ca.horarioDoAluno(ca.alunoDisciplina.getAlunoByMatricula(1)));
    }

    @Test
    public void tryMatriculaAlunoMatriculadoTest(){
        assertThrows(IllegalStateException.class, () -> {
            ca.alunoDisciplina.associarAlunoADisciplina(ca.alunoDisciplina.getAlunoByMatricula(1), ca.professorDisciplina.getDisciplinaByCodigo(1));
        });
    }

    @Test
    public void tryDesmatricularAlunoNaoMatriculadoTest(){
        assertThrows(IllegalStateException.class, () -> {
            ca.alunoDisciplina.removerAlunoADisciplina(ca.alunoDisciplina.getAlunoByMatricula(1), ca.professorDisciplina.getDisciplinaByCodigo(2));
        });
    }

    @Test
    public void alunosDaDisciplinaTest(){
        assertEquals(alunosDaDisciplinaToTest, ca.alunoDisciplina.alunosDaDisciplina(1));
    }

    @Test
    public void disciplinasMatriculadasTest(){
        assertEquals(disciplinasDoAlunoToTest, ca.alunoDisciplina.disciplinasDoAluno(1));
    }

    @Test
    public void numAlunosDisciplinaTest(){
        assertEquals(ca.alunoDisciplina.alunosDaDisciplina(1).size() ,
            ca.alunoDisciplina.numeroDeAlunosNaDisciplina(1));};

    @Test
    public void verificaVagasDisciplinaTest(){
        assertEquals(ca.alunoDisciplina.getDisciplinaByCodigo(1).getNumVagas(),
                ca.alunoDisciplina.verificaVagasNaDisciplina(ca.alunoDisciplina.getDisciplinaByCodigo(1)
                ));
    }

    @Test
    public void getAlunoExistenteTest(){
        assertNotNull(ca.alunoDisciplina.getAlunoByMatricula(1));
    }

    @Test
    public void tryGetAlunoNaoExistenteTest(){
        assertThrows(NoSuchElementException.class, () -> {
            ca.alunoDisciplina.getAlunoByMatricula(999);
        });
    }

}
