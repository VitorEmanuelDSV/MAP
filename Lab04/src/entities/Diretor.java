package entities;

public class Diretor implements FuncaoIF {

	public Diretor() {}

	public Diretor createDiretor() {
		return new Diretor();
	}

	@Override
	public String getNome() {
		return "Diretor";
	}

}
