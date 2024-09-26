package test.java.relationships;

import controllers.GloboFilmes;
import org.junit.Test;
import relationships.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ProjetoTest {

    GloboFilmes globoFilmes = new GloboFilmes();

    @Test
    public void creatFuncionarioTest() {
        globoFilmes.createProjeto(15, "Não sei mais nenhum nome", 2025);
        globoFilmes.createPessoa(15, "Vitor Emanuel");

        assertNotNull(GloboFilmes.searchProjetoById(15).createFuncionario(15, new ArrayList<>(List.of())));
    }

    @Test
    public void tryCreatFuncionarioAlredyExistentTest() {
        assertThrows(IllegalArgumentException.class, () -> {GloboFilmes.searchProjetoById(15).createFuncionario(15, new ArrayList<>(List.of()));});
    }

    @Test
    public void removeFuncionarioTest() {
        globoFilmes.createProjeto(16, "Era só fechar a IDE...", 2025);
        globoFilmes.createPessoa(16, "Vitor Emanuel");
        GloboFilmes.searchProjetoById(16).createFuncionario(16, new ArrayList<>(List.of()));

        assertNotNull(GloboFilmes.searchProjetoById(16).removeFuncionario(16));
    }

    @Test
    public void tryRemoveFuncionarioNonExistingTest() {
        assertThrows(NoSuchElementException.class, () -> {GloboFilmes.searchProjetoById(16).removeFuncionario(999);});
    }

    @Test
    public void searchFuncionarioByIdTest() {
        globoFilmes.createProjeto(17, "Como capotar uma pessoa", 2025);
        globoFilmes.createPessoa(17, "Vitor Emanuel");

        Funcionario funcionario = GloboFilmes.searchProjetoById(17).createFuncionario(17, new ArrayList<>(List.of()));
        assertEquals(funcionario, GloboFilmes.searchProjetoById(17).searchFuncionarioById(17));
    }

    @Test
    public void trySearchFuncionarioByIdNonExistingTest() {
        assertThrows(IllegalArgumentException.class, () -> {GloboFilmes.searchProjetoById(17).searchFuncionarioById(999);});
    }
}
