package entities;

public class Disciplina {
    private String nome;
    private int codigo;
    private int numVagas;
    private String professorResponsavel = "";
    private float media = 0;

    public Disciplina(String nome, int codigo, int numVagas) {
        this.nome = nome;
        this.codigo = codigo;
        this.numVagas = numVagas;
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

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

}
