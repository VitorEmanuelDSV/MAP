import main.entities.Horario;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ControleAcademicoTest extends BaseTest{
    private final ArrayList<Horario> horariosToTest = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        ca.professorDisciplina.associarProfessorADisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(1)
        );

        ca.alunoDisciplina.associarAlunoADisciplina(
                ca.alunoDisciplina.getAlunoByMatricula(1),
                ca.alunoDisciplina.getDisciplinaByCodigo(1)
        );

        horariosToTest.add(ca.getHorarioById(1));
    }


    @Test
    public void getHorarioDoProfessor() {
        assertEquals(horariosToTest, ca.horarioDoProfessor(ca.professorDisciplina.getProfessorByMatricula(1)));
    }

    @Test
    public void tryGetHorarioProfessorNotRegisteredTest(){
        assertThrows(NoSuchElementException.class,
                () -> {ca.horarioDoProfessor(ca.professorDisciplina.getProfessorByMatricula(2));
        });
    }

    @Test
    public void getHorarioDoAluno() {
        assertEquals(horariosToTest, ca.horarioDoAluno(ca.alunoDisciplina.getAlunoByMatricula(1)));
    }

    @Test
    public void tryGetAlunoHorariosSemMatricula() {
        assertThrows(IllegalStateException.class, () -> {
            this.ca.horarioDoAluno(ca.alunoDisciplina.getAlunoByMatricula(2));
        });
    }

    @Test
    public void getHorarioByIdRegisteredTest() {
        assertNotNull(ca.getHorarioById(1));
    }

    @Test
    public void tryGetHorarioByIdNotRegisteredTest() {
        assertThrows(NoSuchElementException.class, () -> {
           ca.getHorarioById(999);
        });
    }

}
