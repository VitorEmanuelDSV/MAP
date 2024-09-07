package entities;

public class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}