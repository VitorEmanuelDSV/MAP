package entities;

public class Cinegrafista implements FuncaoIF {

	public Cinegrafista() {}

	public Cinegrafista createCinegrafista(int id) {
		return new Cinegrafista();
	}

	@Override
	public String getNome() {
		return "Cinegrafista";
	}

}
