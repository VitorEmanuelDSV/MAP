package test.java.entities;

import controllers.GloboFilmes;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilmTest {

    GloboFilmes globoFilmes = new GloboFilmes();


    @Test
    public void addTrilhaSonoraTest() {
        globoFilmes.createProjeto(10, "Alguém me ajuda", 2024);
        globoFilmes.createTrilhaSonora(10, "AAAAAAAAAA");

        assertNotNull(globoFilmes.searchProjetoById(10).getFilm().addTrilhaSonora(10));
    }

    @Test
    public void tryAddTrilhaSonoraAlreadyExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.searchProjetoById(10).getFilm().addTrilhaSonora(10);});
    }

    @Test
    public void removeTrilhaSonoraTest() {
        globoFilmes.createProjeto(11, "Minha coluna doi", 2024);
        globoFilmes.createTrilhaSonora(11, "Tô crocrante");
        globoFilmes.searchProjetoById(11).getFilm().addTrilhaSonora(11);

        assertNotNull(globoFilmes.searchProjetoById(11).getFilm().removeTrilhaSonora(11));
    }

    @Test
    public void tryRemoveTrilhaSonoraNonExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.searchProjetoById(11).getFilm().addTrilhaSonora(999);});
    }
}
