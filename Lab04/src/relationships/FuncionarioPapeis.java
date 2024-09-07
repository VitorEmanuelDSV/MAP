package relationships;

import entities.*;

import java.util.ArrayList;

public class FuncionarioPapeis {

    // Vale a pena implementar ID caso vá reutilizar as mesmas funções de um funcionario em um OUTRO projeto -> Não fazer

    private Funcionario funcionario;
    private ArrayList<FuncaoIF> papeis = new ArrayList<>();

    public FuncionarioPapeis(Funcionario funcionario, FuncaoIF papel) {
        this.funcionario = funcionario;

        this.papeis.add(papel);
    }

    public void adicionaPapel(FuncaoIF papel) {
        this.papeis.add(papel);
    }

    // Create de Papéis
    public static Ator createAtor() {
        return new Ator();
    }

    public Camera createCamera() {
        return new Camera();
    }

    public Cinegrafista createCinegrafista() {
        return new Cinegrafista();
    }

    public Diretor createDiretor() {
        return new Diretor();
    }

    // Info - Obs: Os métodos INFO não precisam de testes
    public String infoPapeis() {
        StringBuilder _papeis = new StringBuilder();

        for(FuncaoIF papel : this.papeis ) {
            _papeis.append(papel.getNome()).append("\n");
        }

        return _papeis.toString();
    }

    // Getters and Setters
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<FuncaoIF> getPapeis() {
        return this.papeis;
    }
}
