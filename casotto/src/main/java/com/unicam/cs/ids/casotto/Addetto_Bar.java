package com.unicam.cs.ids.casotto;

import java.util.ArrayList;

public class Addetto_Bar extends Utente {
	private int id_addbar;
	private String email;
	private String nome;
	private String cognome;
	public ArrayList<Preparazione_Ordine> prepara = new ArrayList<Preparazione_Ordine>();


	public Addetto_Bar(String username, String password, String ruolo, int id_addbar, String email, String nome, String cognome) {
		super(username, password, ruolo, email);
		this.id_addbar = id_addbar;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
	}

	public boolean PreparaOrdine(int id_prenotazione){
		return false;
	}

	public int getId_addbar() {
		return id_addbar;
	}

	public void setId_addbar(int id_addbar) {
		this.id_addbar = id_addbar;
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