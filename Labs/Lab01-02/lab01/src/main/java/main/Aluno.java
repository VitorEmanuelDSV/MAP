package main;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int matricula;
    private final ArrayList<Disciplina> disciplinasMatriculadas;
    
    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;

        this.disciplinasMatriculadas = new ArrayList<>();
    }

    public String disciplinasMatriculadas(){
        StringBuilder disciplinas = new StringBuilder();

        for (Disciplina disciplinaMatriculada : disciplinasMatriculadas) {
            disciplinas.append(disciplinaMatriculada.getNome()).append("\n");
        }

        return disciplinas.toString();
    }

    public String horarioDisciplinasMatriculadas(){
        StringBuilder horarios = new StringBuilder();

        for (Disciplina disciplinaMatriculada : disciplinasMatriculadas) {
            horarios.append(disciplinaMatriculada.getNome()).append(":   ").append(disciplinaMatriculada.getHorario()).append("\n");
        }

        return horarios.toString();
    }

    public void adicionaDisciplinaMatriculada(Disciplina disciplina) {
        disciplinasMatriculadas.add(disciplina);
    }

    public void removeDisciplinaMatriculada(Disciplina disciplina) {
        disciplinasMatriculadas.remove(disciplina);
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public ArrayList<String> getHorarioDisciplinas() {
        ArrayList<String> horarios = new ArrayList<>();

        for (Disciplina disciplinaMatriculada : disciplinasMatriculadas) {
            horarios.add(disciplinaMatriculada.getHorario());
        }

        return horarios;
    }

}
