package test.java.controllers;

import controllers.GloboFilmes;
import entities.Pessoa;
import entities.TrilhaSonora;
import org.junit.Test;
import relationships.Projeto;

import static org.junit.Assert.*;

public class GloboFilmesTest {

    GloboFilmes globoFilmes = new GloboFilmes();

    @Test
    public void createProjetoTest() {
        assertNotNull(globoFilmes.createProjeto(1, "Como sobreviver a 7 cadeiras", 2024));
    }

    @Test
    public void tryCreateProjetoAlreadyExistingTest() {
        globoFilmes.createProjeto(2, "Não quero reprovar", 2024);
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.createProjeto(2, "Não quero reprovar", 2024);});
    }

    @Test
    public void creatPessoaTest() {
        assertNotNull(globoFilmes.createPessoa(1, "Vitor"));
    }

    @Test
    public void tryCreatePessoaAlreadyExistingTest() {
        globoFilmes.createPessoa(2, "Vitor");
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.createPessoa(2, "Vitor");});
    }

    @Test
    public void searchPessoaByIdTest() {
        Pessoa vitor = globoFilmes.createPessoa(3, "Vitor");
        assertEquals(vitor, globoFilmes.searchPessoaById(3));
    }

    @Test
    public void trySearchPessoaByIdNonExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.searchPessoaById(999);});
    }

    @Test
    public void searchProjetoByIdTest() {
        Projeto queroDormir = globoFilmes.createProjeto(3, "Estou com sono", 2024);
        assertEquals(queroDormir, globoFilmes.searchProjetoById(3));
    }

    @Test
    public void trySearchProjetoByIdNonExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.searchProjetoById(999);});
    }

    @Test
    public void creatTrilhaSonoraTest() {
        assertNotNull(globoFilmes.createTrilhaSonora(1, "Birulaibe"));
    }

    @Test
    public void tryCreateTrilhaSonoraAlreadyExistingTest() {
        globoFilmes.createTrilhaSonora(2, "Som de matraca");
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.createTrilhaSonora(2, "Som de matraca");});
    }

    @Test
    public void searchTrilhaSonoraByIdTest() {
        TrilhaSonora objetivo = globoFilmes.createTrilhaSonora(3, "Som de carro capotando 7 vezes");
        assertEquals(objetivo, globoFilmes.searchTrilhaSonoraById(3));
    }

    @Test
    public void trySearchTrilhaSonoraByIdNonExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {globoFilmes.searchTrilhaSonoraById(999);});
    }
}
