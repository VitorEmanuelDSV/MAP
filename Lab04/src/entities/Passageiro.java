package entities;

public class Passageiro implements PapelIF {

	private String id;

	@Override
	public String getNome() {
		return "Passageiro";
	}

	// Getters e setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
