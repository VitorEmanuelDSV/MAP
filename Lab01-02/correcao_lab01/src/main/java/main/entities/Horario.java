package main.entities;

public class Horario {
    private int id;
    private String horario;
    private Disciplina disciplina;

    public Horario(int id, String horario, Disciplina disciplina) {
        this.id = id;
        this.horario = horario;
        this.disciplina = disciplina;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
