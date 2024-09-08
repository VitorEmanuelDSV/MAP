package relationships;

import entities.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Funcionario {

    private int id;
    private Pessoa pessoa;
    private ArrayList<FuncaoIF> papeis = new ArrayList<>();

    public Funcionario(Pessoa pessoa, ArrayList<FuncaoIF> papeis) {
        this.pessoa = pessoa;

        this.papeis.addAll(papeis);
    }

    public FuncaoIF adicionaPapel(FuncaoIF papel) {
        for(FuncaoIF funcao : papeis) {
            if(funcao.equals(papel)) {
                throw new IllegalArgumentException("Este funcionário já possui o papel de: " + papel);
            }
        }
        this.papeis.add(papel);
        return papel;
    }

    public FuncaoIF removePapel(String papel) {
        for(FuncaoIF funcao : this.papeis) {
            if(funcao.getNome().equals(papel)) {
                this.papeis.remove(funcao);
                return funcao;
            }
        }

        throw new NoSuchElementException("O papel de: " + papel + " não foi encontrado!");
    }

    // Create de Papéis
    public static Ator createAtor() {
        return new Ator();
    }

    public static Camera createCamera() {
        return new Camera();
    }

    public static Cinegrafista createCinegrafista() {
        return new Cinegrafista();
    }

    public static Diretor createDiretor() {
        return new Diretor();
    }

    public static Roteirista createRoteirista() {
        return new Roteirista();
    }

    // Métodos INFO
    public String infoPapeis() {
        StringBuilder _papeis = new StringBuilder();

        for(FuncaoIF papel : this.papeis ) {
            _papeis.append(papel.getNome()).append("\n");
        }

        return _papeis.toString();
    }

    // Getters and Setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public ArrayList<FuncaoIF> getPapeis() {
        return this.papeis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
