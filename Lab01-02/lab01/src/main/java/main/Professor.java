package main;

import java.util.ArrayList;

public class Professor {
    private String nome; 
    private int matricula;
    private final ArrayList<Disciplina> disciplinasMinistradas;

    public Professor(String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;

        this.disciplinasMinistradas = new ArrayList<>();
    }

    public String disciplinasMinistradas(){
        StringBuilder disciplinas = new StringBuilder();

        for (Disciplina disciplinaMinistrada : disciplinasMinistradas) {
            disciplinas.append(disciplinaMinistrada.getNome()).append("\n");
        }

        return disciplinas.toString();
    }

    public String horarioDisciplinasMinistradas(){
        StringBuilder horarios = new StringBuilder();

        for (Disciplina disciplinaMinistrada : disciplinasMinistradas) {
            horarios.append(disciplinaMinistrada.getNome()).append(":   ").append(disciplinaMinistrada.getHorario()).append("\n");
        }

        return horarios.toString();
    }

    public void adicionarDisciplina(Disciplina disciplina){
        disciplinasMinistradas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina){
        disciplinasMinistradas.remove(disciplina);
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

    public int getSizeDisciplinasMinistradas() {
        return disciplinasMinistradas.size();
    }

    public ArrayList<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public ArrayList<String> getHorarioDisciplinas() {
        ArrayList<String> horarios = new ArrayList<>();

        for (Disciplina disciplinaMinistrada : disciplinasMinistradas) {
            horarios.add(disciplinaMinistrada.getHorario());
        }

        return horarios;
    }

}
