package main.bd;

import main.entities.Professor;

import java.util.ArrayList;

public class ProfessoresBD {

    public ArrayList<Professor> professores = new ArrayList<Professor>();
    public Professor professor1 = new Professor("Sabrina", 4, "sabrina@professor.uepb.edu.br");
    public Professor professor2 = new Professor("Daniel", 5, "daniel@professor.uepb.edu.br");
    public Professor professor3 = new Professor("Klaudio", 6, "klaudio@professor.uepb.edu.br");

    public ProfessoresBD() {
        professores.add(professor1);
        professores.add(professor2);
        professores.add(professor3);
    }

}
