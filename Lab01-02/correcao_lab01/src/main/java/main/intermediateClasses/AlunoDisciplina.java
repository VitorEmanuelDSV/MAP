package main.intermediateClasses;

import main.entities.Aluno;
import main.entities.Disciplina;
import main.entities.RDM;
import main.models.StatusDisciplina;

import java.util.ArrayList;

import java.util.NoSuchElementException;

public class AlunoDisciplina extends Disciplinas {
    private final StatusDisciplina status;
    private Aluno aluno;
    private Disciplina disciplina;
    private RDM rdm;

    private final ArrayList<Aluno> alunos = new ArrayList<>();
    public final ArrayList<AlunoDisciplina> matriculas = new ArrayList<>();

    public AlunoDisciplina(Aluno aluno, Disciplina disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.status = StatusDisciplina.CURSANDO;
        this.rdm = new RDM();
    }

    public void addAluno(String nome, int matricula, String email){
        this.alunos.add(new Aluno(nome, matricula, email));
    }

    public void removeAluno(int matricula) {
        this.alunos.remove(this.getAlunoByMatricula(matricula));
    }

    public void associarAlunoADisciplina(Aluno aluno, Disciplina disciplina) {

        if(this.verificaVagasNaDisciplina(disciplina) >= disciplina.getNumVagas())
            throw new IllegalStateException("A disciplina " + disciplina.getNome() + " não tem mais vagas.");

        AlunoDisciplina alunoToAdd = new AlunoDisciplina(aluno, disciplina);

        for(AlunoDisciplina matricula : this.matriculas) {
            if(
                matricula.getDisciplina() ==  disciplina
                && matricula.getAluno() == aluno
            )  throw new IllegalStateException("O aluno " + alunoToAdd.getAluno().getNome() + " já está matriculado na disciplina " + alunoToAdd.getDisciplina().getNome() + ".");
        }

        this.matriculas.add(alunoToAdd);
    }

    public void removerAlunoADisciplina(Aluno aluno, Disciplina disciplina) {
        AlunoDisciplina alunoToRemove = new AlunoDisciplina(aluno, disciplina);

        for(AlunoDisciplina matricula : matriculas) {
            if((matricula.getDisciplina() ==  disciplina && matricula.getAluno() == aluno)) {
                matriculas.remove(matricula);
                return;
            }
        }

        throw new IllegalStateException("O aluno " + alunoToRemove.getAluno().getNome() + " não está matriculado na disciplina " + alunoToRemove.getDisciplina().getNome() + ".");

    }

    // C
    public ArrayList<Aluno> alunosDaDisciplina(int codigo) {
        ArrayList<Aluno> alunosNaDisciplina = new ArrayList<>();

        for (AlunoDisciplina matricula : matriculas) {
            if (matricula.getDisciplina().equals(getDisciplinaByCodigo(codigo))) {
                alunosNaDisciplina.add(matricula.getAluno());
            }
        }

        return alunosNaDisciplina;
    }

    // D
    public ArrayList<Disciplina> disciplinasDoAluno(int id) {
        ArrayList<Disciplina> disciplinasDoAluno = new ArrayList<>();

        for (AlunoDisciplina matricula : matriculas) {
            if (matricula.getAluno().equals(this.getAlunoByMatricula(id))) {
                disciplinasDoAluno.add(matricula.getDisciplina());
            }
        }

        return disciplinasDoAluno;
    }

    // F
    public int numeroDeAlunosNaDisciplina(int codigo) {
        return alunosDaDisciplina(codigo).size();
    }

    // Utils

    public int indexMatricula(AlunoDisciplina matricula) {
        if(matriculas.contains(matricula)) return matriculas.indexOf(matricula);
        else
            throw new IllegalStateException("Matrícula não encontrada");

    }

    public int verificaVagasNaDisciplina(Disciplina disciplina) {
        int vagas = 0;

        for(AlunoDisciplina matricula : matriculas) {
            if(matricula.getDisciplina() == disciplina) vagas++;
        }

        return vagas;
    }

    public Aluno getAlunoByMatricula(int matricula){
        for(Aluno aluno : alunos) {
            if(aluno.getMatricula() == matricula) return aluno;
        }
        throw new NoSuchElementException("Aluno não encontrado!");
    }

    public void printAlunosDisciplina(int codigo) {
        for (Aluno aluno : this.alunosDaDisciplina(codigo)) {
            System.out.println(aluno.getNome());
        }
    }

    public void printDisciplinasAluno(int matricula) {
        for (Disciplina disciplina : this.disciplinasDoAluno(matricula)) {
            System.out.println(disciplina.getNome());
        }
    }

    // Getters and Setters

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
