package com.unicam.cs.ids.casotto;

public class Gestore extends Utente {
	private String nome;
	private String cognome;
	private String email;
	public Prodotti_Bar gestisce;
	public Chalet unnamed_Chalet_;

	public void definizioneProdotti() {
		throw new UnsupportedOperationException();
	}

	public void definizioneStruttura(Object num_ombrelloni, Object num_lettini) {
		throw new UnsupportedOperationException();
	}

	public void definizioneAttrezzatura() {
		throw new UnsupportedOperationException();
	}

	public void definizioneAttivita() {
		throw new UnsupportedOperationException();
	}

	public void definizionePolitichePrezzi() {
		throw new UnsupportedOperationException();
	}

	public Gestore(String username, String password, String ruolo, String nome, String cognome, String email) {
		super(username, password, ruolo);
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}