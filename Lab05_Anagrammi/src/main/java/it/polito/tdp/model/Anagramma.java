package it.polito.tdp.model;

public class Anagramma {
	
	private String parola;
	private boolean esiste;
	
	public Anagramma(String parola, boolean esiste) {
		super();
		this.parola = parola;
		this.esiste = esiste;
	}
	
	public Anagramma(String parola) {
		this.parola = parola;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public boolean isEsiste() {
		return esiste;
	}

	public void setEsiste(boolean esiste) {
		this.esiste = esiste;
	}

	@Override
	public String toString() {
		return parola;
	}

}
