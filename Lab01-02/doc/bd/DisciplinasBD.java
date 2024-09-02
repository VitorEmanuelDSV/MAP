package main.bd;

import main.entities.Disciplina;

import java.util.ArrayList;

public class DisciplinasBD {

    public ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Disciplina disciplina1 = new Disciplina("Métodos avançados de programação", 1, 30);
    public Disciplina disciplina2 = new Disciplina("Paradigmas de Programação", 1, 30);
    public Disciplina disciplina3 = new Disciplina("Técnicas de Análise de Algoritmo", 1, 30);

    public DisciplinasBD() {

        disciplinas.add(disciplina1);
        disciplinas.add(disciplina2);
        disciplinas.add(disciplina3);

//        "Métodos avançados de programação", "2M12/6M12"
//        "Paradigmas de Programação", "3V23/5V23"
//        "Técnicas de Análise de Algoritmo", "2M56/3M56"
    }

}
