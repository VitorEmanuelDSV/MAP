package main;

import controllers.GloboFilmes;
import relationships.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // GloboFilmes
        GloboFilmes globoFilmes = new GloboFilmes();

        // Base Config
        globoFilmes.createPessoa(1, "Gabriel");
        globoFilmes.createPessoa(2, "Mineirinho");
        globoFilmes.createProjeto(1, "As aventuras do verbo to be", 2024);
        globoFilmes.createProjeto(2,"GTA X", 2024);

        // Requisito A
        GloboFilmes.searchProjetoById(1).createFuncionario(1, new ArrayList<>(List.of(
                Funcionario.createAtor(),
                Funcionario.createCamera()
        )));

        // Requisito B
        GloboFilmes.searchProjetoById(2).createFuncionario(1, new ArrayList<>(List.of(
                Funcionario.createAtor(),
                Funcionario.createCinegrafista(),
                Funcionario.createDiretor()
        )));

        System.out.println(globoFilmes.infoFilmografiaDeFuncionario(1));

        // Requisito C
        GloboFilmes.searchProjetoById(2).createFuncionario(2, new ArrayList<>(List.of(
                Funcionario.createDiretor(),
                Funcionario.createAtor(),
                Funcionario.createRoteirista()
        )));

        GloboFilmes.createTrilhaSonora(1, "AUUUUU");

        GloboFilmes.searchProjetoById(2).getFilm().addTrilhaSonora(1);

        System.out.println(
            GloboFilmes.searchProjetoById(2).infoGeral()
        );

        // Extras

        // Remover Trilha Sonora
        GloboFilmes.searchProjetoById(2).getFilm().removeTrilhaSonora(1);

        // Remover um funcionário do filme
        GloboFilmes.searchProjetoById(2).removeFuncionario(2);

        System.out.println(
                GloboFilmes.searchProjetoById(2).infoGeral()
        );

        // Alterar os papéis de um funcionário no filme
        GloboFilmes.searchProjetoById(2).searchFuncionarioById(1).removePapel(
                Funcionario.createAtor().getNome()
        );

        System.out.println(
                GloboFilmes.searchProjetoById(2).infoGeral()
        );
    }
}
