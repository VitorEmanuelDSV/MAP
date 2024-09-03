import entities.*;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Gabriel");

        // Remover depois e colocar no padrão creator
        PapelIF passageiro = new Passageiro();
        PapelIF tripulante = new Tripulante();
        PapelIF agente = new Agente();

        pessoa.adicionaPapel(passageiro);

        System.out.println(
                pessoa.infoPapeis()
        );

        pessoa.adicionaPapel(tripulante);

        System.out.println(
                pessoa.infoPapeis()
        );



    }

}
