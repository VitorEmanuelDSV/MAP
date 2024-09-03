import entities.Disciplina;
import intermediateClasses.ProfessorDisciplina;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ProfessorDisciplinaTest extends BaseTest{
    private final ArrayList<ProfessorDisciplina> professorDisciplinaToTest = new ArrayList<>();
    private final ArrayList<Disciplina> disciplinaToTest = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        ca.professorDisciplina.associarProfessorADisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(1)
        );
        professorDisciplinaToTest.add(new ProfessorDisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(1)
        ));

        ca.professorDisciplina.associarProfessorADisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(2)
        );
        professorDisciplinaToTest.add(new ProfessorDisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(2)
        ));
    }

    @Test
    public void getDisciplinasDoProfessorTest(){
        for (ProfessorDisciplina professorDisciplina : professorDisciplinaToTest) {
            if (professorDisciplina.getProfessor().equals(ca.professorDisciplina.getProfessorByMatricula(1))) {
                disciplinaToTest.add(professorDisciplina.getDisciplina());
            }
        }

        assertEquals(disciplinaToTest, ca.professorDisciplina.disciplinasDoProfessor(1));
    }

    @Test
    public void trySetProfessorAlredySettedTest() throws Exception {
        assertThrows(Exception.class, () -> {ca.professorDisciplina.associarProfessorADisciplina(
                ca.professorDisciplina.getProfessorByMatricula(1),
                ca.professorDisciplina.getDisciplinaByCodigo(1)
        );});
    }

    @Test
    public void tryGetDisciplinasProfessorNotRegisteredTest() throws Exception {
        assertThrows(NoSuchElementException.class, () -> {ca.professorDisciplina.disciplinasDoProfessor(2);});
    }

    @Test
    public void getProfessorExistenteTest(){
        assertNotNull(ca.professorDisciplina.getProfessorByMatricula(1));
    }

    @Test
    public void tryGetProfessorNaoExistenteTest(){
        assertThrows(NoSuchElementException.class, () -> {
            ca.professorDisciplina.getProfessorByMatricula(999);
        });
    }

}
