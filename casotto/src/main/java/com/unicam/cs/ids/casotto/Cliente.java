package com.unicam.cs.ids.casotto;

import java.util.ArrayList;

public class Cliente extends Utente {
	private String nome;
	private String cognome;
	private String email;
	private int id_ombrellone;
	public ArrayList<Prenotazione_Spiaggia> effettua = new ArrayList<Prenotazione_Spiaggia>();


	public void PrenotazioneOmbrellone(Object aData_inizio) {
		throw new UnsupportedOperationException();
	}

	public void IscrizioneAttivita(String aNome, String aCognome) {
		throw new UnsupportedOperationException();
	}

	public Cliente(String username, String password, String ruolo, String nome, String cognome, String email, int id_ombrellone) {
		super(username, password, ruolo);
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.id_ombrellone = id_ombrellone;
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

	public int getId_ombrellone() {
		return id_ombrellone;
	}

	public void setId_ombrellone(int id_ombrellone) {
		this.id_ombrellone = id_ombrellone;
	}
}