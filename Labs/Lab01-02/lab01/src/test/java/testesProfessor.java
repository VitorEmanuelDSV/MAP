import main.Disciplina;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class testesProfessor extends baseTestes{

    private final ArrayList<Disciplina> disciplinaToTest = new ArrayList<Disciplina>();
    private final ArrayList<String> horariosDisciplinasToTest = new ArrayList<>();

    @Before
    public void setUp(){
        disciplina2.setProfessorResponsavel(professor2);
        disciplinaToTest.add(disciplina2);
        horariosDisciplinasToTest.add(disciplina2.getHorario());

        disciplina3.setProfessorResponsavel(professor2);
        disciplinaToTest.add(disciplina3);
        horariosDisciplinasToTest.add(disciplina3.getHorario());
    }

    @Test
    public void disciplinasMinistradasTest() throws Exception{
        assertEquals(disciplinaToTest, professor2.getDisciplinasMinistradas());
    }

    @Test
    public void horarioDisciplinasMinistradasTest() throws Exception{
        assertEquals(horariosDisciplinasToTest, professor2.getHorarioDisciplinas());
    }

    @Test
    public void trySetProfessorAlreadySetted() throws Exception{
        assertEquals(0, disciplina2.setProfessorResponsavel(professor2));
    }

    @Test
    public void changeProfessorResponsavelTest() throws Exception{
        disciplina1.setProfessorResponsavel(professor1);
        disciplina1.setProfessorResponsavel(professor2);
        disciplina1.setProfessorResponsavel(professor3);

        assertFalse(professor1.getDisciplinasMinistradas().contains(disciplina1));
        assertFalse(professor2.getDisciplinasMinistradas().contains(disciplina1));
        assertTrue(professor3.getDisciplinasMinistradas().contains(disciplina1));

        assertEquals(professor3, disciplina1.getProfessorResponsavel());
    }


}
