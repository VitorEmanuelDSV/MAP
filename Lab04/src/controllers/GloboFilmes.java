package controllers;


import entities.Funcionario;
import relationships.Projeto;

import java.util.ArrayList;

public class GloboFilmes {

    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static ArrayList<Projeto> projetos = new ArrayList<>();

    public GloboFilmes() {}

    public void createProjeto(int id, int filmId, String nome, int dataDeLancamento) {
        Projeto ifProjetoExistente = searchProjetoById(id);

        if (ifProjetoExistente != null) {
            throw new IllegalArgumentException("Projeto de id " + id + " já existente!");
        }

        projetos.add(new Projeto(id, Projeto.createFilm(filmId, nome, dataDeLancamento)));
    }

    public void createFuncionario(int id, String nome) {
        Funcionario ifFuncionarioExistente = searchFuncionarioById(id);

        if (ifFuncionarioExistente != null) {
            throw new IllegalArgumentException("Funcionário de id " + id + " já existente!");
        }

        funcionarios.add(new Funcionario(id, nome));
    }

    public static Funcionario searchFuncionarioById(int id) {
        for(Funcionario funcionario : funcionarios) {
            if(funcionario.getId() == id) return funcionario;
        }

        return null;
    }

    public static Projeto searchProjetoById(int id) {
        for(Projeto projeto : projetos) {
            if(projeto.getId() == id) return projeto;
        }

        return null;
    }

    // Getters and Setters

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
