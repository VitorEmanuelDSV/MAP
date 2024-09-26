package main.bd;

import java.util.ArrayList;

import main.entities.Aluno;

public class AlunosBD {

    public static ArrayList<Aluno> alunos = new ArrayList<>();

    public Aluno aluno1 = new Aluno("Gabriel Calebe", 1, "gabriel.calebe@aluno.uepb.edu.br");
    public Aluno aluno2 = new Aluno("Vitor Emanuel", 2, "vitor.emanuel@aluno.uepb.edu.br");
    public Aluno aluno3 = new Aluno("Luiz Manoel", 3, "luiz.manoel@aluno.uepb.edu.br");

    public AlunosBD() {
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
    }

}
