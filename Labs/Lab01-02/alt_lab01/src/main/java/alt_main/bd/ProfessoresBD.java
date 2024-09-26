package alt_main.bd;

import alt_main.entities.AltProfessor;
import alt_main.models.Areas;

import java.util.ArrayList;

public class ProfessoresBD {

    public static ArrayList<AltProfessor> professores;

    public ProfessoresBD() {
        professores = new ArrayList<>();

        professores.add(new AltProfessor(1, "Sabrina", Areas.COMPUTACAO));
        professores.add(new AltProfessor(2, "Daniel", Areas.COMPUTACAO));
        professores.add(new AltProfessor(3, "Adailson", Areas.MATEMATICA));

    }

    public static AltProfessor getProfessorByMatricula(int matricula) {
        for (AltProfessor professor : professores) {
            if(professor.matricula == matricula) {
                return professor;
            }
        }

        return null;
    }

}
