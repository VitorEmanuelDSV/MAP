package controllers;


import entities.Pessoa;
import entities.TrilhaSonora;
import relationships.Funcionario;
import relationships.Projeto;

import java.util.ArrayList;

public class GloboFilmes {

    private static ArrayList<Pessoa> pessoas = new ArrayList<>();
    private static ArrayList<Projeto> projetos = new ArrayList<>();
    private static ArrayList<TrilhaSonora> trilhas = new ArrayList<>();

    public GloboFilmes() {}

    public void createProjeto(int id, String nome, int dataDeLancamento) {
        for(Projeto projeto : projetos) {
            if(projeto.getId() == id)  throw new IllegalArgumentException("Projeto de id " + id + " já existente!");
        }

        projetos.add(new Projeto(id, Projeto.createFilm(nome, dataDeLancamento)));
    }

    public void createPessoa(int id, String nome) {
        for(Pessoa pessoa : pessoas) {
            if(pessoa.getId() == id) throw new IllegalArgumentException("Funcionário de id " + id + " já existente!");;
        }

        pessoas.add(new Pessoa(id, nome));
    }

    // Métodos INFO

    public String infoFilmografiaDeFuncionario(int idFuncionario) {
        StringBuilder filmografia = new StringBuilder();

        for(Projeto projeto : projetos) {
            for(Funcionario funcionario : projeto.getFuncionarios()) {
                if(funcionario.getPessoa().getId() == idFuncionario) {
                    filmografia.append("O funcionário ")
                            .append(funcionario.getPessoa().getNome())
                            .append(" trabalhou no projeto ")
                            .append(projeto.getFilm().getNome())
                            .append(" como: \n")
                            .append(funcionario.infoPapeis())
                            .append("\n");
                }
            }
        }

        return filmografia.toString();
    }

    // Static
    public static Pessoa searchPessoaById(int id) {
        for(Pessoa pessoa : pessoas) {
            if(pessoa.getId() == id) return pessoa;
        }

        throw new IllegalArgumentException("Funcionário de id " + id + " não existente!");
    }

    public static Projeto searchProjetoById(int id) {
        for(Projeto projeto : projetos) {
            if(projeto.getId() == id) return projeto;
        }

        throw new IllegalArgumentException("Projeto de id " + id + " não existente!");
    }

    public static void createTrilhaSonora(int id, String nome) {
        for(TrilhaSonora sonora : trilhas) {
            if(sonora.getId() == id) throw new IllegalArgumentException("Trilha sonora de  " + id + " já existente!");;
        }

        trilhas.add(new TrilhaSonora(id, nome));
    }

    public static TrilhaSonora searchTrilhaSonoraById(int id) {
        for(TrilhaSonora sonora : trilhas) {
            if(sonora.getId() == id) return sonora;
        }

        throw new IllegalArgumentException("Trilha sonora de " + id + " não existente!");
    }

    // Getters and Setters

    public ArrayList<Pessoa> getFuncionarios() {
        return pessoas;
    }

    public ArrayList<Projeto> getProjetos() {
        return projetos;
    }
}
