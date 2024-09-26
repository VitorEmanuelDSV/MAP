package entities;

import controllers.GloboFilmes;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Film {

    private String nome;
    private ArrayList<TrilhaSonora> trilhaSonora;
    private int releaseYear;

    public Film(String nome, int releaseYear) {
        this.nome = nome;
        this.releaseYear = releaseYear;
        this.trilhaSonora = new ArrayList<>();
    }

    public TrilhaSonora addTrilhaSonora(int id) {
        for(TrilhaSonora trilhaSonora : trilhaSonora){
            if(trilhaSonora.getId() == id){
                throw new IllegalArgumentException("A trilha de id: " + id + " já foi adicionada!");
            }
        }

        this.trilhaSonora.add(GloboFilmes.searchTrilhaSonoraById(id));
        return GloboFilmes.searchTrilhaSonoraById(id);
    }

    public TrilhaSonora removeTrilhaSonora(int id) {
        for(TrilhaSonora trilha : this.trilhaSonora) {
            if(trilha.getId() == id) {
                this.trilhaSonora.remove(trilha);
                return trilha;
            }
        }
        
        throw new NoSuchElementException("A trilha sonora de id: " + id + " não foi encontrada!");
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
