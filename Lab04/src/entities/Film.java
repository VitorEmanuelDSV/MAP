package entities;

import java.util.ArrayList;

public class Film {

    private int id;
    private String nome;
    private ArrayList<TrilhaSonora> trilhaSonora;
    private int releaseYear;

    public Film(int id, String nome, int releaseYear) {
        this.id = id;
        this.nome = nome;
        this.releaseYear = releaseYear;
        this.trilhaSonora = new ArrayList<>();
    }

    public void addTrilhaSonora(TrilhaSonora trilha) {
        this.trilhaSonora.add(trilha);
    }

    public void removeTrilhaSonora(int id) {
        trilhaSonora.forEach(trilha -> {
            if(trilha.getId() == id) {
                this.trilhaSonora.remove(trilha);
            }
        });
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ArrayList<TrilhaSonora> getTrilhaSonora() {
        return trilhaSonora;
    }

    public void setTrilhaSonora(ArrayList<TrilhaSonora> trilhaSonora) {
        this.trilhaSonora = trilhaSonora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
