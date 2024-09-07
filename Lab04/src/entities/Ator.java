package entities;

public class Ator implements FuncaoIF {

	public Ator() {}

	public Ator createAtor(int id) {
		return new Ator();
	}

	@Override
	public String getNome() {
		return "Ator";
	}

}
