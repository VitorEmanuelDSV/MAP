package main;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int codigo;
    private String horario;
    private int numeroDeVagas;
    private Professor professorResponsavel;
    private final ArrayList<Aluno> alunosMatriculados;

    public Disciplina(String nome, int codigo, String horario, int numeroDeVagas) {
        this.nome = nome;
        this.codigo = codigo;
        this.horario = horario;
        this.numeroDeVagas = numeroDeVagas;

        this.alunosMatriculados = new ArrayList<>();
    }

    public int matriculaAluno(Aluno aluno) {

        if (alunosMatriculados.contains(aluno)) return 0;
        else if(alunosMatriculados.size() >= this.numeroDeVagas) return 2;

        alunosMatriculados.add(aluno);
        aluno.adicionaDisciplinaMatriculada(this);

        return 1;
    }

    public int desmatriculaAluno(Aluno aluno) {

        if (!alunosMatriculados.contains(aluno)) return 0;

        alunosMatriculados.remove(aluno);
        aluno.removeDisciplinaMatriculada(this);

        return 1;
    }

    public String alunosMatriculados(){
        StringBuilder alunos = new StringBuilder();

        for (Aluno alunoMatriculado : alunosMatriculados) {
            alunos.append(alunoMatriculado.getNome()).append("\n");
        }

        return alunos.toString();
    }

    public int numAlunosMatriculados() {
        return alunosMatriculados.size();
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumeroDeVagas() { return numeroDeVagas; }

    public void setNumeroDeVagas(int numeroDeVagas) { this.numeroDeVagas = numeroDeVagas; }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public int setProfessorResponsavel(Professor professorResponsavel) {
        if(this.professorResponsavel == professorResponsavel) return 0;

        if(this.professorResponsavel != null)  this.professorResponsavel.removerDisciplina(this);

        this.professorResponsavel = professorResponsavel;
        professorResponsavel.adicionarDisciplina(this);

        return 1;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

}
