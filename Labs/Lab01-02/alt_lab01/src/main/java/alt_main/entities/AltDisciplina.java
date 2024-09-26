package alt_main.entities;

import alt_main.bd.AlunosBD;
import alt_main.models.Areas;

import java.util.ArrayList;

public class AltDisciplina {

    public int id;
    public String nome;
    public String horario;
    public Areas curso;
    public int periodo;
    public String serie;

    public int professorId;
    public ArrayList<Integer> alunosIds = new ArrayList<Integer>();

    public AltDisciplina(int id, String nome, String horario, Areas curso, int periodo) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.curso = curso;
        this.periodo = periodo;
    }

    public AltDisciplina(int id, String nome, String horario, String serie) {
        this.id = id;
        this.nome = nome;
        this.horario = horario;
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setProfessorResponsavel(int professorId) {
        this.professorId = professorId;
    }

    public void adicionaAluno(int alunoId) {
        alunosIds.add(alunoId);
    }

    public void removeAluno(int alunoId) {
        alunosIds.remove(alunoId);
    }

    public int getNumeroDeAlunos() {
        return alunosIds.size();
    }

    public String getAlunos() {
        StringBuilder alunosMatriculados = new StringBuilder();

        for(int alunoId : alunosIds) {
            AltAluno aluno = AlunosBD.getAlunoByMatricula(alunoId);
            alunosMatriculados.append(aluno.getNome()).append("\n");
        }

        return alunosMatriculados.toString();

    }

}
