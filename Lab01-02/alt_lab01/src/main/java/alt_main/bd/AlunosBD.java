package alt_main.bd;

import alt_main.entities.AltAluno;
import alt_main.models.Areas;

import java.util.ArrayList;

public class AlunosBD {

    public static ArrayList<AltAluno> alunos;

    public AlunosBD() {
        alunos = new ArrayList<>();

        alunos.add(new AltAluno(1, "Gabriel Calebe", Areas.COMPUTACAO));
        alunos.add(new AltAluno(2, "Vitor Emanuel", Areas.COMPUTACAO));
        alunos.add(new AltAluno(3, "Luiz Manuel", Areas.MATEMATICA));

    }

    public static AltAluno getAlunoByMatricula(int matricula) {
        for (AltAluno aluno : alunos) {
            if(aluno.matricula == matricula) {
                return aluno;
            }
        }

        return null;
    }

}
