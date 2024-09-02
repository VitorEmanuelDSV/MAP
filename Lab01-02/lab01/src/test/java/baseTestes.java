import main.Aluno;
import main.Disciplina;
import main.Professor;

import java.util.ArrayList;

public class baseTestes {
    protected ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
    protected ArrayList<Professor> professores = new ArrayList<Professor>();
    protected ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    protected Professor professor1 = new Professor("Sabrina de Figueirêdo", 111);
    protected Professor professor2 = new Professor("Daniel Marques", 222);
    protected Professor professor3 = new Professor("Klaudio", 692);

    protected Disciplina disciplina1 = new Disciplina("Métodos avançados de programação", 21292, "2M12/6M12", 30);
    protected Disciplina disciplina2 = new Disciplina("Paradigmas de Programação", 21279, "3V23/5V23", 30);
    protected Disciplina disciplina3 = new Disciplina("Técnicas de Análise de Algoritmo", 21293, "2M56/3M56", 30);

    protected Aluno aluno1 = new Aluno(333, "Vitor Emanuel");
    protected Aluno aluno2 = new Aluno(444, "Luiz Manoel");
    protected Aluno aluno3 = new Aluno(555, "Gabriel Calebe");

    public baseTestes() {
        this.disciplinas.add(disciplina1);
        this.disciplinas.add(disciplina2);
        this.disciplinas.add(disciplina3);

        this.professores.add(professor1);
        this.professores.add(professor2);
        this.professores.add(professor3);

        this.alunos.add(aluno1);
        this.alunos.add(aluno2);
        this.alunos.add(aluno3);
    }



}
