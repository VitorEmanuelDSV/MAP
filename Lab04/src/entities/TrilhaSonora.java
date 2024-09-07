package entities;

public class TrilhaSonora {
    private int id;
    private String nome;

    public TrilhaSonora(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public TrilhaSonora createTrilhaSonora() {
        return new TrilhaSonora(id, nome);
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}