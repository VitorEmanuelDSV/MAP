package relationships;

import controllers.GloboFilmes;
import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Projeto {

    private int id;
    private Film film;
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public Projeto(int id, Film film) {
        this.id = id;
        this.film = film;
    }

    public Funcionario createFuncionario(int idFuncionario, ArrayList<FuncaoIF> funcoes) {
        this.funcionarios.forEach(funcionario -> {
            if(funcionario.getPessoa().getId() == idFuncionario)
                throw new IllegalArgumentException("O funcionário "+ funcionario.getPessoa().getId() + " já está no projeto de ID " + this.id + "!");
        });

        Pessoa pessoa = GloboFilmes.searchPessoaById(idFuncionario);

        Funcionario newFuncionario = new Funcionario(pessoa, funcoes);
        this.funcionarios.add(newFuncionario);

        return newFuncionario;
    }

    public Funcionario removeFuncionario(int id) {
        for(Funcionario funcionario : this.funcionarios){
            if(funcionario.getPessoa().getId() == id){
                this.funcionarios.remove(this.searchFuncionarioById(id));
                return funcionario;
            }
        }

        throw new NoSuchElementException("O funcionário de id: " + id + " não foi encontrado!");
    }

    public Funcionario searchFuncionarioById(int id) {
        for(Funcionario funcionario : this.funcionarios) {
            if(funcionario.getPessoa().getId() == id) return funcionario;
        }

        throw new IllegalArgumentException("Funcionário de ID " + id + " não está no projeto de id " + this.id + "!");
    }

    public static Film createFilm(String nome, int dataDeLancamento) {
        return new Film(nome, dataDeLancamento);
    }

    // Métodos INFO
    public String infoGeral() {
        StringBuilder geralInfo = new StringBuilder();

        geralInfo
                .append("Nome do filme: ").append(this.film.getNome())
                .append("\n")
                .append("Data de Lançamento: ").append(this.film.getReleaseYear())
                .append("\n")
                .append("Diretor(es): ").append(this.infoDiretores())
                .append("\n")
                .append("Roterista(s): ").append(this.infoRoteiristas())
                .append("\n")
                .append("Elenco: ").append(this.infoElenco())
                .append("\n")
                .append("Trilha Sonora: ").append(this.infoTrilhaSonora()).append("\n");

        return geralInfo.toString();
    }

    public String infoDiretores() {
        StringBuilder diretores = new StringBuilder();

        List<String> nomesDiretores = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            for (FuncaoIF papel : funcionario.getPapeis()) {
                if (papel instanceof Diretor) {
                    nomesDiretores.add(funcionario.getPessoa().getNome());
                    break;
                }
            }
        }

        diretores.append(String.join(", ", nomesDiretores));

        return diretores.toString();
    }

    public String infoRoteiristas() {
        StringBuilder roteiristas = new StringBuilder();

        List<String> nomesRoteiristas = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            for (FuncaoIF papel : funcionario.getPapeis()) {
                if (papel instanceof Roteirista) {
                    nomesRoteiristas.add(funcionario.getPessoa().getNome());
                    break;
                }
            }
        }

        roteiristas.append(String.join(", ", nomesRoteiristas));

        return roteiristas.toString();
    }

    public String infoElenco() {
        StringBuilder elenco = new StringBuilder();

        for (Funcionario funcionario : funcionarios) {
            boolean isFromElenco = funcionario.getPapeis().stream()
                    .anyMatch(papel -> !(papel instanceof Diretor) && !(papel instanceof Roteirista));

            if(isFromElenco) {
                elenco.append(funcionario.getPessoa().getNome()).append(" - ");

                List<String> papeis = new ArrayList<>();

                for (FuncaoIF papel : funcionario.getPapeis()) {
                    if (!(papel instanceof Roteirista) && !(papel instanceof Diretor)) {
                        papeis.add(papel.getNome());
                    }
                }

                elenco.append(String.join(", ", papeis));
            }

        }

        return elenco.toString();
    }

    public String infoTrilhaSonora() {
        StringBuilder trilha = new StringBuilder();

        List<String> sons = new ArrayList<>();

        for (TrilhaSonora som : this.film.getTrilhaSonora()) {
            sons.add(som.getNome());
        }

        trilha.append(String.join(", ", sons));

        return trilha.toString();
    }

    // Getters and Setters
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public int getId() {
        return id;
    }
}
