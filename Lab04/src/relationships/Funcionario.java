package relationships;

import entities.*;

import java.util.ArrayList;

public class Funcionario {

    // Vale a pena implementar ID caso vá reutilizar as mesmas funções de um funcionario em um OUTRO projeto -> Não fazer

    private Pessoa pessoa;
    private ArrayList<FuncaoIF> papeis = new ArrayList<>();

    public Funcionario(Pessoa pessoa, ArrayList<FuncaoIF> papeis) {
        this.pessoa = pessoa;

        this.papeis.addAll(papeis);
    }

    public void adicionaPapel(FuncaoIF papel) {
        this.papeis.add(papel);
    }

    public void removePapel(String papel) {
        for(FuncaoIF funcao : this.papeis) {
            if(funcao.getNome().equals(papel)) {
                this.papeis.remove(funcao);
                break;
            }
        }
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
}
