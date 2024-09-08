package test.java.relationships;

import controllers.GloboFilmes;
import org.junit.Test;
import relationships.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class FuncionarioTest {

    GloboFilmes globoFilmes = new GloboFilmes();

    @Test
    public void adicionaPapelTest() {
        globoFilmes.createProjeto(12, "Não sei mais nenhum nome", 2025);
        globoFilmes.createPessoa(12, "Vitor Emanuel");
        GloboFilmes.searchProjetoById(12).createFuncionario(12, new ArrayList<>(List.of()));

        assertNotNull(GloboFilmes.searchProjetoById(12).searchFuncionarioById(12).adicionaPapel(Funcionario.createCamera()));
    }

    @Test
    public void adicionaPapelAlredyExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {GloboFilmes.searchProjetoById(12).searchFuncionarioById(12).adicionaPapel(Funcionario.createCamera());});
    }

    @Test
    public void removePapelTest() {
        globoFilmes.createProjeto(13, "Não aguento mais", 2024);
        globoFilmes.createPessoa(13, "Junin");
        GloboFilmes.searchProjetoById(13).createFuncionario(13, new ArrayList<>(List.of(
                Funcionario.createRoteirista()
        )));

        assertNotNull(GloboFilmes.searchProjetoById(13).searchFuncionarioById(13).removePapel(Funcionario.createRoteirista().getNome()));
    }

    @Test
    public void tryRemovePapelNonExistingTest() {
        globoFilmes.createProjeto(14, "Mais um né", 2024);
        globoFilmes.createPessoa(14, "Irineu");
        GloboFilmes.searchProjetoById(14).createFuncionario(14, new ArrayList<>(List.of(
                Funcionario.createDiretor()
        )));

        assertThrows(NoSuchElementException.class, () -> {GloboFilmes.searchProjetoById(14).searchFuncionarioById(14).removePapel(Funcionario.createCamera().getNome());});
    }

    @Test
    public void creatAtorTest() {
        assertNotNull(Funcionario.createAtor());
    }

    @Test
    public void creatCameraTest() {
        assertNotNull(Funcionario.createCamera());
    }

    @Test
    public void createCinegrafistaTest() {
        assertNotNull(Funcionario.createCinegrafista());
    }

    @Test
    public void createDiretorTest() {
        assertNotNull(Funcionario.createDiretor());
    }

    @Test
    public void createRoteiristaTest() {
        assertNotNull(Funcionario.createRoteirista());
    }
}
