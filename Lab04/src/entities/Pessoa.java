package entities;

import java.util.ArrayList;

public class Pessoa {

	private String id;
	private String nome;
	private ArrayList<PapelIF> papeis;
	
	public Pessoa(String nome) {
		this.setNome(nome);
		this.papeis = new ArrayList<PapelIF>();
	}
	
	public void adicionaPapel(PapelIF papel) {
		this.papeis.add(papel);
	}
	
	// Info
	
	public String infoPapeis() {
		StringBuilder _papeis = new StringBuilder();
		
		for(PapelIF papel : this.papeis ) {
			_papeis.append(papel.getNome()).append("\n");
		}
		
		return _papeis.toString();
	}
	
	// Getters and Setters
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<PapelIF> getPapeis() {
		return this.papeis;
	}

	public void setPapeis(ArrayList<PapelIF> papeis) {
		this.papeis = papeis;
	}

}
