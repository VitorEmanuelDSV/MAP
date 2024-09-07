import controllers.GloboFilmes;
import relationships.FuncionarioPapeis;

public class Main {

    public static void main(String[] args) {

        GloboFilmes globoFilmes = new GloboFilmes();

        globoFilmes.createFuncionario(1, "Gabriel");

        globoFilmes.createProjeto(1,1, "Teste", 2024);

        GloboFilmes.searchProjetoById(1).createFuncionarioPapel(1, FuncionarioPapeis.createAtor());

        System.out.println(
                GloboFilmes.searchProjetoById(1).searchFuncionarioPapelById(1).getPapeis()
        );

    }

}
