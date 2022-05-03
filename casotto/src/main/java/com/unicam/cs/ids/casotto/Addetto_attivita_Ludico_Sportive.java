package com.unicam.cs.ids.casotto;

import java.util.ArrayList;

public class Addetto_attivita_Ludico_Sportive extends Utente {
	private int id_addetto_attivita;
	private int id_attivita;
	private String email;
	private String nome;
	private String cognome;
	public ArrayList<Prenotazione_Attivita> registra = new ArrayList<Prenotazione_Attivita>();

	public void AddettoAttivitaLudicoSportive() {
		throw new UnsupportedOperationException();
	}

	public Addetto_attivita_Ludico_Sportive(String username, String password, String ruolo, String email, String nome, String cognome, int id_ombrellone) {
		super(username, password, ruolo, email, nome, cognome, id_ombrellone);
		//this.id_attivita = id_attivita;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId_attivita() {
		return id_attivita;
	}

	public void setId_attivita(int id_attivita) {
		this.id_attivita = id_attivita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

}