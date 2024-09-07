package relationships;

import controllers.GloboFilmes;
import entities.Film;
import entities.FuncaoIF;
import entities.Funcionario;

import java.util.ArrayList;

public class Projeto {

    private int id;
    private Film film;
    private static ArrayList<FuncionarioPapeis> funcionarioPapeis = new ArrayList<>();

    public Projeto(int id, Film film) {
        this.id = id;
        this.film = film;
    }

    public FuncionarioPapeis createFuncionarioPapel(int idFuncionario, FuncaoIF funcao) {
        funcionarioPapeis.forEach(funcionario -> {
            if(funcionario.getFuncionario().getId() == idFuncionario) throw new IllegalArgumentException("O funcionário já está no Projeto!");
        });

        Funcionario funcionario = GloboFilmes.searchFuncionarioById(idFuncionario);

        if (funcionario != null) {
            FuncionarioPapeis newFuncionario = new FuncionarioPapeis(funcionario, funcao);
            funcionarioPapeis.add(newFuncionario);

            return newFuncionario;
        } else {
            throw new IllegalArgumentException("Funcionário de ID " + idFuncionario + " não existente!");
        }

    }

    public void removeFuncionario(int id) {
        funcionarioPapeis.forEach(funcionario -> {
            if(funcionario.getFuncionario().getId() == id) {
                funcionarioPapeis.remove(funcionario);
            }
        });
    }

    public FuncionarioPapeis searchFuncionarioPapelById(int id) {
        for(FuncionarioPapeis funcionario : funcionarioPapeis) {
            if(funcionario.getFuncionario().getId() == id) return funcionario;
        }

        return null;
    }

    public static Film createFilm(int id, String nome, int dataDeLancamento) {
        return new Film(id, nome, dataDeLancamento);
    }

    // Info
    public String infoFuncionarios() {
        StringBuilder _funcionarios = new StringBuilder();

        funcionarioPapeis.forEach(funcionario -> {
            _funcionarios.append(funcionario.getFuncionario().getNome()).append("\n");
        });

        return _funcionarios.toString();
    }

    public String infoPapeisPerFuncionario() {
        StringBuilder _funcionarios = new StringBuilder();

        funcionarioPapeis.forEach(funcionario -> {
            _funcionarios.append(funcionario.getFuncionario().getNome()).append("\n");
            for (FuncaoIF papel : funcionario.getPapeis()) {
                _funcionarios.append(papel.getNome()).append("\n");
            }
        });


        return _funcionarios.toString();
    }

    // Getters and Setters
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public ArrayList<FuncionarioPapeis> getFuncionarios() {
        return funcionarioPapeis;
    }

    public int getId() {
        return id;
    }
}
