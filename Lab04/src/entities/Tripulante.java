package entities;

public class Tripulante implements PapelIF {

	private String id;

	@Override
	public String getNome() {
		return "Tripulante";
	}

	// Getters e setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
