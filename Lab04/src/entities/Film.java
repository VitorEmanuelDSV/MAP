package entities;

import controllers.GloboFilmes;

import java.util.ArrayList;

public class Film {

    private String nome;
    private ArrayList<TrilhaSonora> trilhaSonora;
    private int releaseYear;

    public Film(String nome, int releaseYear) {
        this.nome = nome;
        this.releaseYear = releaseYear;
        this.trilhaSonora = new ArrayList<>();
    }

    public void addTrilhaSonora(int id) {
        this.trilhaSonora.add(GloboFilmes.searchTrilhaSonoraById(id));
    }

    public void removeTrilhaSonora(int id) {
        for(TrilhaSonora trilha : this.trilhaSonora) {
            if(trilha.getId() == id) {
                this.trilhaSonora.remove(trilha);
                break;
            }
        }
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
}
