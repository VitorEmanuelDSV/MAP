package entities;

public class Agente implements PapelIF {

	private String id;

	@Override
	public String getNome() {
		return "";
	}

	// Getters e setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
