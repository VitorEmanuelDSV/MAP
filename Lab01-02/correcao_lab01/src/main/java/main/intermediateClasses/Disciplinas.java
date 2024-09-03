package intermediateClasses;

import entities.Disciplina;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Disciplinas {
    public static final ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public void addDisciplina(String nome, int codigo, int numVagas) {
        disciplinas.add(new Disciplina(nome, codigo, numVagas));
    }

    public void removeDisciplina(int codigo) {
        disciplinas.remove(this.getDisciplinaByCodigo(codigo));
    }

    public Disciplina getDisciplinaByCodigo(int codigo) {
        for(Disciplina disciplina : disciplinas) {
            if(disciplina.getCodigo() == codigo) return disciplina;
        }
        throw new NoSuchElementException("Disciplina não encontrada!");
    }
}
